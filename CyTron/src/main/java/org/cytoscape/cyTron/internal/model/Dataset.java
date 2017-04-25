package org.cytoscape.cyTron.internal.model;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class Dataset {
    private InputType inputType;
    private final String name;
    private final File file;
    private HashSet<Event> events;
    private final HashSet<Sample> samples;

    public HashSet<Sample> getSamples() {
        return samples;
    }

    public HashSet<Event> getEvents() {
        return events;
    }
    
    public Dataset(RConnection connection, String name, File file, InputType type) throws RserveException, IOException {

        String trimmedName = name.trim();

        if (trimmedName.length() == 0 || trimmedName.contains(" ")) {
            throw new RserveException(connection, "Rserve: invalid dataset name");
        }

        if (!file.exists()) {
            throw new IOException("IO Error: File not found");
        }

        this.name = trimmedName;
        this.file = file;

        if (!connection.isConnected()) {
            throw new RserveException(connection, "Rserve: not connected");
        }

        switch (type) {
            case MAF:
                initMAF(trimmedName, file);
                break;
            case GISTIC:
                initGISTIC(trimmedName, file);
                break;
        }

        //this.events = retrieveEvents();
        this.samples = null;
    }
    
    
    private void initMAF(String name, File file) throws RserveException, IOException {

        String fileName = name + ".file";
        ConnectionManager.eval(fileName + " = '" + file.getCanonicalPath() + "'");

        // import.MAF
        try {
            ConnectionManager.eval(name + " = import.MAF(file = " + fileName + ", is.TCGA = TRUE, sep = ';')");
        } catch (RserveException ex) {
            throw new RserveException(ConnectionManager.getConnection(), "Rserve: import.MAF failed");
        }

        // check if the R object was correctly loaded
        if (!ConnectionManager.existsInR(name)) {
            throw new RserveException(ConnectionManager.getConnection(), "Rserve: import.MAF failed");
        }
    }

    private void initGISTIC(String name, File file) throws RserveException, IOException {
        String fileName = name + ".file";
        ConnectionManager.eval(fileName + " = '" + file.getCanonicalPath() + "'");

        try {
            // read table from file
            ConnectionManager.eval("GISTIC.table = read.table(" + fileName + ", check.names=FALSE, stringsAsFactors=FALSE, header=TRUE)");

            // custom preprocessing
            ConnectionManager.eval("GISTIC.table$Entrez_Gene_Id = NULL");
            ConnectionManager.eval("rownames(GISTIC.table) = GISTIC.table$Hugo_Symbol");
            ConnectionManager.eval("GISTIC.table$Hugo_Symbol = NULL");

            // import.GISTIC
            ConnectionManager.eval(name + " = import.GISTIC( t(GISTIC.table) )");
            
            int x = 0;
            try {
                x = ConnectionManager.eval("ngenes("+fileName+")").asInteger();
            } catch (REXPMismatchException ex) {
                Logger.getLogger(Dataset.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("number is " + x);
        } catch (RserveException ex) {
            throw new RserveException(ConnectionManager.getConnection(), "Rserve: import.GISTIC failed");
        }

        // check if the R object was correctly loaded
        if (!ConnectionManager.existsInR(name)) {
            throw new RserveException(ConnectionManager.getConnection(), "Rserve: import.GISTIC failed");
        }

    }
}
