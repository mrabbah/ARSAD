
package org.drmc.rasd.service.communication.mockup;

import it.sauronsoftware.ftp4j.FTPDataTransferListener;
import org.drmc.rasd.service.communication.IEnvoiMessage;

/**
 *
 * @author RABBAH
 */
public class EnvoiMessageMockup implements IEnvoiMessage{

    
    
    @Override
    public void envoyerMessageViaFtp(String message, FTPDataTransferListener listner) {
//        FtpManagerMockup ftpManager = new FtpManagerMockup("message", "127.0.0.1", 
//                "anonymous", "", listner);
//        ftpManager.start();
    }
    
}
