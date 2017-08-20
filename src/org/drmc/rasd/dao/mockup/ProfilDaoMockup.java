
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.List;
import org.drmc.rasd.dao.IProfilDao;
import org.drmc.rasd.modele.Profil;

/**
 *
 * @author RABBAH
 */

public class ProfilDaoMockup implements IProfilDao {

    @Override
    public boolean ajouter(Profil p) {
        return true;
    }

    @Override
    public boolean supprimer(Profil p) {
        return true;
    }

    @Override
    public boolean modifier(Profil p) {
        return true;
    }

    @Override
    public List listeProfils() {
        List<Profil> pfs = new ArrayList();
        Profil pf1 = new Profil(); 
        Profil pf2 = new Profil(); 
        pfs.add(pf1);
        pfs.add(pf2);
        return pfs;
    }

    @Override
    public String profilValide(String login, String password) {
        return null;
    }
/*
    @Override
    public Profil getProfilByLoginEtPwd(String login, String password) {
        return new Profil();
    }
   */ 

    @Override
    public Profil getProfilByLoginEtPwd(String login, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }
}
