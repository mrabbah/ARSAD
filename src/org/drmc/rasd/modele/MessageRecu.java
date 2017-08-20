
package org.drmc.rasd.modele;

import java.util.Date;

/**
 *
 * @author RABBAH
 */
public class MessageRecu {
   private Integer id;
   private String entete;
   private String corps;
   private Date dateMessage;
   private Date dateConsommation;
   private String extension;
   private Integer idStation;

    public MessageRecu() {
    }

    public MessageRecu(Integer id, String entete, String corps, Date dateMessage, Date dateConsommation, String extension) {
        this.id = id;
        this.entete = entete;
        this.corps = corps;
        this.dateMessage = dateMessage;
        this.dateConsommation = dateConsommation;
        this.extension = extension;
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getDateConsommation() {
        return dateConsommation;
    }

    public void setDateConsommation(Date dateConsommation) {
        this.dateConsommation = dateConsommation;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Integer getIdStation() {
        return idStation;
    }

    public void setIdStation(Integer idStation) {
        this.idStation = idStation;
    }

}
