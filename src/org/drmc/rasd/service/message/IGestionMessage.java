
package org.drmc.rasd.service.message;

import java.util.Date;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;

/**
 *
 * @author RABBAH
 */
public interface IGestionMessage {
    public boolean messageEstValide(String message);
    public boolean messageEstValide(String message, ModelMessage mm);
    public String encodeObservation(Observation o);
    public Observation decodeMessage(String message);

    public Date getDateMessage(String message);

    public String getEntete(String message);
    public String getEnteteMessageRecu(String message);
    
    public String getIndicatifOmm(String message);
    public String getIndicatifOaci(String message);
}
