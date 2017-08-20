/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.dao;

import java.util.ArrayList;
import java.util.List;
import org.drmc.rasd.dao.mockup.DbConnectionMockup;
import org.drmc.rasd.modele.GroupeStation;
import org.drmc.rasd.modele.Station;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DRMC
 */
public class GroupeStationDaoTest {
    private IDbConnection dbConnection;
    
    public GroupeStationDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dbConnection = new DbConnectionMockup();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class GroupeStationDao.
     */
    @Test
    public void testAjouter_GroupeStation() {
        System.out.println("ajouter");
        GroupeStation gs = new GroupeStation();
        gs.setIntitule("Groupe 1");
        GroupeStationDao instance = new GroupeStationDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.ajouter(gs);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of ajouter method, of class GroupeStationDao.
     */
    @Test
    public void testAjouter_GroupeStation_List() {
        System.out.println("ajouter");
        GroupeStation gs = new GroupeStation();
        gs.setIntitule("Groupe 2");
        List<Station> s;
        s = new ArrayList();
        
        GroupeStationDao instance = new GroupeStationDao(dbConnection);
        boolean expResult;
        expResult = true;
        boolean result = instance.ajouter(gs, s);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of supprimer method, of class GroupeStationDao.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        GroupeStation gs = new GroupeStation();
        GroupeStationDao instance = new GroupeStationDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.supprimer(gs);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modifier method, of class GroupeStationDao.
     */
    @Test
    public void testModifier() {
        System.out.println("modifier");
        GroupeStation gs = new GroupeStation();
        GroupeStationDao instance = new GroupeStationDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.modifier(gs);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of listeGroupesStations method, of class GroupeStationDao.
     */
    //@Test
    public void testListeGroupesStations() {
        System.out.println("listeGroupesStations");
        GroupeStationDao instance = new GroupeStationDao(dbConnection);
        List<GroupeStation> result = instance.listeGroupesStations();
        assertEquals(3, result.size());
        
    }

    /**
     * Test of ajouterStationAuGroupe method, of class GroupeStationDao.
     */
    @Test
    public void testAjouterStationAuGroupe() {
        System.out.println("ajouterStationAuGroupe");
        Station s = null;
        GroupeStation gs = null;
        GroupeStationDao instance = null;
        boolean expResult = false;
        boolean result = instance.ajouterStationAuGroupe(s, gs);
        assertEquals(expResult, result);
       
    }

    
}
