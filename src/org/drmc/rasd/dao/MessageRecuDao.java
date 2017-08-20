package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.GroupeStation;
import org.drmc.rasd.modele.MessageRecu;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class MessageRecuDao implements IMessageRecuDao {

    private IDbConnection dbConnection;
    private MessageRecu mr;
    private SimpleDateFormat formatter;

    public MessageRecuDao(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean ajouter(MessageRecu mr) {
        //java.sql.Date dm = new java.sql.Date(mr.getDateMessage().getTime());
        //java.sql.Date dc = new java.sql.Date(mr.getDateConsommation().getTime());

        java.sql.Timestamp dm = new Timestamp(mr.getDateMessage().getTime());
        java.sql.Timestamp dc = new Timestamp(mr.getDateConsommation().getTime());
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("la dateeemessage est" + formatter.format(dm));
        System.out.println("la dateeecons est" + formatter.format(dc));

        // System.out.println("dm est   "+dm);
        //System.out.println("dc est   "+dc);
        try {
            String requete = "INSERT INTO message_recu(\n"
                    + "            entete, corps, date_message, date_consommation, extension, \n"
                    + "            id_station, id_model_message)\n"
                    + "    VALUES ('" + mr.getEntete() + "', '" + mr.getCorps() + "', '" + dm + "','" + dc + "', '" + mr.getExtension() + "',null,null) ";
            Integer id = dbConnection.ajouter(requete);
            mr.setId(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean supprimer(MessageRecu mr) {
        String requete = "DELETE FROM message_recu WHERE id = " + mr.getId();
        return dbConnection.supprimer(requete);
    }

    @Override
    public boolean modifier(MessageRecu mr) {
        String requete = "UPDATE message_recu\n"
                + "   SET entete='" + mr.getEntete() + "' , corps='" + mr.getCorps() + "', date_message=" + mr.getDateMessage() + ", date_consommation=" + mr.getDateConsommation() + ", \n"
                + "       extension='" + mr.getExtension() + "\n"
                + " WHERE id = " + mr.getId();
        return dbConnection.modifier(requete);
    }

    @Override
    public List<MessageRecu> listeMessagesRecus() {
        List<MessageRecu> listeMessagesRecus = new ArrayList();
        try {
            String requete = "SELECT id, entete, corps, date_message, date_consommation, extension, \n"
                    + "       id_station, id_model_message\n"
                    + "  FROM message_recu order by id desc;";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                MessageRecu mr = new MessageRecu();
                mr.setEntete(rs.getString("entete"));
                mr.setCorps(rs.getString("corps"));
                mr.setId(rs.getInt("id"));
                mr.setDateMessage(rs.getDate("date_message"));
                mr.setDateConsommation(rs.getTime("date_consommation"));
                mr.setExtension(rs.getString("extension"));
                mr.setIdStation(rs.getInt("id_station"));

//                mr.setIdModelMessage(rs.getInt("id_model_message"));
                listeMessagesRecus.add(mr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageRecuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMessagesRecus;
    }

    @Override
    public List<MessageRecu> listeMessagesRecusDate(Date d) {
        List<MessageRecu> listeMessagesRecus = new ArrayList();
        try {
            String requete = "SELECT id, entete, corps, date_message, date_consommation, extension, \n"
                    + "       id_station, id_model_message\n"
                    + "  FROM message_recu where date_message = " + d + "\n order by id desc";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                MessageRecu mr = new MessageRecu();
                mr.setEntete(rs.getString("entete"));
                mr.setCorps(rs.getString("corps"));

                mr.setId(rs.getInt("id"));
                mr.setDateMessage(rs.getDate("date_message"));
                mr.setDateConsommation(rs.getDate("date_consommation"));
                mr.setExtension(rs.getString("extension"));
                mr.setIdStation(rs.getInt("id_station"));
//                mr.setIdModelMessage(rs.getInt("id_model_message"));
                listeMessagesRecus.add(mr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageRecuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMessagesRecus;
    }

    public List<MessageRecu> listeMessagesRecuDateEntete(Date date, String entete) {

        System.out.println("vvvvvvvv " + date + "   " + entete);
        List<MessageRecu> listeMessagesRecus = new ArrayList();
        try {
            String requete = "SELECT  * FROM message_recu  ";
            if (date == null && entete.equals("")) {
            } else if (date != null && entete.equals("")) {
                java.sql.Date d = new java.sql.Date(date.getTime());
                java.sql.Timestamp nextDay = new Timestamp(date.getTime() + (1000 * 60 * 60 * 24));
                requete += " where date_message >=  '" + d + "' and date_message < '" + nextDay + "' ";
            } else if (date == null && !entete.equals("")) {
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
                    MessageRecu mr = new MessageRecu();
                    mr.setEntete(rs.getString("entete"));
                    mr.setCorps(rs.getString("corps"));

                    mr.setId(rs.getInt("id"));
                    mr.setDateMessage(rs.getDate("date_message"));
                    mr.setDateConsommation(rs.getTime("date_consommation"));
                    mr.setExtension(rs.getString("extension"));
                    mr.setIdStation(rs.getInt("id_station"));
//                mr.setIdModelMessage(rs.getInt("id_model_message"));
                    listeMessagesRecus.add(mr);
                }
            } else {
                listeMessagesRecus.add(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageEnvoyeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeMessagesRecus;
    }

    @Override
    public MessageRecu getLastMessageRecu() {
        MessageRecu mr = new MessageRecu();
        try {
            String requete = "SELECT id, entete, corps, date_message, date_consommation, extension, \n"
                    + "       id_station, id_model_message\n"
                    + "  FROM message_recu "
                    + "WHERE id = (SELECT MAX(id) FROM message_recu);";
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                mr.setEntete(rs.getString("entete"));
                mr.setCorps(rs.getString("corps"));
                mr.setId(rs.getInt("id"));
                mr.setDateMessage(rs.getDate("date_message"));
                mr.setDateConsommation(rs.getDate("date_consommation"));
                mr.setExtension(rs.getString("extension"));
                mr.setIdStation(rs.getInt("id_station"));

//                mr.setIdModelMessage(rs.getInt("id_model_message"));
            }

//                mr.setIdModelMessage(rs.getInt("id_model_message"));
        } catch (SQLException ex) {
            Logger.getLogger(MessageRecuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mr;
    }

}
