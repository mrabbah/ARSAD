package org.drmc.rasd.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drmc.rasd.modele.ParametresApplication;
import org.drmc.rasd.service.mockup.ChargeurParametresApplicationMockup;

/**
 *
 * @author RABBAH
 */
public class ChargeurParametresApplication implements IChargeurParametresApplication {

    @Override
    public ParametresApplication chargerParametres() {
        try {
            ParametresApplication pa = new ParametresApplication();
            Properties prop = new Properties();
            String cheminFichierConfig = System.getenv("ARSAD_CONFIG");
            if (cheminFichierConfig != null) {
                prop.load(new FileInputStream(cheminFichierConfig));
                //Chargement des paramètres
                pa.setLoginDb(prop.getProperty("db.login"));
                pa.setLoginFtp(prop.getProperty("ftp.login"));
                pa.setNomDb(prop.getProperty("db.nom"));
                pa.setPasswordDb(prop.getProperty("db.password"));
                pa.setPasswordFtp(prop.getProperty("ftp.password"));
                pa.setPortDb(new Integer(prop.getProperty("db.port")));
                pa.setPortFtp(new Integer(prop.getProperty("ftp.port")));
                pa.setUrlDb(prop.getProperty("db.url"));
                pa.setUrlFtp(prop.getProperty("ftp.url"));
                pa.setPrefixFichierEnvoye(prop.getProperty("PrefixFichierEnvoye"));
                pa.setSuffixFichierEnvoyer(prop.getProperty("SuffixFichierEnvoyer"));
                pa.setRepertoireConsommation(prop.getProperty("RepertoireConsommation"));
                pa.setRepertoireArchivage(prop.getProperty("RepertoireArchivage"));
                return pa;
            } else {
                return null;
            }

        } catch (IOException ex) {
            Logger.getLogger(ChargeurParametresApplicationMockup.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
