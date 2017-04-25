package org.cytoscape.cyTron.internal.task;

import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class CBioPortalTask extends AbstractTask{
    
    private final CyServiceRegistrar cyRegistrar;
    public CBioPortalTask(CyServiceRegistrar cyRegistrar) {
        this.cyRegistrar = cyRegistrar;
    }
    
    @Override
    public void run(TaskMonitor taskMonitor) {
        //Create a GUI for interacting with CBioPortal and to,fro with R
    }
}
