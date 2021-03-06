/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drmc.rasd.view;

import java.awt.event.ItemListener;
import java.awt.im.InputContext;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import org.drmc.rasd.dao.DbConnection;
import org.drmc.rasd.dao.IProfilDao;
import org.drmc.rasd.modele.Profil;
import org.drmc.rasd.dao.IDbConnection;
import org.drmc.rasd.dao.ProfilDao;
import org.drmc.rasd.modele.ParametresApplication;
import org.drmc.rasd.service.ChargeurParametresApplication;
import org.drmc.rasd.service.IChargeurParametresApplication;
import org.drmc.rasd.service.message.GestionMessage;
import org.drmc.rasd.service.message.IGestionMessage;
import org.drmc.rasd.service.mockup.ChargeurParametresApplicationMockup;

/**
 *
 * @author usim
 */
public class CréationDesComptes extends javax.swing.JPanel {

    private final MainFrame parent;

    /**
     * Creates new form MaintenancePanel
     *
     * @param parent
     */
    public CréationDesComptes(MainFrame parent) {
        this.parent = parent;
        this.parent.setTitle("Création des comptes");
        initComponents();
        parent.getMenuPrincipal().setVisible(true);
        parent.getToolBarPrincipale().setVisible(true);
    }

    CréationDesComptes(ListeDesProfil aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Creates new form CréationDesComptes
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        créer = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();

        jLabel1.setText("Profil");

        jLabel2.setText("Login");

        jLabel3.setText("Password");

        jLabel4.setText("Password_conf");

        créer.setText("Créer");
        créer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                créerActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrateur", "Observateur", "Climatologiste" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(créer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPasswordField2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(créer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void créerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_créerActionPerformed

        IChargeurParametresApplication ca = new ChargeurParametresApplication();
        final ParametresApplication pa = ca.chargerParametres();
        //final IGestionMessage gestionMessage = new GestionMessage();
        try {
            IDbConnection dbConnection = DbConnection.getInstance(pa);
            String profil = jComboBox1.getSelectedItem().toString();
            String login = jTextField2.getText();
            String password = jPasswordField1.getText();
            String password_conf = jPasswordField2.getText();
            if (!login.equals("") && !password.equals("") && password.equals(password_conf)) {
                Profil p = new Profil(null, profil, login, password);
                IProfilDao ipd = new ProfilDao(dbConnection);
                if (ipd.ajouter(p)) {
                    jLabel5.setText("la création du nouveau compte est bien faite");
                    jTextField2.setText("");
                    jPasswordField1.setText("");
                    jPasswordField2.setText("");
                    jComboBox1.setSelectedIndex(0);
                } else {
                    jLabel5.setText("la création du nouveau compte a échoué");
                    jTextField2.setText("");
                    jPasswordField1.setText("");
                    jPasswordField2.setText("");
                    jComboBox1.setSelectedIndex(0);
                }
                parent.setContentPane(new ListeDesProfil(parent, "la création du nouveau compte est passée avec succés"));
                parent.pack();
                parent.setLocationRelativeTo(null);
            } else {
                jLabel5.setText("login ou le mot de passe est incorecte");
                jTextField2.setText("");
                jPasswordField1.setText("");
                jPasswordField2.setText("");
                jComboBox1.setSelectedIndex(0);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CréationDesComptes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_créerActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton créer;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void setContentPane(ListeDesProfil listeDesProfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLocationRelativeTo(CréationDesComptes aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
