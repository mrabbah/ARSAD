
package org.drmc.rasd.service.communication;

/**
 *
 * @author RABBAH
 */
public interface IMaintenanceReseau {
    public boolean pingIpLocale();
    public boolean pingIpRouteur(String ip);
    public boolean pingIpServeur(String ip);
}
