
package org.drmc.rasd.modele;

import java.util.Date;

/**
 *
 * @author RABBAH
 */
public class MessageEnvoye {
    private Integer id;
    private String entete;
    private String corps;
    private Date dateMessage;
    private Date dateEnvoie;
    private int idStation;
    private int idModelMessage;
    private int idObservation;
    private boolean envoiValide = false;

    public MessageEnvoye() {
    }

        public MessageEnvoye(Integer id, String entete, String corps, Date dateMessage, Date dateEnvoie, int idStation, int idModelMessage, int idObservation) {
        this.id = id;
        this.entete = entete;
        this.corps = corps;
        this.dateMessage = dateMessage;
        this.dateEnvoie = dateEnvoie;
        this.idStation = idStation;
        this.idModelMessage = idModelMessage;
        this.idObservation = idObservation;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntete() {
        return entete;
    }

    public void setEntete(String entete) {
        this.entete = entete;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public int getIdStation() {
        return idStation;
    }

    public void setIdStation(int idStation) {
        this.idStation = idStation;
    }

    public int getIdModelMessage() {
        return idModelMessage;
    }

    public void setIdModelMessage(int idModelMessage) {
        this.idModelMessage = idModelMessage;
    }

    public int getIdObservation() {
        return idObservation;
    }

    public void setIdObservation(int idObservation) {
        this.idObservation = idObservation;
    }

    public boolean isEnvoiValide() {
        return envoiValide;
    }

    public void setEnvoiValide(boolean envoiValide) {
        this.envoiValide = envoiValide;
    }
    
    
     
    
    
    
}
