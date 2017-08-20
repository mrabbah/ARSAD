/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.dao;

import java.util.Date;
import java.util.List;
import org.drmc.rasd.dao.mockup.DbConnectionMockup;
import org.drmc.rasd.modele.MessageRecu;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Station;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nom
 */
public class MessageRecuDaoTest {
    
    public MessageRecuDaoTest() {
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
     * Test of ajouter method, of class MessageRecuDao.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        MessageRecu mr = new MessageRecu();
        mr.setCorps("corps");
        
        ModelMessage mm = new ModelMessage(1, null, null);
        Station s = new Station(1, null, null, null, null, null, 0.0, 0.0, null);
        IDbConnection dbConnection = new DbConnectionMockup();
        MessageRecuDao instance = new MessageRecuDao(dbConnection);
        boolean expResult = true;
        boolean result = instance.ajouter(mr);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of supprimer method, of class MessageRecuDao.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        MessageRecu mr = null;
        MessageRecuDao instance = null;
        boolean expResult = false;
        boolean result = instance.supprimer(mr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class MessageRecuDao.
     */
    @Test
    public void testModifier() {
        System.out.println("modifier");
        MessageRecu mr = null;
        MessageRecuDao instance = null;
        boolean expResult = false;
        boolean result = instance.modifier(mr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeMessagesRecus method, of class MessageRecuDao.
     */
    @Test
    public void testListeMessagesRecus() {
        System.out.println("listeMessagesRecus");
        MessageRecuDao instance = null;
        List<MessageRecu> expResult = null;
        List<MessageRecu> result = instance.listeMessagesRecus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeMessagesRecusDate method, of class MessageRecuDao.
     */
    @Test
    public void testListeMessagesRecusDate() {
        System.out.println("listeMessagesRecusDate");
        Date d = null;
        MessageRecuDao instance = null;
        List<MessageRecu> expResult = null;
        List<MessageRecu> result = instance.listeMessagesRecusDate(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
