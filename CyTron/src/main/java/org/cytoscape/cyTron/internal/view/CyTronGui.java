package org.cytoscape.cyTron.internal.view;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.commons.io.IOUtils;

import org.cytoscape.application.swing.CytoPanelComponent;
import org.cytoscape.application.swing.CytoPanelName;
import org.cytoscape.cyTron.internal.model.ConnectionManager;
import org.cytoscape.cyTron.internal.model.Dataset;
import org.cytoscape.cyTron.internal.model.InputType;
import org.cytoscape.service.util.CyServiceRegistrar;
import org.rosuda.REngine.REXP;


import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RFileInputStream;
import org.rosuda.REngine.Rserve.RFileOutputStream;
import org.rosuda.REngine.Rserve.RserveException;

/**
 * @author SrikanthB
 */

public class CyTronGui extends javax.swing.JPanel implements CytoPanelComponent{
    
    private CyServiceRegistrar cyRegistrar;
    private InputType inputType;
    private BufferedReader bReader;
    private File file;

    public CyTronGui(CyServiceRegistrar cyRegistrar, InputType inputType, File file) {
        this.cyRegistrar = cyRegistrar;
        this.inputType = inputType;
        this.file = file;
        initComponents();
        bootRconnection();
        
    }
    
    @Override
    public Icon getIcon() {
        return null;
    }
    
    @Override
    public String getTitle() {
        return "CyTron";
    }
    
    @Override
    public CytoPanelName getCytoPanelName() {
        return CytoPanelName.WEST;
    }
    
    @Override
    public Component getComponent() {
        return this;
    }
    
    
    
    
    
    
    
    
    
    
    
