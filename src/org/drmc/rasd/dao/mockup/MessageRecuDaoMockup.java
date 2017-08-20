
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.drmc.rasd.dao.IMessageRecuDao;
import org.drmc.rasd.modele.MessageRecu;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class MessageRecuDaoMockup implements IMessageRecuDao{

    @Override
    public boolean ajouter(MessageRecu mr) {
        return true;
    }

    @Override
    public boolean supprimer(MessageRecu mr) {
        return true;
    }

    @Override
    public boolean modifier(MessageRecu mr) {
        return true;
    }

    @Override
    public List<MessageRecu> listeMessagesRecus() {
        List<MessageRecu> mrs = new ArrayList();
        MessageRecu mr1 = new MessageRecu();
        MessageRecu mr2 = new MessageRecu();
        mrs.add(mr1);
        mrs.add(mr2);
        return mrs;
    }

    @Override
    public List<MessageRecu> listeMessagesRecusDate(Date d) {
        List<MessageRecu> mrs = new ArrayList();
        MessageRecu mr1 = new MessageRecu();
        MessageRecu mr2 = new MessageRecu();
        mrs.add(mr1);
        mrs.add(mr2);
        return mrs;
    }

    @Override
    public MessageRecu getLastMessageRecu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessageRecu> listeMessagesRecuDateEntete(Date dateMessage, String entete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
