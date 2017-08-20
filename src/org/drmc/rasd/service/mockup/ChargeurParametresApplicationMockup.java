package org.drmc.rasd.service.mockup;

import org.drmc.rasd.modele.ParametresApplication;
import org.drmc.rasd.service.IChargeurParametresApplication;

/**
 *
 * @author RABBAH
 */
public class ChargeurParametresApplicationMockup implements IChargeurParametresApplication {
    private ParametresApplication pa;

    @Override
    
    public ParametresApplication chargerParametres() {
        /*
        ParametresApplication pa = new ParametresApplication();
        pa.setLoginDb("postgres");
        pa.setLoginFtp("rocsou");
        pa.setNomDb("arsad");
        pa.setPasswordDb("rocsou");
        pa.setPasswordFtp("rocsou");
        pa.setPortDb(5432);
        pa.setPortFtp(21);
        pa.setUrlDb("localhost");
        pa.setUrlFtp("127.0.0.1");
        pa.setPrefixFichierEnvoye("msg");
        pa.setSuffixFichierEnvoyer(".a");
        pa.setRepertoireConsommation("C:\\temp");
        pa.setRepertoireArchivage("C:\\ARSAD");
       */
        return pa;
    }

}
