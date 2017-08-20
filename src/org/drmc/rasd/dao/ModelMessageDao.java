package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.ModelMessage;

/**
 *
 * @author RABBAH
 */
public class ModelMessageDao implements IModelMessageDao {

    private IDbConnection dbConnection;

    public ModelMessageDao(IDbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public boolean ajouter(ModelMessage mm) {
        
            try {
            String requete = "INSERT INTO model_message("
                    + "corpsmodel, intitule) VALUES ('" + mm.getCorpsModel()
                    + "','" + mm.getIntitule() + "');";
                System.out.println("ModelMessageDao     /n"+requete);
            Integer id = dbConnection.ajouter(requete);
            mm.setId(id);
            
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public boolean supprimer(ModelMessage mm) {
        String requete = "DELETE FROM model_message WHERE corpsmodel = '" + mm.getCorpsModel()+"';";
        System.out.println(requete);
        return dbConnection.supprimer(requete);
    }

    @Override
    public boolean modifier(ModelMessage mm) {
     
      String requete = "UPDATE model_message   , corps_model=?, intitule=? WHERE id = " + mm.getId();
        return dbConnection.modifier(requete);  
    }

    @Override
    public List<ModelMessage> listeModelsMessages() {
     
        List<ModelMessage> listeModelsMessages = new ArrayList();
        try {
          
            String requete = "SELECT id, corpsmodel ,intitule FROM model_message ;";
            System.out.println("ModelMessageDao   \n"+requete);
            Connection c = dbConnection.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {   
                ModelMessage s = new ModelMessage();
                
                s.setCorpsModel(rs.getString("corpsmodel"));
                s.setIntitule(rs.getString("intitule"));
                listeModelsMessages.add(s);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeModelsMessages;
    }
}
