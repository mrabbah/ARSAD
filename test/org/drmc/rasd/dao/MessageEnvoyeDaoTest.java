/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.drmc.rasd.dao.mockup.DbConnectionMockup;
import org.drmc.rasd.modele.MessageEnvoye;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;
import org.drmc.rasd.modele.Station;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrateur
 */
public class MessageEnvoyeDaoTest {
    private DbConnectionMockup dbConnection;
    
    public MessageEnvoyeDaoTest() {
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
     * Test of ajouter method, of class MessageEnvoyeDao.
     */
    @Test
    public void testAjouter_3args() {
        System.out.println("ajouter");
        MessageEnvoye me = new MessageEnvoye();
        me.setCorps("corps");
        me.setEntete("entete");
        Date dd=new Date(2013, 12, 25);
        me.setDateMessage(dd);
        me.setDateEnvoie(dd);
        me.setIdStation(2);
        me.setIdModelMessage(4);
        
        ModelMessage mm = new ModelMessage();
        Station s;
        s = new Station(4, null, null, null, null, null, 10.0, 11.0, null);
        IDbConnection dbConnection = new DbConnectionMockup();
        MessageEnvoyeDao instance = new MessageEnvoyeDao(dbConnection);
        boolean expResult = true;
        /*boolean result =*/ instance.ajouter(me, mm, s);
        assertEquals(expResult, true);
        
    }

    /**
     * Test of ajouter method, of class MessageEnvoyeDao.
     */
    @Test
    public void testAjouter_4args() {
        System.out.println("ajouter");
        MessageEnvoye me = new MessageEnvoye();
        me.setCorps("corps");
        me.setEntete("entete");
        Date d = new Date(2013, 12, 26, 9, 30);
        me.setDateMessage(d);
        me.setDateEnvoie(null);
        me.setIdStation(2);
        me.setIdModelMessage(4);
        me.setIdObservation(5);
        
        ModelMessage mm = new ModelMessage();
        Station s = new Station();
        Observation o = new Observation();
        IDbConnection dbConnections = new DbConnectionMockup();
        MessageEnvoyeDao instance = new MessageEnvoyeDao(dbConnections);
        
        boolean expResult = true;
        boolean result = instance.ajouter(me, mm, s, o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of supprimer method, of class MessageEnvoyeDao.
     */
   @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        MessageEnvoye me = new MessageEnvoye();
        IDbConnection dbConnections = new DbConnectionMockup();
        MessageEnvoyeDao instance = new MessageEnvoyeDao(dbConnections);
        me.setId(1);
        boolean expResult = true;
        boolean result = instance.supprimer(me);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of modifier method, of class MessageEnvoyeDao.
     */
   @Test
    public void testModifier() {
        System.out.println("modifier");
        MessageEnvoye me;
        me = new MessageEnvoye(4, null, null, null, null,10, 10, 10);
       // me.setId(2);
        me.setCorps(null);
        me.setEntete(null);
        Date dd=new Date(2013, 12, 25);
        me.setDateMessage(dd);
        me.setDateEnvoie(dd);
        me.setIdStation(12);
        me.setIdModelMessage(4);
        me.setIdObservation(100);
        //MessageEnvoye me = new MessageEnvoye(1, null, null, null, null, idStation, idModelMessage, idObservation);
        IDbConnection dbConnections = new DbConnectionMockup();
        MessageEnvoyeDao instance = new MessageEnvoyeDao(dbConnections);
        
        boolean expResult = true;
        boolean result = instance.modifier(me);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of listeMessagesEnvoyes method, of class MessageEnvoyeDao.
     */
    //@Test
    public void testListeMessagesEnvoyes() {
        System.out.println("listeMessagesEnvoyes");
       IDbConnection dbConnections = new DbConnectionMockup();
        MessageEnvoyeDao instance = new MessageEnvoyeDao(dbConnections);
        List<MessageEnvoye> expResult = new ArrayList();
        
        /*
        List<String> maliste = new ArrayList();
        maliste.add("khomsi");
        maliste.add("rochdi");
        maliste.add("feddoul");
        maliste.add("joubij");
        maliste.add("mouchrif");
        maliste.add("boulal");
        maliste.add("bzaiz");
        maliste.add("nibou");
        maliste.add("oujadi");
        maliste.add("rabbah");
        //Iterator<String> it = maliste.iterator();
        for (Iterator<String> it = maliste.iterator(); it.hasNext();) {
            String nom = it.next();
            System.out.println(nom);
        }
        System.out.println(maliste.get(2));
        */
        
        List<MessageEnvoye> result = instance.listeMessagesEnvoyes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of listeMessagesEnvoyesDate method, of class MessageEnvoyeDao.
     */
    //@Test
    public void testListeMessagesEnvoyesDate() {
        System.out.println("listeMessagesEnvoyesDate");
        Date date = null;
       IDbConnection dbConnections = new DbConnectionMockup();
        MessageEnvoyeDao instance = new MessageEnvoyeDao(dbConnections);
        List<MessageEnvoye> expResult = null;
        List<MessageEnvoye> result = instance.listeMessagesEnvoyesDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
