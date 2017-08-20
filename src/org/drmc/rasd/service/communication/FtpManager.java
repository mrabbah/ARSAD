
package org.drmc.rasd.service.communication;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPDataTransferListener;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.dao.IMessageEnvoyeDao;
import org.drmc.rasd.modele.MessageEnvoye;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Station;
import org.drmc.rasd.service.fichiers.IGestionFichiers;
import org.drmc.rasd.service.message.IGestionMessage;

/**
 *
 * @author RABBAH
 */
public class FtpManager extends Thread implements IFtpManager{

    IGestionFichiers gestionFichier;
    private String message, url, login, password, prefixNomFichier, suffixNomFichier;
    int csn;
    private FTPDataTransferListener listner;
    private IMessageEnvoyeDao messageEnvoyeDao;
    private IGestionMessage gestionMessage;
    private Station satation;
    private ModelMessage modelMessage;
    

    public FtpManager(String message, String url, String login, String password, 
            String prefixNomFichier, String suffixNomFichier, int csn, 
            FTPDataTransferListener listner, IMessageEnvoyeDao messageEnvoyeDao, 
            IGestionMessage gestionMessage, IGestionFichiers gestionFichier, Station station, ModelMessage modelMessage1) {
        this.gestionFichier = gestionFichier;
        this.message = message;
        this.url = url;
        this.login = login;
        this.password = password;
        this.prefixNomFichier = prefixNomFichier;
        this.suffixNomFichier = suffixNomFichier;
        this.csn = 0;//csn;
        this.listner = listner;
        this.messageEnvoyeDao = messageEnvoyeDao;
        this.gestionMessage = gestionMessage;
        this.satation = station;
        this.modelMessage = modelMessage1;
    }  
    
    
    @Override
    public void run() {
        this.envoyerMessageViaFtp();
    }
    
    @Override
    public void envoyerMessageViaFtp() {
   
      FTPClient client = null;
        
      
      try {
          //Ajout du message a la base de donnees avant envoi
            MessageEnvoye me = new MessageEnvoye();
            me.setCorps(message);
            me.setDateEnvoie(new Date());
            me.setDateMessage(gestionMessage.getDateMessage(message));
            me.setEntete(gestionMessage.getEntete(message));
            me.setEnvoiValide(false);
            System.out.println("Enregistrement du message au niveau de la BdD");
            
            me = messageEnvoyeDao.ajouter(me, modelMessage, satation);
            System.out.println("Enregistrement passe avec succes");
            //Envoi du message via ftp
            client = new FTPClient();//instantiation de la classe            
            client.connect("127.0.0.1", 21);//connection à l adresse url port 21
            client.login("rocsou", "rocsou"); //authentification login : anonymous avec mot de 
//            System.out.println(client.isConnected());
//            System.out.println(client.isAuthenticated());
//            System.out.println(client.currentDirectory());
//            client.createDirectory("test");
            NumberFormat nf = new DecimalFormat("00000000");//Il va me permettre de formatter csn
            //exemple je donne un numero = 3 il me retourne 00000003
            //autre exemple 45 il me retourne 00000045
            String csnString = nf.format(csn);
            String nomFichier = prefixNomFichier +csnString + suffixNomFichier;
            System.out.println("Creation du fichier temporaire");
            File tmpFile = gestionFichier.creerFichierTemporaire(nomFichier,".a");
            System.out.println("Ecrire le message dans le fichier");
            gestionFichier.ecrireMessageDansFichier(message, tmpFile);
            System.out.println("Upload du fichier");
            client.upload(tmpFile, listner);
//            client.upload(ftest);
//            client.append(ftest);
            System.out.println("Envoi passe avec succes");
            //Dans le cas ou tout est bien passe mettre a jour le message comme quoi il est bien envoye
            me.setEnvoiValide(true);
            System.out.println("Modification du message au niveau de la BdD");
            messageEnvoyeDao.modifier(me);
            System.out.println("Modification reussi");
            
        } catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException | FTPDataTransferException | FTPAbortedException ex) {
            Logger.getLogger(EnvoiMessage.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            if(client != null && client.isConnected()) {
//                try {
//                    client.disconnect(true);//se deconnecter
//                } catch (        IllegalStateException | IOException | FTPIllegalReplyException | FTPException ex) {
//                    //Logger.getLogger(EnvoiMessage.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }
    }
}
