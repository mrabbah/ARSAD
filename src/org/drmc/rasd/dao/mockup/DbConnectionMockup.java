
package org.drmc.rasd.dao.mockup;

import java.sql.Connection;
import java.sql.SQLException;
import org.drmc.rasd.dao.IDbConnection;

/**
 *
 * @author RABBAH
 */
public class DbConnectionMockup implements IDbConnection {

    @Override
    public Integer ajouter(String requete) throws SQLException{
        return 1;
    }

    @Override
    public boolean supprimer(String requete) {
        return true;
    }

    @Override
    public boolean modifier(String requete) {
        return true;
    }

    @Override
    public Connection getConnection() {
        return null;
    }
    
}
