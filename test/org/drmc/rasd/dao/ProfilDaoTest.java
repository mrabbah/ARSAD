/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.dao;

import java.util.List;
import org.drmc.rasd.modele.Profil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class ProfilDaoTest {
    
    public ProfilDaoTest() {
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
     * Test of ajouter method, of class ProfilDao.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        Profil p = null;
        ProfilDao instance = null;
        boolean expResult = false;
        boolean result = instance.ajouter(p);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of supprimer method, of class ProfilDao.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Profil p = null;
        ProfilDao instance = null;
        boolean expResult = false;
        boolean result = instance.supprimer(p);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of modifier method, of class ProfilDao.
     */
    @Test
    public void testModifier() {
        System.out.println("modifier");
        Profil p = null;
        ProfilDao instance = null;
        boolean expResult = false;
        boolean result = instance.modifier(p);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of listeProfils method, of class ProfilDao.
     */
    @Test
    public void testListeProfils() {
        System.out.println("listeProfils");
        ProfilDao instance = null;
        List expResult = null;
        List result = instance.listeProfils();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of profilValide method, of class ProfilDao.
     */
    @Test
    public void testProfilValide() {
        System.out.println("profilValide");
        String login = "";
        String password = "";
        ProfilDao instance = null;
        boolean expResult = false;
        String result = instance.profilValide(login, password);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getProfilByLoginEtPwd method, of class ProfilDao.
     */
    @Test
    public void testGetProfilByLoginEtPwd() {
        System.out.println("getProfilByLoginEtPwd");
        String login = "";
        String password = "";
        ProfilDao instance = null;
        Profil expResult = null;
        Profil result = instance.getProfilByLoginEtPwd(login, password);
        assertEquals(expResult, result);
       
    }
    
}
