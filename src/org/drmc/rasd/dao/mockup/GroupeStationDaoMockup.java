
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.List;
import org.drmc.rasd.dao.IGroupeStationDao;
import org.drmc.rasd.modele.GroupeStation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class GroupeStationDaoMockup implements IGroupeStationDao {

    @Override
    public boolean ajouter(GroupeStation gs) {
        return true;
    }

    @Override
    public boolean ajouter(GroupeStation gs, List<Station> s) {
        return true;
    }

    @Override
    public boolean supprimer(GroupeStation gs) {
        return true;
    }

    @Override
    public boolean modifier(GroupeStation gs) {
        return true;
    }

    @Override
    public List<GroupeStation> listeGroupesStations() {
        List<GroupeStation> gss = new ArrayList();
        GroupeStation gs1 = new GroupeStation();
        GroupeStation gs2 = new GroupeStation();
        gss.add(gs1);
        gss.add(gs2);
        return gss;
    }

    @Override
    public boolean ajouterStationAuGroupe(Station s, GroupeStation gs) {
        return true;
    }
    
}
