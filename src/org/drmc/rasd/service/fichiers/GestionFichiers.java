package org.drmc.rasd.service.fichiers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RABBAH
 */
public class GestionFichiers implements IGestionFichiers {

    private static final String FS = System.getProperty("file.separator");

    @Override
    public File creerFichierTemporaire(String nomFichier, String extension) throws IOException {
        return File.createTempFile(nomFichier, extension);
    }

    @Override
    public void couperCollerFichier(File fichierSource, String dossierDestination) {
        try {
            Path cheminFichierSource = fichierSource.toPath();
            String cheminFichierSortie = dossierDestination + FS + fichierSource.getName();
            Path cheminFichierDestination = Paths.get(cheminFichierSortie);
            byte[] donneesFichierSource = Files.readAllBytes(cheminFichierSource);
            Files.write(cheminFichierDestination, donneesFichierSource);

            

            this.supprimerFichier(cheminFichierSource);
        } catch (IOException ex) {
            Logger.getLogger(GestionFichiers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ecrireMessageDansFichier(String message, File fichierSortie) {
        FileWriter ffw = null;
        try {
            ffw = new FileWriter(fichierSortie);
            ffw.write(message);
            ffw.close();
        } catch (IOException ex) {
            Logger.getLogger(GestionFichiers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ffw != null) {
                    ffw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(GestionFichiers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public String lireMessageFichier(File fichierLecture) {
        String messageFichier = "";
        Scanner sc = null;
        try {
            sc = new Scanner(fichierLecture);//ouverture du fichier            
            while (sc.hasNext()) {
                messageFichier = messageFichier + sc.nextLine() + "\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionFichiers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return messageFichier;
    }

    @Override
    public String getExtensionFichier(File fichier) {

        String nomFichier = fichier.getName();
        //On decoupe le nom de fichier sur le point "."
        String[] tabString = nomFichier.split("\\.");

        int longeurTableau = tabString.length;
        //On cherche le dernier element du tableau
        String extension = "." + tabString[longeurTableau - 1];
        return extension;
    }

    @Override
    public File[] listeFichiers(String cheminRepertoire) {
        File repertoire = new File(cheminRepertoire);
        return repertoire.listFiles();
    }

    @Override
    public File[] listeFichiersExtension(String cheminRepertoire, String extension) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean repertoireContientFichier(String cheminRepertoire) {
        File repertoire = new File(cheminRepertoire);
        return repertoire.listFiles().length > 0;
    }

    @Override
    public boolean supprimerFichier(Path cheminFichierSource) {
        try {
            //        String nomfichier=fichier.getName();
//        String cheminfichier=fichier.getPath();
//        boolean test = fichier.delete();
//        System.out.println("supprimer  "+cheminfichier+" "+nomfichier);
            Files.delete(cheminFichierSource);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(GestionFichiers.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ouvrirFichier(String cheminFichierSource) {

        /*
         Process exec = Runtime.getRuntime().exec("explorer.exe " + cheminFichierSource);
         return true;
         } catch (IOException ex) {
         Logger.getLogger(GestionFichiers.class.getName()).log(Level.SEVERE, null, ex);
         return false;
         } */
        try {
            Runtime.getRuntime().exec("explorer.exe " + cheminFichierSource);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
