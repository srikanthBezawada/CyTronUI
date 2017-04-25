package org.cytoscape.cyTron.internal.task;

import org.cytoscape.cyTron.internal.model.InputType;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.application.swing.CytoPanel;
import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.cyTron.internal.view.CyTronGui;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.ProvidesTitle;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;

public class BooleanMatrixReaderTask extends AbstractTask{
    @Tunable (description="Boolean Matrix File", required=true, params="input=true", gravity=1.0)
    public File booleanMatrixFile;
    
    private final CyServiceRegistrar cyRegistrar;
    public BooleanMatrixReaderTask(CyServiceRegistrar cyRegistrar) {
        this.cyRegistrar = cyRegistrar;
    }
    
    @Override
    public void run(TaskMonitor taskMonitor) {
        if(booleanMatrixFile != null) {
            // Get an input stream
            BufferedReader gisticReader;

            try {
                gisticReader = new BufferedReader(new FileReader(booleanMatrixFile));
            } catch(FileNotFoundException fnf) {
                taskMonitor.showMessage(TaskMonitor.Level.ERROR, "Can't find the file '"+booleanMatrixFile.getName()+"'");
                return;
            }
            
            CySwingApplication swingApplication = cyRegistrar.getService(CySwingApplication.class);
            CytoPanel cytoPanel = swingApplication.getCytoPanel(CytoPanelName.WEST);
            CyTronGui ui;
            
            if(getMainPanel(swingApplication, cytoPanel) != null) {
                ui = getMainPanel(swingApplication, cytoPanel);
                cyRegistrar.unregisterService(ui, CytoPanelComponent.class);
            }
            synchronized(this) {
                ui = new CyTronGui(cyRegistrar, InputType.GISTIC, booleanMatrixFile);
                cyRegistrar.registerService(ui, CytoPanelComponent.class, new Properties());
                int index = cytoPanel.indexOfComponent(ui);
                cytoPanel.setSelectedIndex(index);
            }
            
        }
    }
    
    public CyTronGui getMainPanel(CySwingApplication swingApplication, CytoPanel cytoPanel){
        int count = cytoPanel.getCytoPanelComponentCount();
        for (int i = 0; i < count; i++) {
            final Component comp = cytoPanel.getComponentAt(i);
            if (comp instanceof CyTronGui)
                return (CyTronGui) comp;
            }
        return null;
    }
    
    @ProvidesTitle
    public String getTitle() {return "Boolean Matrix Importer";}
    
}
