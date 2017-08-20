
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.drmc.rasd.dao.IMessageEnvoyeDao;
import org.drmc.rasd.modele.MessageEnvoye;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;
import org.drmc.rasd.modele.Station;

/**
 *
 * @author RABBAH
 */
public class MessageEnvoyeDaoMockup implements IMessageEnvoyeDao {

    @Override
    public MessageEnvoye ajouter(MessageEnvoye me, ModelMessage mm, Station s) {
        return null;
    }

    @Override
    public boolean ajouter(MessageEnvoye me, ModelMessage mm, Station s, Observation o) {
        return true;
    }

    @Override
    public boolean supprimer(MessageEnvoye me) {
        return true;
    }

    @Override
    public boolean modifier(MessageEnvoye me) {
        return true;
    }

    @Override
    public List<MessageEnvoye> listeMessagesEnvoyes() {
        List<MessageEnvoye> mes = new ArrayList();
        MessageEnvoye me1 = new MessageEnvoye();
        MessageEnvoye me2 = new MessageEnvoye();
        mes.add(me1);
        mes.add(me2);
        return mes;
    }

    @Override
    public List<MessageEnvoye> listeMessagesEnvoyesDate(Date date) {
        List<MessageEnvoye> mes = new ArrayList();
        MessageEnvoye me1 = new MessageEnvoye();
        MessageEnvoye me2 = new MessageEnvoye();
        mes.add(me1);
        mes.add(me2);
        return mes;
    }

    @Override
    public List<MessageEnvoye> getMessagesNonEnvoyes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessageEnvoye> listeMessagesEnvoyesEntete(String entete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public List<MessageEnvoye> listeMessagesEnvoyesEntete(Date dateMessage, String entete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MessageEnvoye> listeMessagesEnvoyesDateEntete(Date dateMessage, String entete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public String getcorpsMessageSlectionne(String entete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
