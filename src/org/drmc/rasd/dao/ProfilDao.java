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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.Profil;

/**
 *
 * @author admin
 */
public class ProfilDao implements IProfilDao {

    private IDbConnection dbConnection;

    public ProfilDao(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean ajouter(Profil p) {
        try {
            String requete = "INSERT INTO profil(  intitule, login, password) VALUES "
                    + "('" + p.getIntitule() + "', '" + p.getLogin() + "', "
                    + "'" + p.getPassword() + "');";
            Integer id = dbConnection.ajouter(requete);
            p.setId(id);
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    @Override
    public boolean supprimer(Profil p) {
        String requete = "delete from profil where id =" + p.getId();
        return dbConnection.supprimer(requete);
    }

    @Override
    public boolean modifier(Profil p) {
        String requete = "UPDATE profil SET intitule='" + p.getIntitule() + "', '" + p.getLogin() + "',"
                + " '" + p.getPassword() + "' WHERE id=" + p.getId();
        return dbConnection.modifier(requete);
    }

    @Override
    public List listeProfils() {
        List<Profil> listeProfils = new ArrayList();
        try {
            String requete = "SELECT id, intitule, login, password FROM profil;";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Profil p = new Profil();
                p.setId(rs.getInt("id"));
                p.setIntitule(rs.getString("intitule"));
                p.setLogin(rs.getString("login"));
                p.setPassword(rs.getString("password"));
                listeProfils.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeProfils;
    }

    public String profilValide(String login, String password) {
        String typeProfil = null;
        int i = 0;
        try {
            while (i < 3) {
                switch (i) {
                    case 0:
                        typeProfil = "Administrateur";
                        break;
                    case 1:
                        typeProfil = "Observateur";
                        break;
                    case 2:
                        typeProfil = "Climatologiste";
                        break;
                }
              
                String requete = "SELECT count(*)\n"
                        + "  FROM profil\n"
                        + "  where login = '" + login + "'\n"
                        + "  and password = '" + password + "'\n"
                        + "  and intitule = '" + typeProfil + "';";
                Connection c = dbConnection.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(requete);
                rs.next();
                Integer nombreProfile = rs.getInt(1);
                if (nombreProfile != 0 && typeProfil.equals("Administrateur")) {
                    return typeProfil;

                } else if (nombreProfile != 0 && !typeProfil.equals("Administrateur")) {
                    return typeProfil;

                } else if (i == 2) {
                    return "roc";

                }
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfilDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;


    }

    @Override
    public Profil getProfilByLoginEtPwd(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
