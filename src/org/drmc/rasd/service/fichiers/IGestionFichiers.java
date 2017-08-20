package org.drmc.rasd.service.fichiers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 *
 * @author RABBAH
 */
public interface IGestionFichiers {

    public File creerFichierTemporaire(String nomFichier, String extension) throws IOException;

    public void couperCollerFichier(File fichierSource, String dossierDestination);

    public void ecrireMessageDansFichier(String message, File fichierSortie);

    public String lireMessageFichier(File fichierLecture);
    
    public String getExtensionFichier(File fichier);
    
    public File[] listeFichiers(String cheminRepertoire);
    
    public File[] listeFichiersExtension(String cheminRepertoire, String extension);
 
    public boolean repertoireContientFichier(String cheminRepertoire);
    
    public boolean supprimerFichier(Path cheminFichierSource);
}
