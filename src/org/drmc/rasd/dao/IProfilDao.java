
package org.drmc.rasd.dao;

import org.drmc.rasd.modele.Profil;
import java.util.List;

/**
 *
 * @author RABBAH
 */
public interface IProfilDao {
    public boolean ajouter(Profil p);
    public boolean supprimer(Profil p);
    public boolean modifier(Profil p);
    public List listeProfils();
    public String profilValide(String login, String password);  
    public Profil getProfilByLoginEtPwd(String login, String password);
}
