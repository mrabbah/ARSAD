/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.ParametresApplication;
import org.drmc.rasd.service.IChargeurParametresApplication;
import org.drmc.rasd.service.mockup.ChargeurParametresApplicationMockup;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vostro
 */
public class DbConnectionTest {

    private IChargeurParametresApplication chargeurParametresApplication;
    private ParametresApplication pa;
    private DbConnection instance;
    private Integer id = null;

    @Before
    public void setUp() {
        chargeurParametresApplication = new ChargeurParametresApplicationMockup();
        pa = chargeurParametresApplication.chargerParametres();
    }

    @Test
    public void testAlls() throws Exception {
        testGetInstance();
        testGetConnection();
        testAjouter();
        testModifier();
        testSupprimer();
    }

    /**
     * Test of getInstance method, of class DbConnection.
     */
    //@Test
    public void testGetInstance() throws Exception {
        System.out.println("getInstance");
        instance = DbConnection.getInstance(pa);
        assertNotNull(instance);
    }

    /**
     * Test of ajouter method, of class DbConnection.
     */
    //@Test
    public void testAjouter() {
        System.out.println("ajouter");
        String requete = "insert into autorisation(intitule) VALUES ('ADMINISTRATEUR')";
        try {
            id = instance.ajouter(requete);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.toString());
        }
        System.out.println("ID AUTORISATION AJOUTER = " + id);
        assertNotNull(id);
    }

    /**
     * Test of supprimer method, of class DbConnection.
     */
    //@Test
    public void testSupprimer() {
        System.out.println("supprimer");
        String requete = "delete from autorisation where id = " + id;
        boolean expResult = true;
        boolean result = instance.supprimer(requete);
        assertEquals(expResult, result);
    }

    /**
     * Test of modifier method, of class DbConnection.
     */
    //@Test
    public void testModifier() {
        System.out.println("modifier");
        String requete = "UPDATE autorisation SET intitule='ADMIN' where id = " + id;
        boolean expResult = true;
        boolean result = instance.modifier(requete);
        assertEquals(expResult, result);
    }

    /**
     * Test of getConnection method, of class DbConnection.
     */
    //@Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection result = instance.getConnection();
        assertNotNull(result);
    }

    /**
     * Test of chercherNomTable method, of class DbConnection.
     */
//    @Test
//    public void testChercherNomTable() throws ClassNotFoundException, SQLException {
//        System.out.println("chercherNomTable");
//        String requete1 = "INSERT INTO station(\n"
//                + "            id, nom, indicatif_omm, indicatif_oaci, latitude, longitude, \n"
//                + "            altitude, altitude_baro, type)\n"
//                + "    VALUES (?, ?, ?, ?, ?, ?, \n"
//                + "            ?, ?, ?);";
//        String requete2 = "INSERT INTO station(id, nom, indicatif_omm, indicatif_oaci, latitude, longitude, \n"
//                + "            altitude, altitude_baro, type)\n"
//                + "    VALUES (?, ?, ?, ?, ?, ?, \n"
//                + "            ?, ?, ?);";
//        DbConnection instance = DbConnection.getInstance(null);
//        String expResult = "station";
//        String result = instance.chercherNomTable(requete1);
//        System.out.println(result);
//        assertEquals(expResult, result);
//        String resultbis = instance.chercherNomTable(requete2);
//        System.out.println(resultbis);
//        assertEquals(expResult, resultbis);
//        
//    }
}
