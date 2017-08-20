
package org.drmc.rasd.modele;

/**
 *
 * @author RABBAH
 */
//gestion des modeles des differents messagesd
public class ModelMessage {
    Integer id;
    String nomModele;
    String entete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorpsModel() {
        return nomModele;
    }

    public void setCorpsModel(String nomModele) {
        this.nomModele = nomModele;
    }

    public String getIntitule() {
        return entete;
    }

    public void setIntitule(String entete) {
        this.entete = entete;
    }

    public ModelMessage() {
    }



    public ModelMessage(Integer id, String nomModele, String entete) {
        this.id = id;
        this.nomModele = nomModele;
        this.entete = entete;
    }

    @Override
    public String toString() {
        return this.entete;
    }
    
    
 
}

