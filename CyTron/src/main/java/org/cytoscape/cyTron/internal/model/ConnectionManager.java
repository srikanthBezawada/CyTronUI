package org.cytoscape.cyTron.internal.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class ConnectionManager {

    private static RConnection connection;

    public static RConnection getConnection() {
        return connection;
    }

    public static void setConnection(RConnection connection) {
        ConnectionManager.connection = connection;
    }

    public static void setupConnection() throws RserveException {
        RConnection c = new RConnection();
        c.eval("R.version.string");
        setConnection(c);
    }

    public static void closeConnection() throws RserveException {
        ConnectionManager.connection.close();
    }

    public static void loadTRONCO() throws RserveException {
        RConnection c = connection;

        if (c == null) {
            throw new RserveException(c, "Rserve: Not found");
        }

        try {
            if (!c.eval("tmp  <- require('TRONCO')").asString().equals("TRUE")) {
                throw new RserveException(c, "Rserve: TRONCO cannot be loaded!");
            }
        } catch (REXPMismatchException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    public static String[] paletteList() throws RserveException {
        String[] result;
        try {
            REXP output = ConnectionManager.connection.eval("rownames(brewer.pal.info)");
            result = output.asStrings();
        } catch (RserveException | REXPMismatchException ex) {
            Logger.getLogger(Dataset.class.getName()).log(Level.SEVERE, null, ex);
            result = null;
        }
        return result;
    }
    */


    public static boolean existsInR(String var) throws RserveException {
        RConnection c = connection;
        try {
            return c.eval("exists(\"" + var + "\")").asString().equals("TRUE");
        } catch (REXPMismatchException exc) {
            // this cannot happen, since exists always return a string
            // Something has gone horribly wrong, so we just give up.
            System.exit(42);
        }

        return false; // HUM?
    }
    
    public static REXP eval(String command) throws RserveException {
        RConnection c = connection;
        REXP output = c.eval(command);
        return output;
    }
}
