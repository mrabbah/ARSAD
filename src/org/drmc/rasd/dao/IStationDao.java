
package org.drmc.rasd.dao;

import org.drmc.rasd.modele.Station;
import java.util.List;
import org.drmc.rasd.modele.GroupeStation;

/**
 *
 * @author RABBAH
 */
public interface IStationDao {
    public boolean ajouter(Station p);
    public boolean ajouter(Station p, List<GroupeStation> gs);
    public boolean supprimer(Station p);
    public boolean modifier(Station p);
    public List<Station> listeStations();
    public boolean ajouterGroupeAlaStation(GroupeStation gs, Station s);
}
