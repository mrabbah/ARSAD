
package org.drmc.rasd.dao;

import java.util.Date;
import org.drmc.rasd.modele.MessageEnvoye;
import java.util.List;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public interface IMessageEnvoyeDao {
    public MessageEnvoye ajouter(MessageEnvoye me, ModelMessage mm, Station s);
    public boolean ajouter(MessageEnvoye me, ModelMessage mm, Station s, Observation o);
    public boolean supprimer(MessageEnvoye me);
    public boolean modifier(MessageEnvoye me);
    public List<MessageEnvoye> listeMessagesEnvoyes();
    public List<MessageEnvoye> listeMessagesEnvoyesDate(Date date);
    public List<MessageEnvoye> getMessagesNonEnvoyes();
    public List<MessageEnvoye> listeMessagesEnvoyesEntete(String entete);

   

    public List<MessageEnvoye> listeMessagesEnvoyesDateEntete(Date dateMessage, String entete);

    /**
     *
     * @param entete
     * @return
     */
    public String getcorpsMessageSlectionne(String entete);
}
