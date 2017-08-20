/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.service.message.mockup;

import java.util.Date;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;
import org.drmc.rasd.service.message.IGestionMessage;

/**
 *
 * @author RABBAH
 */
public class GestionMessageMockup implements IGestionMessage{

    @Override
    public boolean messageEstValide(String message) {
        return true;
    }

    @Override
    public boolean messageEstValide(String message, ModelMessage mm) {
        return true;
    }

    @Override
    public String encodeObservation(Observation o) {
        return "message";
    }

    @Override
    public Observation decodeMessage(String message) {
        return new Observation();
    }

    @Override
    public Date getDateMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEntete(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIndicatifOmm(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getIndicatifOaci(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEnteteMessageRecu(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
