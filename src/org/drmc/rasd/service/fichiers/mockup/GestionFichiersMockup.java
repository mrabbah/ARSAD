
package org.drmc.rasd.service.fichiers.mockup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.drmc.rasd.service.fichiers.IGestionFichiers;

/**
 *
 * @author RABBAH
 */
public class GestionFichiersMockup implements IGestionFichiers{

    @Override
    public File creerFichierTemporaire(String nomFichier, String extension) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void couperCollerFichier(File fichierSource, String dossierDestination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ecrireMessageDansFichier(String message, File fichierSortie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String lireMessageFichier(File fichierLecture) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getExtensionFichier(File fichier) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File[] listeFichiers(String cheminRepertoire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File[] listeFichiersExtension(String cheminRepertoire, String extension) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean repertoireContientFichier(String cheminRepertoire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimerFichier(Path cheminFichierSource) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

}
