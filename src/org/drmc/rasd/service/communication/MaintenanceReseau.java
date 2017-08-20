package org.drmc.rasd.service.communication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RABBAH
 */
public class MaintenanceReseau implements IMaintenanceReseau {

    /**
     * Fonction qui permet de pinger un url
     *
     * @param url exemple www.google.com ou 127.0.0.1
     * @return si oui ou non on peut pinger l url en parametre
     */
    private boolean pingUrl(String url) {
        try {
            InetAddress address = InetAddress.getByName(url);
            return address.isReachable(60000);
        } catch (UnknownHostException ex) {
            System.out.println("ex = " + ex);
            Logger.getLogger(MaintenanceReseau.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            System.out.println("ex 2 = "  + ex);
            Logger.getLogger(MaintenanceReseau.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean pingIpLocale() {
        return this.pingUrl("127.0.0.1");
    }

    @Override
    public boolean pingIpRouteur(String ip) {
         System.out.println("routeur :  "+this.pingUrl(ip));
        return this.pingUrl(ip);

    }

    @Override
    public boolean pingIpServeur(String ip) {
        System.out.println("serveur : "+this.pingUrl(ip));
        return this.pingUrl(ip);

    }

}
