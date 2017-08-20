/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drmc.rasd.service.communication;

import it.sauronsoftware.ftp4j.FTPDataTransferListener;
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
public class FtpManagerTest {
    
    public FtpManagerTest() {
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
     * Test of run method, of class FtpManager.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        FtpManager instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of envoyerMessageViaFtp method, of class FtpManager.
     */
    @Test
    public void testEnvoyerMessageViaFtp() {
        System.out.println("envoyerMessageViaFtp");
        String message = "";
        String url = "";
        String login = "";
        String password = "";
        FTPDataTransferListener listner = null;
        FtpManager instance = null;
//        instance.envoyerMessageViaFtp(message, url, login, password, listner);
        // TODO review the generated test code and remove the default call to fail.
    }
}