package org.cytoscape.cyTron.internal.task;

import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class GisticReaderTaskFactory implements TaskFactory{
    
    public final CyServiceRegistrar cyRegistrar;
    
    public GisticReaderTaskFactory(CyServiceRegistrar cyRegistrar) {
        this.cyRegistrar = cyRegistrar;
    }
    
    @Override
    public TaskIterator createTaskIterator() {
            return new TaskIterator(new GisticReaderTask(cyRegistrar));
    }

    @Override
    public boolean isReady() {
        return true; 
    }
}
