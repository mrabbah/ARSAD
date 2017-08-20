
package org.drmc.rasd.service.communication;

import it.sauronsoftware.ftp4j.FTPDataTransferListener;

/**
 *
 * @author RABBAH
 */
public interface IEnvoiMessage {
    public void envoyerMessageViaFtp(String message, FTPDataTransferListener listner);
}
