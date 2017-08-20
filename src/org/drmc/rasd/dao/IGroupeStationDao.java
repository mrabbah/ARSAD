/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.dao;

import java.util.List;
import org.drmc.rasd.modele.GroupeStation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public interface IGroupeStationDao  {
    
    public boolean ajouter(GroupeStation gs);
    public boolean ajouter(GroupeStation gs, List<Station> s);
    public boolean supprimer(GroupeStation gs);
    public boolean modifier(GroupeStation gs);
    public List<GroupeStation> listeGroupesStations();
    public boolean ajouterStationAuGroupe(Station s, GroupeStation gs);
}
