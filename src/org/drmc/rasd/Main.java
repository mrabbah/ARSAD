//nomination du package par org.drmc.arsad
package org.drmc.rasd;  /* probleme persite sur le nom arsad au lieu de rasd Q1 */
//importation des autre packages
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.drmc.rasd.dao.DbConnection;
import org.drmc.rasd.dao.IDbConnection;
import org.drmc.rasd.dao.IMessageEnvoyeDao;
import org.drmc.rasd.dao.IMessageRecuDao;
import org.drmc.rasd.dao.IProfilDao;
import org.drmc.rasd.dao.MessageEnvoyeDao;
import org.drmc.rasd.dao.MessageRecuDao;
import org.drmc.rasd.dao.ProfilDao;
import org.drmc.rasd.modele.ParametresApplication;
import org.drmc.rasd.service.ChargeurParametresApplication;
import org.drmc.rasd.service.IChargeurParametresApplication;
import org.drmc.rasd.service.fichiers.ConsommateurFichiers;
import org.drmc.rasd.service.fichiers.GestionFichiers;
import org.drmc.rasd.service.fichiers.IGestionFichiers;
import org.drmc.rasd.service.message.GestionMessage;
import org.drmc.rasd.service.message.IGestionMessage;
import org.drmc.rasd.service.mockup.ChargeurParametresApplicationMockup;
import org.drmc.rasd.view.AuthentificationPanel;
import org.drmc.rasd.view.MainFrame;

/**
 *
 * @author RABBAH
 */
public class Main {           

    /** point d'entree du programme
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        //Chargement des paramètres de l'application
        IChargeurParametresApplication ca = new ChargeurParametresApplication();
        
        final ParametresApplication pa = ca.chargerParametres();
        final IGestionMessage gestionMessage = new GestionMessage();
        IDbConnection dbConnection = DbConnection.getInstance(pa);
        final IGestionFichiers gestionFichiers = new GestionFichiers();
        final IMessageEnvoyeDao messageEnvoyeDao = new MessageEnvoyeDao(dbConnection);
        final IProfilDao profilDao = new ProfilDao(dbConnection);
        final IMessageRecuDao messageRecuDao = new MessageRecuDao(dbConnection);
        
        
        //Lancement du consommateur de messages
        final ConsommateurFichiers cf = new ConsommateurFichiers(pa.getRepertoireConsommation(),
              pa.getRepertoireArchivage(), gestionFichiers, gestionMessage, messageRecuDao);
        
        
        
        if (pa != null) {
            //envoyer la vue de l'authentification system
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    
                    System .out.println("point d'entree principale du traitement du MainFrame du run");
                    
                    JFrame.setDefaultLookAndFeelDecorated(true); 
                    MainFrame mf = new MainFrame(pa, gestionMessage, messageEnvoyeDao,
                            gestionFichiers, profilDao, messageRecuDao, cf);
                    
                    mf.setVisible(true);
                    mf.setContentPane(new AuthentificationPanel(mf));
                    mf.setDefaultLookAndFeelDecorated(true);    
                    mf.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
                      
                    mf.pack();
                      
                    //mf.setVisible(true);
                
                }
                
            });
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Chemin du fichier de configuration de l'application est invalide\nVeillez contactez votre administrateur", "ERREUR SYSTEME", JOptionPane.ERROR_MESSAGE);
        }
        cf.run();
        
    }

}
