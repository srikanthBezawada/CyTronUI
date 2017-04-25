package org.cytoscape.cyTron.internal.task;

import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class MafReaderTaskFactory implements TaskFactory{
    
    public final CyServiceRegistrar cyRegistrar;
    
    public MafReaderTaskFactory(final CyServiceRegistrar cyRegistrar) {
        this.cyRegistrar = cyRegistrar;
    }
    
    @Override
    public TaskIterator createTaskIterator() {
            return new TaskIterator(new MafReaderTask(cyRegistrar));
    }

    @Override
    public boolean isReady() {
        return true; 
    }
    
}
