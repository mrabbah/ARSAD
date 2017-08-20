
package org.drmc.rasd.dao;

import org.drmc.rasd.modele.ModelMessage;
import java.util.List;

/**
 *
 * @author RABBAH
 */
public interface IModelMessageDao {
    public boolean ajouter(ModelMessage mm);
    public boolean supprimer(ModelMessage mm);
    public boolean modifier(ModelMessage mm);
    public List<ModelMessage> listeModelsMessages();
}
