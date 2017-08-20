
package org.drmc.rasd.modele;

/**
 *
 * @author RABBAH
 */
public class Autorisation {
    private Integer Id;
    private String Intitule;

    public Autorisation() {
    }

    public Autorisation(Integer Id, String Intitule) {
        this.Id = Id;
        this.Intitule = Intitule;
    }
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getIntitule() {
        return Intitule;
    }

    public void setIntitule(String Intitule) {
        this.Intitule = Intitule;
    }

    }
