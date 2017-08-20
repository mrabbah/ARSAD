
package org.drmc.rasd.service.communication.mockup;

import org.drmc.rasd.service.communication.IMaintenanceReseau;

/**
 *
 * @author RABBAH
 */
public class MaintenanceReseauMockup implements IMaintenanceReseau{

    @Override
    public boolean pingIpLocale() {
        return true;
    }

    @Override
    public boolean pingIpRouteur(String ip) {
        return true;
    }

    @Override
    public boolean pingIpServeur(String ip) {
        return true;
    }
    
}
