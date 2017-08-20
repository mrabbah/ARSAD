/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.service.communication;

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
public class MaintenanceReseauTest {
    
    public MaintenanceReseauTest() {
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
     * Test of pingIpLocale method, of class MaintenanceReseau.
     */
    @Test
    public void testPingIpLocale() {
        System.out.println("pingIpLocale");
        MaintenanceReseau instance = new MaintenanceReseau();
        boolean expResult = true;
        boolean result = instance.pingIpLocale();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of pingIpRouteur method, of class MaintenanceReseau.
     */
    @Test
    public void testPingIpRouteur() {
        System.out.println("pingIpRouteur");
        String ip = "192.168.1.1";
        MaintenanceReseau instance = new MaintenanceReseau();
        boolean expResult = true;
        boolean result = instance.pingIpRouteur(ip);
        
    }

    /**
     * Test of pingIpServeur method, of class MaintenanceReseau.
     */
    @Test
    public void testPingIpServeur() {
        System.out.println("pingIpServeur");
        String ip = "172.16.0.78";
        MaintenanceReseau instance = new MaintenanceReseau();
        boolean expResult = true;
        boolean result = instance.pingIpServeur(ip);
        assertEquals(expResult, result);
        
    }
    
}
