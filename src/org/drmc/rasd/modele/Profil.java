package org.drmc.rasd.modele;

/**
 *
 * @author RABBAH
 */
public class Profil implements IProfil {

    private Integer id;
    private String intitule;
    private String login;
    private String password;
    

    public Profil() {
    }

    public Profil(Integer id, String intitule, String login, String password) {
        this.id = id;
        this.intitule = intitule;
        this.login = login;
        this.password = password;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
