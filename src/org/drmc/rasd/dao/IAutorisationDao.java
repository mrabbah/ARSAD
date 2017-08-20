
package org.drmc.rasd.dao;

import org.drmc.rasd.modele.Autorisation;
import java.util.List;
import org.drmc.rasd.modele.Profil;

/**
 *
 * @author RABBAH
 */
public interface IAutorisationDao {
    public boolean ajouter(Autorisation autorisation);
    public boolean supprimer(Autorisation autorisation);
    public boolean modifier(Autorisation autorisation);
    public List<Autorisation> listeAutorisations();
    public List<Autorisation> getAutorisationsProfil(Profil p);
}
