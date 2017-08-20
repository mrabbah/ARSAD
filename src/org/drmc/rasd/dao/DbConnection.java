package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.ParametresApplication;

/**
 *
 * @author RABBAH
 */
public class DbConnection implements IDbConnection {

    private ParametresApplication pa;
    private static DbConnection dbConnection;
    private Connection connection = null;

    public DbConnection(ParametresApplication pa) {
        this.pa = pa;
    }

    public static DbConnection getInstance(ParametresApplication pa) throws ClassNotFoundException, SQLException {
        if (dbConnection != null) {
            return dbConnection;
        }
        dbConnection = new DbConnection(pa);
        dbConnection.seConnecter();
        return dbConnection;
    }

    @Override
    public Integer ajouter(String requete) throws SQLException {
        Statement st = connection.createStatement();
        st.execute(requete);
        String nomTable = this.chercherNomTable(requete);
        System.out.println("dbconnection    1");
        if (nomTable.startsWith("many")) {
            return null;
        }
        System.out.println("dbconnection    2");
        PreparedStatement pst;
        System.out.println("dbconnection    3");
        String reqId = "select max(id) from " + nomTable;
        System.out.println(reqId);
        Connection c = dbConnection.getConnection();
        Statement stNew = c.createStatement();
        ResultSet rs = stNew.executeQuery(reqId);
        rs.next();
        System.out.println("dbconnection    6");
        st.close();
        System.out.println("dbconnection    7");
        return rs.getInt(1);
    }

    @Override
    public boolean supprimer(String requete) {
        Statement st = null;
        try {
            st = connection.createStatement();
            st.execute(requete);
            st.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        }
    }

    @Override
    public boolean modifier(String requete) {
        System.out.println("requete modifier = " + requete);
        Statement st = null;
        try {
            st = connection.createStatement();
            st.execute(requete);
            st.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
            if(st != null) {
                try {
                    st.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            return false;
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    private void seConnecter() throws ClassNotFoundException, SQLException {
        System.out.println("-------- PostgreSQL "
                + "JDBC Test DE CONNECTION ------------");
        System.out.println("pa.getUrlDb() =" + pa.getUrlDb() + " pa.getLoginDb() = " + pa.getLoginDb() + " pa.getPasswordDb() = " + pa.getPasswordDb() + " pa.getNomDb() = " + pa.getNomDb());
        //CHARGER LE DRIVER DU SYSTEM
        Class.forName("org.postgresql.Driver");

        System.out.println("PostgreSQL JDBC Driver LOCALISE AVEC SUCCES!");
        connection = DriverManager.getConnection(
                "jdbc:postgresql://" + pa.getUrlDb() + ":" + pa.getPortDb()
                + "/" + pa.getNomDb(), pa.getLoginDb(), pa.getPasswordDb());

    }
    
    private String chercherNomTable(String requete) {
        String[] tabString = requete.split(" ");
        String chaineEncadree = tabString[2];
        String[] tabStringBis = chaineEncadree.split("\\(");
        System.out.println("Dbconnectio   chercherNonTable    "+tabStringBis[0]);
        return tabStringBis[0];
    }

    @Override
    protected void finalize() throws Throwable {
        if(connection != null) {
            connection.close();
        }
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
