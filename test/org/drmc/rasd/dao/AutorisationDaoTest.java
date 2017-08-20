/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.dao;

import java.util.ArrayList;
import java.util.List;
import org.drmc.rasd.dao.mockup.DbConnectionMockup;
import org.drmc.rasd.modele.Autorisation;
import org.drmc.rasd.modele.Profil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USIM
 */
public class AutorisationDaoTest {
    
    private IDbConnection dbConnection;
    
    public AutorisationDaoTest() {
    }
    
    
    @Before
    public void setUp() {
        dbConnection = new DbConnectionMockup();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class AutorisationDao.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        Autorisation autorisation = new Autorisation();
        autorisation.setIntitule("VOIR_MESSAGES_RECUS");
        AutorisationDao instance = new AutorisationDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.ajouter(autorisation);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of supprimer method, of class AutorisationDao.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Autorisation autorisation = new Autorisation();
        autorisation.setId(1);
        AutorisationDao instance = new AutorisationDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.supprimer(autorisation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class AutorisationDao.
     */
    @Test
    public void testModifier() {
        System.out.println("modifier");
        Autorisation autorisation = new Autorisation();
        autorisation.setId(3);
        autorisation.setIntitule("VOIR_MESSAGES_RECUS");
        AutorisationDao instance = new AutorisationDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.modifier(autorisation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of listeAutorisations method, of class AutorisationDao.
     */
    
    @Test
    public void testListeAutorisations() {
        System.out.println("listeAutorisations");
        AutorisationDao instance = new AutorisationDao(dbConnection);
        List<Autorisation> expResult = new ArrayList();
       List<Autorisation> result = instance.listeAutorisations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAutorisationsProfil method, of class AutorisationDao.
     */
    @Test
    public void testGetAutorisationsProfil() {
        System.out.println("getAutorisationsProfil");
        Profil p = null;
        AutorisationDao instance = null;
        List<Autorisation> expResult = null;
        List<Autorisation> result = instance.getAutorisationsProfil(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
