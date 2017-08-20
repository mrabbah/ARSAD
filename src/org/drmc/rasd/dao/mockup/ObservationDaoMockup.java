
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.drmc.rasd.dao.IObservationDao;
import org.drmc.rasd.modele.Observation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class ObservationDaoMockup implements IObservationDao {

    @Override
    public boolean ajouter(Observation ob, Station s) {
        return true;
    }

    @Override
    public boolean supprimer(Observation ob) {
        return true;
    }

    @Override
    public boolean modifier(Observation ob) {
        return true;
    }

    @Override
    public List<Observation> listeObservations() {
        List<Observation> obs = new ArrayList();
        Observation ob1 = new Observation(); 
        Observation ob2 = new Observation(); 
        obs.add(ob1);
        obs.add(ob2);
        return obs;
    }

    @Override
    public List<Observation> getObservationsDate(Date d) {
        List<Observation> obs = new ArrayList();
        Observation ob1 = new Observation(); 
        Observation ob2 = new Observation(); 
        obs.add(ob1);
        obs.add(ob2);
        return obs;
    }
    
}
