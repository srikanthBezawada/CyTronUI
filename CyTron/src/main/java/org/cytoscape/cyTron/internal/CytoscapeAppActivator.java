package org.cytoscape.cyTron.internal;

import org.cytoscape.cyTron.internal.task.CBioPortalTaskFactory;
import org.cytoscape.cyTron.internal.task.BooleanMatrixReaderTaskFactory;
import org.cytoscape.cyTron.internal.task.GisticReaderTaskFactory;
import org.cytoscape.cyTron.internal.task.MafReaderTaskFactory;
import java.util.Properties;
import org.cytoscape.application.swing.CyAction;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.cytoscape.util.swing.OpenBrowser;
import static org.cytoscape.work.ServiceProperties.PREFERRED_MENU;
import static org.cytoscape.work.ServiceProperties.TITLE;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;

public class CytoscapeAppActivator extends AbstractCyActivator{
    public CytoscapeAppActivator() {
        super();
    }

    public void start(BundleContext bc) {
        final CyServiceRegistrar serviceRegistrar = getService(bc, CyServiceRegistrar.class);
        
        final MafReaderTaskFactory mafReaderFactory = new MafReaderTaskFactory(serviceRegistrar);
        final GisticReaderTaskFactory gisticReaderFactory = new GisticReaderTaskFactory(serviceRegistrar);
        final BooleanMatrixReaderTaskFactory bmReaderFactory = new BooleanMatrixReaderTaskFactory(serviceRegistrar);
        final CBioPortalTaskFactory cBioReaderFactory = new CBioPortalTaskFactory(serviceRegistrar);
        
        
        Properties mafReaderProps = new Properties();
        mafReaderProps.setProperty(PREFERRED_MENU, "Apps.CyTron");
        mafReaderProps.setProperty(TITLE, "Import MAF files");
        registerService(bc, mafReaderFactory, TaskFactory.class, mafReaderProps);
        
        Properties gisticReaderProps = new Properties();
        gisticReaderProps.setProperty(PREFERRED_MENU, "Apps.CyTron");
        gisticReaderProps.setProperty(TITLE, "Import GISTIC files");
        registerService(bc, gisticReaderFactory, TaskFactory.class, gisticReaderProps);
        
        Properties bmReaderProps = new Properties();
        bmReaderProps.setProperty(PREFERRED_MENU, "Apps.CyTron");
        bmReaderProps.setProperty(TITLE, "Import Boolean Matrix");
        registerService(bc, bmReaderFactory, TaskFactory.class, bmReaderProps);
        
        Properties cBioReaderProps = new Properties();
        cBioReaderProps.setProperty(PREFERRED_MENU, "Apps.CyTron");
        cBioReaderProps.setProperty(TITLE, "Import from cBioPortal");
        registerService(bc, cBioReaderFactory, TaskFactory.class, cBioReaderProps);
        
        OpenBrowser openBrowser = getService(bc, OpenBrowser.class);
        CyTronHelpAction helpAction = new CyTronHelpAction(openBrowser);
        registerService(bc, helpAction, CyAction.class, new Properties());
        
    }
}
