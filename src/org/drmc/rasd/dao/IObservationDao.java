
package org.drmc.rasd.dao;

import java.util.Date;
import org.drmc.rasd.modele.Observation;
import java.util.List;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public interface IObservationDao {
    public boolean ajouter(Observation ob, Station s);
    public boolean supprimer(Observation ob);
    public boolean modifier(Observation ob);
    public List<Observation> listeObservations();
    public List<Observation> getObservationsDate(Date d);
}
