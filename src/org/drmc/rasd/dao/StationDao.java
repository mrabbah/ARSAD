/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.text.ElementIterator;
import org.drmc.rasd.modele.GroupeStation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class StationDao implements IStationDao {

    private IDbConnection dbConnection;

    public StationDao(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean ajouter(Station s) {
        try {
            String requete = "INSERT INTO station("
                    + " nom, indicatif_omm, indicatif_oaci, latitude, longitude, "
                    + " altitude, altitude_baro, type)"
                    + " VALUES ('" + s.getNom() + "', '" + s.getIndicatifOmm()
                    + "', '" + s.getIndicatifOaci() + "', '" + s.getLatitude() + "', '" + s.getLongitude() + "', "
                    + " " + s.getAltitude() + ", " + s.getAltitudeBaro() + ", '" + s.getType() + "')";
            Integer id = dbConnection.ajouter(requete);
            s.setId(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean ajouter(Station s, List<GroupeStation> gs) {
        boolean operationReussie = this.ajouter(s);
        if (operationReussie) {
            for (Iterator<GroupeStation> it = gs.iterator(); it.hasNext();) {
                try {
                    GroupeStation groupeStation = it.next();
                    String requete = "INSERT INTO "
                            + "many_groupestation_has_many_station"
                            + "(id_groupestation, id_station) "
                            + "VALUES ("
                            + groupeStation.getId() + ", " + s.getId()
                            + ")";
                    dbConnection.ajouter(requete);
                } catch (SQLException ex) {
                    Logger.getLogger(StationDao.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Station s) {
        String requete = "DELETE FROM station WHERE id = " + s.getId();
        return dbConnection.supprimer(requete);
    }

    @Override
    public boolean modifier(Station s) {
        String requete = "UPDATE station\n"
                + " SET nom='" + s.getNom() + "', indicatif_omm='" + s.getIndicatifOmm() + "', indicatif_oaci='" + s.getIndicatifOaci() + "', "
                + " latitude='" + s.getLatitude() + "', longitude='" + s.getLongitude() + "', \n"
                + "       altitude=" + s.getAltitude() + ", altitude_baro=" + s.getAltitudeBaro() + ", type='" + s.getType() + "'\n"
                + " WHERE id = " + s.getId();
        return dbConnection.modifier(requete);
    }

    @Override
    public List<Station> listeStations() {
        List<Station> listeStations = new ArrayList();
        try {
            String requete = "SELECT id, nom, indicatif_omm, indicatif_oaci, latitude, longitude, \n"
                    + "       altitude, altitude_baro, type\n"
                    + "  FROM station;";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Station s = new Station();
                s.setAltitude(rs.getDouble("altitude"));
                s.setAltitudeBaro(rs.getDouble("altitude_baro"));
                s.setId(rs.getInt("id"));
                s.setIndicatifOaci(rs.getString("indicatif_oaci"));
                s.setIndicatifOmm(rs.getString("indicatif_omm"));
                s.setLatitude(rs.getString("latitude"));
                s.setLongitude(rs.getString("longitude"));
                s.setNom(rs.getString("nom"));
                s.setType(rs.getString("type"));
                listeStations.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeStations;
    }

    @Override
    public boolean ajouterGroupeAlaStation(GroupeStation gs, Station s) {
        try {
            String requete = "INSERT INTO "
                    + "many_groupestation_has_many_station"
                    + "(id_groupestation, id_station) "
                    + "VALUES ("
                    + gs.getId() + ", " + s.getId()
                    + ")";
            dbConnection.ajouter(requete);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StationDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
