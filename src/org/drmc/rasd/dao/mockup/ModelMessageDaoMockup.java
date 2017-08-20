
package org.drmc.rasd.dao.mockup;

import java.util.ArrayList;
import java.util.List;
import org.drmc.rasd.dao.IModelMessageDao;
import org.drmc.rasd.modele.ModelMessage;

/**
 *
 * @author RABBAH
 */
public class ModelMessageDaoMockup implements IModelMessageDao {

    @Override
    public boolean ajouter(ModelMessage mm) {
        return true;
    }

    @Override
    public boolean supprimer(ModelMessage mm) {
        return true;
    }

    @Override
    public boolean modifier(ModelMessage mm) {
        return true;
    }

    @Override
    public List<ModelMessage> listeModelsMessages() {
        List<ModelMessage> mms = new ArrayList();
        ModelMessage mm1 = new ModelMessage();
        ModelMessage mm2 = new ModelMessage();
        mms.add(mm1);
        mms.add(mm2);
        return mms;
    }
    
}
