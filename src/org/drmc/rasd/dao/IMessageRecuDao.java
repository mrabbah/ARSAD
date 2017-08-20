
package org.drmc.rasd.dao;

import java.util.Date;
import org.drmc.rasd.modele.MessageRecu;
import java.util.List;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public interface IMessageRecuDao {
    public boolean ajouter(MessageRecu mr);
    public boolean supprimer(MessageRecu mr);
    public boolean modifier(MessageRecu mr);
    public List<MessageRecu> listeMessagesRecus();
    public List<MessageRecu> listeMessagesRecusDate(Date d);
    public MessageRecu getLastMessageRecu();

    public List<MessageRecu> listeMessagesRecuDateEntete(Date dateMessage, String entete);
}
