
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.List;
import org.drmc.rasd.dao.IAutorisationDao;
import org.drmc.rasd.modele.Autorisation;
import org.drmc.rasd.modele.Profil;

/**
 *
 * @author RABBAH
 */
public class AutorisationDaoMockup implements IAutorisationDao{

    @Override
    public boolean ajouter(Autorisation autorisation) {
        return true;
    }

    @Override
    public boolean supprimer(Autorisation autorisation) {
        return true;
    }

    @Override
    public boolean modifier(Autorisation autorisation) {
        return true;
    }

    @Override
    public List<Autorisation> listeAutorisations() {
        ArrayList<Autorisation> resultat = new ArrayList<Autorisation>();
        Autorisation a1 = new Autorisation();
        Autorisation a2 = new Autorisation();
        resultat.add(a1);
        resultat.add(a2);
        return resultat;
    }

    @Override
    public List<Autorisation> getAutorisationsProfil(Profil p) {
        List<Autorisation> resultat = new ArrayList();
        Autorisation a1 = new Autorisation();
        Autorisation a2 = new Autorisation();
        Autorisation a3 = new Autorisation();
        resultat.add(a1);
        resultat.add(a2);
        resultat.add(a3);
        return resultat;
    }
    
}
