package org.cytoscape.cyTron.internal.task;

import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.work.TaskFactory;
import org.cytoscape.work.TaskIterator;

public class BooleanMatrixReaderTaskFactory implements TaskFactory{
    
    public final CyServiceRegistrar cyRegistrar;
    
    public BooleanMatrixReaderTaskFactory(CyServiceRegistrar cyRegistrar) {
        this.cyRegistrar = cyRegistrar;
    }
    
    @Override
    public TaskIterator createTaskIterator() {
            return new TaskIterator(new BooleanMatrixReaderTask(cyRegistrar));
    }

    @Override
    public boolean isReady() {
        return true; 
    }
}
