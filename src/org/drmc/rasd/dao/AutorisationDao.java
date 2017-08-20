




package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.Autorisation;
import org.drmc.rasd.modele.Profil;

/**
 *
 * @author RABBAH
 */
public class AutorisationDao implements IAutorisationDao {
    private final IDbConnection dbConnection;

    public AutorisationDao(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean ajouter(Autorisation autorisation) {
        try {
            String requete = "INSERT INTO autorisation("
                    + " intitule)"
                    + " VALUES ('" + autorisation.getIntitule() + "')";
            Integer id = dbConnection.ajouter(requete);
            autorisation.setId(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
    @Override
    public boolean supprimer(Autorisation autorisation) {
        String requete = "DELETE FROM autorisation WHERE id = " + autorisation.getId();
       return dbConnection.supprimer(requete);
    }

    @Override
    public boolean modifier(Autorisation autorisation) {
        String requete = " UPDATE autorisation SET type='" + autorisation.getIntitule()+ "'\n"
                + " WHERE id = " + autorisation.getId();
        return dbConnection.modifier(requete);
    }

    
    
    @Override
    public List<Autorisation> listeAutorisations() {
       List<Autorisation> listeAutorisations = new ArrayList();
        try {
            String requete = "SELECT id, intitule  FROM autorisation;";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Autorisation s = new Autorisation();
                s.setId(rs.getInt("id"));
                s.setIntitule(rs.getString("intitule"));
                listeAutorisations.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutorisationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeAutorisations;
    }

    @Override
    public List<Autorisation> getAutorisationsProfil(Profil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
