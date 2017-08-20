package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.GroupeStation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class GroupeStationDao implements IGroupeStationDao {

    private IDbConnection dbConnection;

    public GroupeStationDao(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean ajouter(GroupeStation gs) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            String requete = "INSERT INTO groupestation( intitule ) VALUES ('" + gs.getIntitule()+ "')";
            Integer id = dbConnection.ajouter(requete);
            gs.setId(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean ajouter(GroupeStation gs, List<Station> s) {

        boolean operationReussie = this.ajouter(gs);
        if (operationReussie) {
            for (Iterator<Station> it = s.iterator(); it.hasNext();) {
                try {
                    Station station = it.next();
                    String requte = "INSERT INTO "
                            + "many_groupestation_has_many_station"
                            + "(id_station, id_groupestation) VALUES"
                            + "(" + station.getId() + "," + gs.getId() + ")";
                    dbConnection.ajouter(requte);
                } catch (SQLException ex) {
                    Logger.getLogger(GroupeStationDao.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean supprimer(GroupeStation gs) {

        String requete = "DELETE FROM groupestation WHERE id = " + gs.getId();
        return dbConnection.supprimer(requete);

    }

    @Override
    public boolean modifier(GroupeStation gs) {

        String requete = "UPDATE groupestation SET intitule = '"
                + gs.getIntitule() + "' WHERE id = " + gs.getId();
        return dbConnection.modifier(requete);

    }

    @Override
    public List<GroupeStation> listeGroupesStations() {

        List<GroupeStation> listeGroupesStations = new ArrayList();
        try {

            String requete = "SELECT id, intitule  FROM groupestation;";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                GroupeStation gs = new GroupeStation();
                gs.setId(rs.getInt("id"));
                gs.setIntitule(rs.getString("intitule"));
                listeGroupesStations.add(gs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeGroupesStations;
    }

    @Override
    public boolean ajouterStationAuGroupe(Station s, GroupeStation gs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