    public void bootRconnection() {
        try {
            ConnectionManager.setupConnection();
            ConnectionManager.loadTRONCO();
        } catch (RserveException ex) {
            System.out.println("Rserve is not running!");
        }
        /*
        RConnection connection = null;
        
        try {
            // 6311 default port 
            connection = new RConnection();
            if(connection.isConnected()) {
                rStatus.setText("YES");
                //rStatus.setForeground(Color.green);
                // Enable menus
            } else {
                rStatus.setText("NO");
                //rStatus.setForeground(Color.red);
                // disable menus
            }
            String vector = "c(1,2,3,4)";
            connection.eval("meanVal=mean(" + vector + ")");
            double mean = connection.eval("meanVal").asDouble();
            System.out.println("The mean of given vector is=" + mean);
         } catch (RserveException e) {
            e.printStackTrace();
         } catch (REXPMismatchException e) {
            e.printStackTrace();
         }finally{
             connection.close();
         }
        */
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneForUI = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        headingLabel = new javax.swing.JLabel();
        bootstrapPanel = new javax.swing.JPanel();
        bootstrapButton = new javax.swing.JButton();
        rStatus = new javax.swing.JLabel();
        dataStatusPanel = new javax.swing.JPanel();
        scrollPaneForDataStatus = new javax.swing.JScrollPane();
        dataStatusTextArea = new javax.swing.JTextArea();
        dataEditPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        renameButton = new javax.swing.JButton();
        subsetButton = new javax.swing.JButton();
        joinButton = new javax.swing.JButton();
        oncoprintButton = new javax.swing.JButton();
        inferModelButton = new javax.swing.JButton();

        scrollPaneForUI.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneForUI.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        headingLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        headingLabel.setForeground(new java.awt.Color(255, 0, 51));
        headingLabel.setText("CyTron");

        bootstrapPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Bootstrap test\n"));
        bootstrapPanel.setName(""); // NOI18N

        bootstrapButton.setText("Bootstrap");

        javax.swing.GroupLayout bootstrapPanelLayout = new javax.swing.GroupLayout(bootstrapPanel);
        bootstrapPanel.setLayout(bootstrapPanelLayout);
        bootstrapPanelLayout.setHorizontalGroup(
            bootstrapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bootstrapPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bootstrapButton)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        bootstrapPanelLayout.setVerticalGroup(
            bootstrapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bootstrapPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(bootstrapButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        rStatus.setText("Connection to R");

        dataStatusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Summary of data loaded"));
        dataStatusPanel.setName(""); // NOI18N

        scrollPaneForDataStatus.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneForDataStatus.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        dataStatusTextArea.setEditable(false);
        dataStatusTextArea.setColumns(20);
        dataStatusTextArea.setRows(5);
        scrollPaneForDataStatus.setViewportView(dataStatusTextArea);

        javax.swing.GroupLayout dataStatusPanelLayout = new javax.swing.GroupLayout(dataStatusPanel);
        dataStatusPanel.setLayout(dataStatusPanelLayout);
        dataStatusPanelLayout.setHorizontalGroup(
            dataStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataStatusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneForDataStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );
        dataStatusPanelLayout.setVerticalGroup(
            dataStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dataStatusPanelLayout.createSequentialGroup()
                .addComponent(scrollPaneForDataStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        dataEditPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Editing"));
        dataEditPanel.setName(""); // NOI18N

        deleteButton.setText("Delete");

        renameButton.setText("Rename");

        subsetButton.setText("Subset");

        joinButton.setText("Join");

        javax.swing.GroupLayout dataEditPanelLayout = new javax.swing.GroupLayout(dataEditPanel);
        dataEditPanel.setLayout(dataEditPanelLayout);
        dataEditPanelLayout.setHorizontalGroup(
            dataEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEditPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dataEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subsetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(renameButton))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        dataEditPanelLayout.setVerticalGroup(
            dataEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataEditPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(renameButton)
                .addGap(18, 18, 18)
                .addComponent(joinButton)
                .addGap(56, 56, 56)
                .addComponent(subsetButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        oncoprintButton.setText("Oncoprint");
        oncoprintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oncoprintButtonActionPerformed(evt);
            }
        });

        inferModelButton.setForeground(new java.awt.Color(0, 0, 204));
        inferModelButton.setText("Infer Model");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164)
                        .addComponent(rStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(bootstrapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(oncoprintButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inferModelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(dataStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(183, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                    .addContainerGap(274, Short.MAX_VALUE)
                    .addComponent(dataEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(33, 33, 33)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headingLabel)
                    .addComponent(rStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(oncoprintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(inferModelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(bootstrapPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(57, 57, 57)
                    .addComponent(dataStatusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(301, Short.MAX_VALUE)))
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainPanelLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(dataEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(301, Short.MAX_VALUE)))
        );

        scrollPaneForUI.setViewportView(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(scrollPaneForUI, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(scrollPaneForUI, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void oncoprintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oncoprintButtonActionPerformed
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Dataset data = new Dataset(ConnectionManager.getConnection(), "dataset", file, InputType.GISTIC);
                    } catch (RserveException ex) {
                        Logger.getLogger(CyTronGui.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(CyTronGui.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
        });
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                /*
                RConnection connection = null;
                
                try {
                    connection = new RConnection();
                    connection.eval("library(TRONCO)");//connection.voidEval(library(TRONCO))
                    
                    try {
                        //connection.eval("oncoprint(aCML)");
                        int x = connection.eval("ngenes(aCML)").asInteger();
                        System.out.println("number is " + x);
                    } catch (REXPMismatchException ex) {
                        Logger.getLogger(CyTronGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                    try {
                        String fileName = file.getName();
                        connection.eval(""+fileName+"" + " = " + file.getCanonicalPath());
                        
                        try {
                            connection.eval("import.GISTIC("+fileName+")");
                            int x = connection.eval("ngenes("+fileName+")").asInteger();
                            System.out.println("number is " + x);
                        } catch (REXPMismatchException ex) {
                            Logger.getLogger(CyTronGui.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(CyTronGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (RserveException ex) {
                    Logger.getLogger(CyTronGui.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
                
            }
        });
        
    }//GEN-LAST:event_oncoprintButtonActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bootstrapButton;
    private javax.swing.JPanel bootstrapPanel;
    private javax.swing.JPanel dataEditPanel;
    private javax.swing.JPanel dataStatusPanel;
    private javax.swing.JTextArea dataStatusTextArea;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JButton inferModelButton;
    private javax.swing.JButton joinButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton oncoprintButton;
    private javax.swing.JLabel rStatus;
    private javax.swing.JButton renameButton;
    private javax.swing.JScrollPane scrollPaneForDataStatus;
    private javax.swing.JScrollPane scrollPaneForUI;
    private javax.swing.JButton subsetButton;
    // End of variables declaration//GEN-END:variables
    
    
    public void activate() {
        
    }
    
    public void deactivate() {
        
    }  
         
}
