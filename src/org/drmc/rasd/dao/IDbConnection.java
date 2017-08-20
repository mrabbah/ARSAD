
package org.drmc.rasd.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author RABBAH
 */
public interface IDbConnection {
    public Integer ajouter(String requete) throws SQLException;
    public boolean supprimer(String requete);
    public boolean modifier(String requete);
    public Connection getConnection();
    
}
