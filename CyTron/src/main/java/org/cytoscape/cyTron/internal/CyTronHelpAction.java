package org.cytoscape.cyTron.internal;

import java.awt.event.ActionEvent;
import org.cytoscape.application.swing.AbstractCyAction;
import org.cytoscape.util.swing.OpenBrowser;

public class CyTronHelpAction extends AbstractCyAction {
    
    private OpenBrowser openBrowser;

    public CyTronHelpAction(OpenBrowser openBrowser) {
        super("Help ");
        this.openBrowser = openBrowser;
        setPreferredMenu("Apps.CyTron");
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        openBrowser.openURL("https://sites.google.com/site/troncopackage/");
    }
}
