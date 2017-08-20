
package org.drmc.rasd.dao;

import java.util.Date;
import java.util.List;
import org.drmc.rasd.modele.Observation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class ObservationDao implements IObservationDao {

    @Override
    public boolean ajouter(Observation ob, Station s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Observation ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Observation ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Observation> listeObservations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Observation> getObservationsDate(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
