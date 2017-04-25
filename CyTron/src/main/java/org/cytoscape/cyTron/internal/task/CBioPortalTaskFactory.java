package org.cytoscape.cyTron.internal.task;

import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class CBioPortalTaskFactory implements TaskFactory{
    public final CyServiceRegistrar cyRegistrar;
    
    public CBioPortalTaskFactory(CyServiceRegistrar cyRegistrar) {
        this.cyRegistrar = cyRegistrar;
    }
    
    @Override
    public TaskIterator createTaskIterator() {
        return new TaskIterator(new CBioPortalTask(cyRegistrar));
    }

    @Override
    public boolean isReady() {
        return true; 
    }
    
}
