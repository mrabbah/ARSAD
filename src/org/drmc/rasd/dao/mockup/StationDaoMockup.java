
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.List;
import org.drmc.rasd.dao.IStationDao;
import org.drmc.rasd.modele.GroupeStation;
import org.drmc.rasd.modele.Profil;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class StationDaoMockup implements IStationDao {

    @Override
    public boolean ajouter(Station p) {
        return true;
    }

    @Override
    public boolean ajouter(Station p, List<GroupeStation> gs) {
        return true;
    }

    @Override
    public boolean supprimer(Station p) {
        return true;
    }

    @Override
    public boolean modifier(Station p) {
        return true;
    }

    @Override
    public List<Station> listeStations() {
        List<Station> sts = new ArrayList();
        Station st1 = new Station(); 
        Station st2 = new Station(); 
        sts.add(st1);
        sts.add(st2);
        return sts;
    }

    @Override
    public boolean ajouterGroupeAlaStation(GroupeStation gs, Station s) {
        return true;
    }
    
}
