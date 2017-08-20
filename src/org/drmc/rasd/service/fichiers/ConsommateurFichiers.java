package org.drmc.rasd.service.fichiers;

import java.io.File;
import java.util.Date;
import org.drmc.rasd.dao.IMessageRecuDao;
import org.drmc.rasd.modele.MessageRecu;
import org.drmc.rasd.service.message.IGestionMessage;
import org.drmc.rasd.view.SurveillancePanel;

/**
 *
 * @author RABBAH
 */
public class ConsommateurFichiers extends Thread {

    private String repertoireConsommation;
    private String repertoireStockage;
    private IGestionFichiers gestionFichiers;
    private static final String FS = System.getProperty("file.separator");
    private IGestionMessage gestionMessage;
    private IMessageRecuDao messageRecuDao;
    private SurveillancePanel surveillancePanel;

    public ConsommateurFichiers(String repertoireConsommation, String repertoireStockage, 
            IGestionFichiers gestionFichiers, IGestionMessage gestionMessage, IMessageRecuDao messageRecuDao) {
        this.repertoireConsommation = repertoireConsommation;
        this.repertoireStockage = repertoireStockage;
        this.gestionFichiers = gestionFichiers;
        this.gestionMessage = gestionMessage;
        this.messageRecuDao = messageRecuDao;
    }

    @Override
    public void run() {
        
        while (true) {
            System.out.println("Thread    FS   "+ FS );
            try {
                boolean repertoireContientFichiers = gestionFichiers.repertoireContientFichier(repertoireConsommation);
                if (repertoireContientFichiers) {
                    File[] listeFichiers = gestionFichiers.listeFichiers(repertoireConsommation);
                    String corpsMessage;
                    String nomMessage;
                    
                    for (int i = 0; i < listeFichiers.length; i++) {
                        if (listeFichiers[i].isFile() && listeFichiers[i].canRead()) { //vérifier si c'est un fichier
                            
                            String extension = gestionFichiers.getExtensionFichier(listeFichiers[i]);
                            MessageRecu mr = new MessageRecu();
                            mr.setExtension(extension);
                            System.out.println("l'extension est :   "+extension);
                            if (".a".equals(extension)) {
                                 //System.out.println("Extension dans if ====== " + extension);
                                corpsMessage = gestionFichiers.lireMessageFichier(listeFichiers[i]);
                                mr.setDateMessage(gestionMessage.getDateMessage(corpsMessage));
                                mr.setEntete(gestionMessage.getEnteteMessageRecu(corpsMessage));
                            } else  //if (".f".equals(extension) || ".gb".equals(extension) || ".lt".equals(extension) || ".buffer".equals(extension))
                            {
                                 //System.out.println("Extension dans else ====== " + extension);
                                nomMessage =  listeFichiers[i].getName();
                                mr.setDateMessage(new Date());
                                mr.setEntete("fichier binaire");
                                corpsMessage = repertoireStockage + FS + listeFichiers[i].getName();
                            }
                           
                            gestionFichiers.couperCollerFichier(listeFichiers[i], repertoireStockage);    
                            mr.setCorps(corpsMessage);
                            if(corpsMessage.startsWith("SPMC40")){
                            afficherMessageAlerte(corpsMessage);
                            }else{
                             afficherMessageRecu(corpsMessage);
                            }
//TODO Controller les message d alerte pour actualisation
                            //afficherMessageAlerte(corpsMessage);
                            mr.setDateConsommation(new Date());
                            mr.setExtension(extension);
                            System.out.println(mr.getCorps());
                            System.out.println("  date_consommation   "+mr.getDateConsommation());
                            messageRecuDao.ajouter(mr);
                           
                        }
                      
                        
                    }
                            
                    
                }
                

                Thread.sleep(10000);//faire dormir le thread durant 10000 ms = 10s
            } catch (InterruptedException ie) {

            }
        }
       
    }

    private void afficherMessageRecu(String message) {
        if(surveillancePanel != null) {
            System.out.println(" afficherMessageRecu depuis consomateur fichier");
            surveillancePanel.getMessageRecu().setText(message);
            //TODO
        }
    }
    private void afficherMessageAlerte(String message) {
        if(surveillancePanel != null) {
            surveillancePanel.getMessageAlerte().setText(message);
            surveillancePanel.validate();
        }
    }
    public void setSurveillancePanel(SurveillancePanel surveillancePanel) {
        this.surveillancePanel = surveillancePanel;
    }
    
    
}
