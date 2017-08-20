package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.MessageEnvoye;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class MessageEnvoyeDao implements IMessageEnvoyeDao {

    private IDbConnection dbConnection;
    private SimpleDateFormat formatter;

    public MessageEnvoyeDao(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public MessageEnvoye ajouter(MessageEnvoye me, ModelMessage mm, Station s) {
        try {
            java.sql.Timestamp dm = new Timestamp(me.getDateMessage().getTime());
            java.sql.Timestamp de = new Timestamp(me.getDateEnvoie().getTime());
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("ldateemassage Envoyer" + me.getDateMessage());
            System.out.println("heureemassage Envoyer" + me.getDateEnvoie());
            String requete = "INSERT INTO message_envoye(\n"
                    + "             entete, corps, date_message, date_envoie, envoi_valide, id_station, id_model_message, \n"
                    + "            id_observation)\n"
                    + "    VALUES ('" + me.getEntete() + "', '" + me.getCorps() + "','"
                    + dm + "','" + de + "', " + me.isEnvoiValide() + ", " + me.getIdStation() + ","
                    + me.getIdModelMessage() + ", " + null + ");";
            System.out.println(requete);
            Integer id = dbConnection.ajouter(requete);
            System.out.println("id nouveau message envoyer = " + id);
            me.setId(id);
            return me;

        } catch (Exception e) {
            System.out.println("Excetion lors ajout message envoyé : \n" + e);
            return null;
        }
    }

    @Override
    public boolean ajouter(MessageEnvoye me, ModelMessage mm, Station s, Observation o) {
        try {
            String requete = "INSERT INTO message_envoye(\n"
                    + "             entete, corps, date_message, date_envoie, id_station, id_model_message, \n"
                    + "            id_observation)\n"
                    + "    VALUES (" + me.getId() + ", '" + me.getEntete() + "', '" + me.getCorps() + "',"
                    + " " + me.getDateMessage() + "," + me.getDateEnvoie() + ", " + me.getIdStation() + ","
                    + me.getIdModelMessage() + ", " + me.getIdObservation() + ");";

            Integer id = dbConnection.ajouter(requete);
            me.setId(id);
            return true;

        } catch (Exception e) {
            return false;
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(MessageEnvoye me) {
        String requete = "DELETE FROM messageenvoyer WHERE id = " + me.getId();
        return dbConnection.supprimer(requete);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(MessageEnvoye me) {
        java.sql.Timestamp dm = new Timestamp(me.getDateMessage().getTime());
        java.sql.Timestamp de = new Timestamp(me.getDateEnvoie().getTime());
        String requete = "UPDATE message_envoye "
                + "   SET entete='" + me.getEntete() + "', corps='" + me.getCorps() + "', date_message='" + dm + "', date_envoie='" + de + "', id_station=" + me.getIdStation() + ", "
                + "       id_model_message=" + me.getIdModelMessage() + ", id_observation=" + me.getIdObservation() + ", envoi_valide=" + me.isEnvoiValide() + " "
                + " WHERE id = " + me.getId() + ";";
        System.out.println("modifier   " + requete);
        return dbConnection.modifier(requete);

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessageEnvoye> listeMessagesEnvoyes() {
        List<MessageEnvoye> listeMessagesEnvoyes = new ArrayList();
        try {
            String requete = "SELECT id, entete, corps, date_message, date_envoie,"
                    + " id_station, id_model_message, id_observation, envoi_valide\n"
                    + "   FROM message_envoye order by id desc;";
            System.out.println(requete);
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                MessageEnvoye me = new MessageEnvoye();
                me.setId(rs.getInt("id"));
                me.setEntete(rs.getString("entete"));
                me.setCorps(rs.getString("corps"));
                me.setDateEnvoie(rs.getTime("date_envoie"));
                me.setDateMessage(rs.getDate("date_message"));
                me.setIdModelMessage(rs.getInt("id_model_message"));
                me.setIdObservation(rs.getInt("id_observation"));
                me.setIdStation(rs.getInt("id_station"));
                me.setEnvoiValide(rs.getBoolean("envoi_valide"));

                listeMessagesEnvoyes.add(me);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageEnvoyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMessagesEnvoyes;

    }

    @Override
    public List<MessageEnvoye> listeMessagesEnvoyesDate(Date date) {
        List<MessageEnvoye> listeMessagesEnvoyes = new ArrayList();
        try {
            String requete = "SELECT id, entete, corps, date_message, date_envoie,"
                    + " id_station, id_model_message, id_observation, envoi_valide\n"
                    + "   FROM message_envoye where date_message = '" + date + "';";
            System.out.println(requete);
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            if (!rs.equals(null)) {
                while (rs.next()) {
                    MessageEnvoye me = new MessageEnvoye();
                    me.setId(rs.getInt("id"));
                    me.setEntete(rs.getString("entete"));
                    me.setCorps(rs.getString("corps"));
                    me.setDateEnvoie(rs.getDate("date_envoie"));
                    me.setDateMessage(rs.getDate("date_message"));
                    me.setIdModelMessage(rs.getInt("id_model_message"));
                    me.setIdObservation(rs.getInt("id_observation"));
                    me.setIdStation(rs.getInt("id_station"));
                    me.setEnvoiValide(rs.getBoolean("envoi_valide"));

                    listeMessagesEnvoyes.add(me);
                }
            } else {
                listeMessagesEnvoyes.add(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageEnvoyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMessagesEnvoyes;
    }

    /**
     *
     * @param entete
     * @return
     */
    @Override
    public List<MessageEnvoye> listeMessagesEnvoyesEntete(String entete) {
        List<MessageEnvoye> listeMessagesEnvoyes = new ArrayList();
        try {
            String requete = "SELECT id, entete, corps, date_message, date_envoie,"
                    + " id_station, id_model_message, id_observation, envoi_valide\n"
                    + "   FROM message_envoye where entete = '" + entete + "';";
            System.out.println(requete);
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            if (!rs.equals(null)) {
                while (rs.next()) {
                    MessageEnvoye me = new MessageEnvoye();
                    me.setId(rs.getInt("id"));
                    me.setEntete(rs.getString("entete"));
                    me.setCorps(rs.getString("corps"));
                    me.setDateEnvoie(rs.getDate("date_envoie"));
                    me.setDateMessage(rs.getDate("date_message"));
                    me.setIdModelMessage(rs.getInt("id_model_message"));
                    me.setIdObservation(rs.getInt("id_observation"));
                    me.setIdStation(rs.getInt("id_station"));
                    me.setEnvoiValide(rs.getBoolean("envoi_valide"));
                    System.out.println(me.getDateMessage());

                    listeMessagesEnvoyes.add(me);
                }
            } else {
                listeMessagesEnvoyes.add(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageEnvoyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMessagesEnvoyes;
    }

    public List<MessageEnvoye> listeMessagesEnvoyesDateEntete(Date date, String entete) {

        System.out.println("vvvvvvvv " + date + "   " + entete);
        List<MessageEnvoye> listeMessagesEnvoyes = new ArrayList();
        //Date nextDay = new Date();
        
        //formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String requete = "SELECT  * FROM message_envoye ";
            if(date == null && entete.equals("")) {
            } else if(date != null && entete.equals("")) {
                java.sql.Date d = new java.sql.Date(date.getTime());
                java.sql.Timestamp nextDay = new Timestamp(date.getTime() + (1000 * 60 * 60 * 24));
                requete += " where date_message >=  '" + d + "' and date_message < '" + nextDay + "' ";
            }  else if (date == null && !entete.equals("")) {
                requete += " where entete ilike '%" + entete + "%' ";
            } else if (date != null && !entete.equals("")) {
                java.sql.Date d = new java.sql.Date(date.getTime());
                java.sql.Timestamp nextDay = new Timestamp(date.getTime() + (1000 * 60 * 60 * 24));
                requete += " where date_message >=  '" + d + "' and date_message < '" + nextDay + "' ";
                requete += " AND ";
                requete += " entete ilike '%" + entete + "%' ";
            }
            
            requete += " order by id desc;";
            
            System.out.println(requete);
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            if (!rs.equals(null)) {
                while (rs.next()) {
                    MessageEnvoye me = new MessageEnvoye();
                    me.setId(rs.getInt("id"));
                    me.setEntete(rs.getString("entete"));
                    me.setCorps(rs.getString("corps"));
                    //me.setDateEnvoie(rs.getDate("date_envoie"));
                    me.setDateEnvoie(rs.getTime("date_envoie"));
                    me.setDateMessage(rs.getDate("date_message"));
                    me.setIdModelMessage(rs.getInt("id_model_message"));
                    me.setIdObservation(rs.getInt("id_observation"));
                    me.setIdStation(rs.getInt("id_station"));
                    me.setEnvoiValide(rs.getBoolean("envoi_valide"));

                    listeMessagesEnvoyes.add(me);
                }
            } else {
                listeMessagesEnvoyes.add(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageEnvoyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMessagesEnvoyes;
    }

    @Override
    public List<MessageEnvoye> getMessagesNonEnvoyes() {

        List<MessageEnvoye> ListeMessageNonEnvoyes = new ArrayList();
        try {
            String requete = "SELECT id, entete, corps, date_message, date_envoie, id_station, id_model_message, \n"
                    + "       id_observation, envoi_valide\n"
                    + "  FROM message_envoye where envoi_valide=false;";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                MessageEnvoye me = new MessageEnvoye();
                me.setCorps(rs.getString("corps"));
                me.setDateEnvoie(rs.getDate("date_envoie"));
                me.setDateMessage(rs.getDate("date_message"));
                me.setEntete(rs.getString("entete"));
                me.setIdModelMessage(rs.getInt("id_model_message"));
                me.setIdObservation(rs.getInt("id_observation"));
                me.setIdStation(rs.getInt("id_station"));
                me.setId(rs.getInt("id"));
                ListeMessageNonEnvoyes.add(me);

            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageEnvoyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ListeMessageNonEnvoyes;
    }

    @Override
    public String getcorpsMessageSlectionne(String entete) {
        String corps = "le message n'est pas encors élaboré";
        try {
            //String requete = "SELECT  corps FROM message_envoye WHERE id=" + i + " ;";
            String requete = "SELECT corps  FROM message_envoye "
                    + "WHERE id = (SELECT MAX(id) FROM message_envoye WHERE entete='" + entete + "' );";
            System.out.println(requete);
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            rs.next();
            corps = rs.getString("corps");
        } catch (SQLException ex) {
            return corps;
            // Logger.getLogger(MessageEnvoyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return corps;

    }

}
