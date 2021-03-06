/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.view;

import org.drmc.rasd.service.communication.IMaintenanceReseau;
import org.drmc.rasd.service.communication.MaintenanceReseau;

/**
 *
 * @author RABBAH
 */
public class MaintenancePanel extends javax.swing.JPanel {

    private final MainFrame parent;
    /**
     * Creates new form MaintenancePanel
     * @param parent
     */
    public MaintenancePanel(MainFrame parent) {
        this.parent = parent;
        this.parent.setTitle("Maintenance réseau");
        initComponents();
        parent.getMenuPrincipal().setVisible(true);
        parent.getToolBarPrincipale().setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pingerLocalement = new javax.swing.JButton();
        ipRouteur = new javax.swing.JTextField();
        ipServeur = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        resultatTestPingIpLocal = new javax.swing.JLabel();
        resultatTestPingIpRouteur = new javax.swing.JLabel();
        resultatTestPingIpServeur = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        pingerLocalement.setBackground(new java.awt.Color(102, 102, 255));
        pingerLocalement.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        pingerLocalement.setText("LANCER LE TEST");
        pingerLocalement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pingerLocalementActionPerformed(evt);
            }
        });

        ipRouteur.setText("192.168.1.1");
        ipRouteur.setPreferredSize(new java.awt.Dimension(10, 20));
        ipRouteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipRouteurActionPerformed(evt);
            }
        });

        ipServeur.setText("212.217.0.1");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jTextField3.setText("127.0.0.1");

        resultatTestPingIpLocal.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        resultatTestPingIpLocal.setText("......");

        resultatTestPingIpRouteur.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        resultatTestPingIpRouteur.setText(".....");

        resultatTestPingIpServeur.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        resultatTestPingIpServeur.setText(".....");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/drmc/rasd/view/LAN.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pingerLocalement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(ipRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(333, 333, 333)
                        .addComponent(ipServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(resultatTestPingIpLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140)
                .addComponent(resultatTestPingIpRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultatTestPingIpServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resultatTestPingIpLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ipRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ipServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(pingerLocalement)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resultatTestPingIpRouteur)
                            .addComponent(resultatTestPingIpServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pingerLocalementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pingerLocalementActionPerformed
        IMaintenanceReseau maintenanceReseau = new MaintenanceReseau();
        if(maintenanceReseau.pingIpLocale()) {
            this.resultatTestPingIpLocal.setText("OK");
        } else {
            this.resultatTestPingIpLocal.setText("NOT OK");
        }
  //       IMaintenanceReseau maintenanceReseau = new MaintenanceReseau();
       // boolean test = maintenanceReseau.pingIpRouteur(ipRouteur.getText());
        System.out.println(ipRouteur.getText());
        if(maintenanceReseau.pingIpRouteur(ipRouteur.getText())) {
            this.resultatTestPingIpRouteur.setText("OK");
        } else {
            this.resultatTestPingIpRouteur.setText("NOT OK");
        }
        System.out.println(ipServeur.getText());
        if(maintenanceReseau.pingIpServeur(ipServeur.getText())) {
            System.out.println(ipServeur.getText());
            this.resultatTestPingIpServeur.setText("OK");
        } else {
            this.resultatTestPingIpServeur.setText("NOT OK");
        }
    }//GEN-LAST:event_pingerLocalementActionPerformed

    private void ipRouteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipRouteurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipRouteurActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ipRouteur;
    private javax.swing.JTextField ipServeur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton pingerLocalement;
    private javax.swing.JLabel resultatTestPingIpLocal;
    private javax.swing.JLabel resultatTestPingIpRouteur;
    private javax.swing.JLabel resultatTestPingIpServeur;
    // End of variables declaration//GEN-END:variables
}
