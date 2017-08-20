
package org.drmc.rasd.service.communication.mockup;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPDataTransferListener;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.service.communication.IFtpManager;
import org.drmc.rasd.service.fichiers.IGestionFichiers;
import org.drmc.rasd.service.fichiers.mockup.GestionFichiersMockup;

/**
 *
 * @author RABBAH
 */
public class FtpManagerMockup extends Thread implements IFtpManager {

    @Override
    public void envoyerMessageViaFtp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    IGestionFichiers gestionFichier = new GestionFichiersMockup();
//    private String message, url, login, password;
//    private FTPDataTransferListener listner;
//
//    public FtpManagerMockup(String message, String url, String login, String password, FTPDataTransferListener listner) {
//        this.message = message;
//        this.url = url;
//        this.login = login;
//        this.password = password;
//        this.listner = listner;
//    }
//    
//
//    @Override
//    public void run() {
//        this.envoyerMessageViaFtp(message, url, login, password, listner);
//    }
//    
//    
//    @Override
//    public void envoyerMessageViaFtp(String message, String url, String login, String password, FTPDataTransferListener listner) {
//        FTPClient client = null;
//        try {
//            client = new FTPClient();//instantiation de la classe
//            client.connect("127.0.0.1", 21);//connection à l adresse 127.0.0.1 port 21
//            client.login("anonymous", ""); //authentification login : anonymous sans mot de passe
//            File tmpFile = gestionFichier.creerFichierTemporaire("monfichiertemporaire", ".tmp");
//            gestionFichier.ecrireMessageDansFichier(message, tmpFile);
//            client.upload(tmpFile, listner);
//        } catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException | FTPDataTransferException | FTPAbortedException ex) {
//            Logger.getLogger(EnvoiMessageMockup.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if(client != null && client.isConnected()) {
//                try {
//                    client.disconnect(true);//se deconnecter
//                } catch (        IllegalStateException | IOException | FTPIllegalReplyException | FTPException ex) {
//                    Logger.getLogger(EnvoiMessageMockup.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//    }
    
}
