/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.service.message;

import java.util.Date;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author red1
 */
public class GestionMessageTest {
    
    public GestionMessageTest() {
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
     * Test of messageEstValide method, of class GestionMessage.
     */
    @Test
    public void testMessageEstValide_String() {
        System.out.println("messageEstValide");
        String messageValide = "SMMC40 GMMX 260600\nAAXX 26064\n 60220";
        GestionMessage instance = new GestionMessage();
        boolean expResult = true;
        boolean result = instance.messageEstValide(messageValide);
        assertEquals(expResult, result);
        String messageInValide = "SMMC540 GMMX 260600\nAAXX 26064\n 60220";
        expResult = false;
        result = instance.messageEstValide(messageInValide);
        assertEquals(expResult, result);
    }

    /**
     * Test of messageEstValide method, of class GestionMessage.
     */
    //@Test
    public void testMessageEstValide_String_ModelMessage() {
        System.out.println("messageEstValide");
        String message = "";
        ModelMessage mm = null;
        GestionMessage instance = new GestionMessage();
        boolean expResult = false;
        boolean result = instance.messageEstValide(message, mm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encodeObservation method, of class GestionMessage.
     */
    //@Test
    public void testEncodeObservation() {
        System.out.println("encodeObservation");
        Observation o = null;
        GestionMessage instance = new GestionMessage();
        String expResult = "";
        String result = instance.encodeObservation(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decodeMessage method, of class GestionMessage.
     */
    //@Test
    public void testDecodeMessage() {
        System.out.println("decodeMessage");
        String message = "";
        GestionMessage instance = new GestionMessage();
        Observation expResult = null;
        Observation result = instance.decodeMessage(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateMessage method, of class GestionMessage.
     */
    @Test
    public void testGetDateMessage() {
        System.out.println("getDateMessage");
        String message = "SMMC40 GMMX 260600\nAAXX 26064\n 60220";
        GestionMessage instance = new GestionMessage();
        Date expResult = new Date(113,11,26,6,0);
        Date result = instance.getDateMessage(message);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEntete method, of class GestionMessage.
     */
    @Test
    public void testGetEntete() {
        System.out.println("getEntete");
        String message = "SMMC40 GMMX 260600\nAAXX 26064\n 60220";
        GestionMessage instance = new GestionMessage();
        String expResult = "SMMC40";
        String result = instance.getEntete(message);
        assertEquals(expResult, result);
        
    }
    
}
