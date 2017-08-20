
package org.drmc.rasd.modele;

/**
 *
 * @author RABBAH
 */
public class ParametresApplication {
    private String urlDb;
    private int portDb = 5432; //port par defaut de postgresql
    private String nomDb;
    private String loginDb;
    private String passwordDb;
    private String prefixFichierEnvoye;
    private String suffixFichierEnvoyer;
    private String repertoireConsommation;
    private String repertoireArchivage;
    
    private String urlFtp;
    private int portFtp = 21; //port par defaut de ftp
    private String loginFtp;
    private String passwordFtp;

    public String getRepertoireConsommation() {
        return repertoireConsommation;
    }

    public void setRepertoireConsommation(String repertoireConsommation) {
        this.repertoireConsommation = repertoireConsommation;
    }

    
    public String getUrlDb() {
        return urlDb;
    }

    public void setUrlDb(String urlDb) {
        this.urlDb = urlDb;
    }

    public int getPortDb() {
        return portDb;
    }

    public void setPortDb(int portDb) {
        this.portDb = portDb;
    }

    public String getNomDb() {
        return nomDb;
    }

    public void setNomDb(String nomDb) {
        this.nomDb = nomDb;
    }

    public String getLoginDb() {
        return loginDb;
    }

    public void setLoginDb(String loginDb) {
        this.loginDb = loginDb;
    }

    public String getPasswordDb() {
        return passwordDb;
    }

    public void setPasswordDb(String passwordDb) {
        this.passwordDb = passwordDb;
    }

    public String getUrlFtp() {
        return urlFtp;
    }

    public void setUrlFtp(String urlFtp) {
        this.urlFtp = urlFtp;
    }

    public int getPortFtp() {
        return portFtp;
    }

    public void setPortFtp(int portFtp) {
        this.portFtp = portFtp;
    }

    public String getLoginFtp() {
        return loginFtp;
    }

    public void setLoginFtp(String loginFtp) {
        this.loginFtp = loginFtp;
    }

    public String getPasswordFtp() {
        return passwordFtp;
    }

    public void setPasswordFtp(String passwordFtp) {
        this.passwordFtp = passwordFtp;
    }

    public String getPrefixFichierEnvoye() {
        return prefixFichierEnvoye;
    }

    public void setPrefixFichierEnvoye(String prefixFichierEnvoye) {
        this.prefixFichierEnvoye = prefixFichierEnvoye;
    }

    public String getSuffixFichierEnvoyer() {
        return suffixFichierEnvoyer;
    }

    public void setSuffixFichierEnvoyer(String suffixFichierEnvoyer) {
        this.suffixFichierEnvoyer = suffixFichierEnvoyer;
    }

    public String getRepertoireArchivage() {
        return repertoireArchivage;
    }

    public void setRepertoireArchivage(String repertoireArchivage) {
        this.repertoireArchivage = repertoireArchivage;
    }
    
    
}
