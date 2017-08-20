/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drmc.rasd.dao;

import java.util.List;
import org.drmc.rasd.dao.mockup.DbConnectionMockup;
import org.drmc.rasd.modele.ModelMessage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salah
 */
public class ModelMessageDaoTest {
    
    public ModelMessageDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class ModelMessageDao.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        ModelMessage mm = new ModelMessage();
        mm.setCorpsModel("corps");
        mm.setIntitule("synomps");
        IDbConnection dbConnection = new DbConnectionMockup();
        ModelMessageDao instance = new ModelMessageDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.ajouter(mm);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of supprimer method, of class ModelMessageDao.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        ModelMessage mm = new ModelMessage();
        IDbConnection dbConnection = new DbConnectionMockup();
        ModelMessageDao instance = new ModelMessageDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.supprimer(mm);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of modifier method, of class ModelMessageDao.
     */
    @Test
    public void testModifier() {
        System.out.println("modifier");
        ModelMessage mm = null;
        ModelMessageDao instance = null;
        boolean expResult = false;
        boolean result = instance.modifier(mm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeModelsMessages method, of class ModelMessageDao.
     */
    @Test
    public void testListeModelsMessages() {
        System.out.println("listeModelsMessages");
        ModelMessageDao instance = null;
        List expResult = null;
        List result = instance.listeModelsMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}