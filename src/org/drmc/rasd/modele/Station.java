
package org.drmc.rasd.modele;

/**
 *
 * @author RABBAH
 */
public class Station {
    private Integer id;
    private String nom;
    private String indicatifOmm;
    private String indicatifOaci;
    private String latitude;
    private String longitude;
    private Double altitude;
    private Double altitudeBaro;
    private String type;

    public Station() {
    }

    public Station(Integer id, String nom, String indicatifOmm, String indicatifOaci, String latitude, String longitude, Double altitude, Double altitudeBaro, String type) {
        this.id = id;
        this.nom = nom;
        this.indicatifOmm = indicatifOmm;
        this.indicatifOaci = indicatifOaci;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.altitudeBaro = altitudeBaro;
        this.type = type;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIndicatifOmm() {
        return indicatifOmm;
    }

    public void setIndicatifOmm(String indicatifOmm) {
        this.indicatifOmm = indicatifOmm;
    }

    public String getIndicatifOaci() {
        return indicatifOaci;
    }

    public void setIndicatifOaci(String indicatifOaci) {
        this.indicatifOaci = indicatifOaci;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getAltitudeBaro() {
        return altitudeBaro;
    }

    public void setAltitudeBaro(Double altitudeBaro) {
        this.altitudeBaro = altitudeBaro;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
