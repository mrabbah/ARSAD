package org.drmc.rasd.service.message;

import java.util.Date;
import org.drmc.rasd.modele.ModelMessage;
import org.drmc.rasd.modele.Observation;

/**
 *
 * @author RABBAH
 */
public class GestionMessage implements IGestionMessage {

    @Override
    public boolean messageEstValide(String message) {
        String messageAvalider = message.replaceAll("\n", " ");//j enleve seulement les retours a la ligne et je les remplace par un espace
        boolean enteteEstValide = this.verifierEnteteMessage(messageAvalider);
       //si l entete n est pas valide on retourne false

        return enteteEstValide;

    }

    @Override
    public boolean messageEstValide(String message, ModelMessage mm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String encodeObservation(Observation o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Observation decodeMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean verifierEnteteMessage(String message) {
        try {
            String messageCorrige = message.trim();//effacer espace du début et de la fin du message
            String tabMessage[] = messageCorrige.split(" ");//diviser le message en tableau en prenant en consideration l'espace
            String entete = tabMessage[0];//l entete est le premier element du tableau (chaine)
            if (entete.length() != 6) {
                return false;
            }
            String date = tabMessage[2]; // la date et heure se trouve sur l element 3

            if (date.length() != 6) //verifier si la date et heure se compose de 6 caracteres
            {
                return false;
            }
            String indicatifOACI = tabMessage[1];
            if (indicatifOACI.length() != 4) //verifier si la date et heure se compose de 6 caracteres
            {
                return false;
            }
            /*
             String heure = date.substring(2, 4);//Obtenir l heure
             if (heure.equals("06") || heure.equals("12") || heure.equals("18")||heure.equals("00")) {
             if (!entete.equals("SMMC40")) {
             System.out.println("false3");
             return false;
             }
             } else if (heure.equals("03") || heure.equals("09") || heure.equals("15") || heure.equals("21")) {
             if (!entete.equals("SIMC40")) {
             System.out.println("false4");
             return false;
             }
             } else if (heure.equals("01") || heure.equals("02") || heure.equals("04") || heure.equals("05")
             || heure.equals("07") || heure.equals("08") || heure.equals("10") || heure.equals("11") 
             || heure.equals("13") || heure.equals("14") || heure.equals("16") || heure.equals("17") 
             || heure.equals("19") || heure.equals("20") || heure.equals("22") || heure.equals("23")) {
           
             if (!entete.equals("SNMC40")) {
             System.out.println("false5");
             return false;
             }else{
             System.out.println("false6");
             return true;
             }
             } else {
             System.out.println("false7");
             return false;
             }
        
             */
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean verifierIndicatifOmm(String message) {
        String messageCorrige = message.trim();//effacer espace du début et de la fin du message
        String tabMessage[] = messageCorrige.split(" ");//diviser le message en tableau en prenant en consideration l'espace
        String indicatifOmm = tabMessage[6];//l indicatif omm se trouve a la 7 eme position
        String entete = tabMessage[0];
        System.out.println(indicatifOmm);
        if (entete.equals("SMMC40") || entete.equals("SNMC40") || entete.equals("SIMC40")) {
            if (indicatifOmm.length() != 5) //l indicatif omm doit etre de longeur 5
            {
                System.out.println("false8");
                return false;
            }
        }
        return true;
    }

    @Override
    public Date getDateMessage(String message) {
        String messageCorrige = message.trim();//effacer espace du début et de la fin du message
        String messageAvalider = messageCorrige.replaceAll("\n", " ");//j enleve seulement les retours a la ligne et je les remplace par un espace
        String tabMessage[] = messageAvalider.split(" ");//diviser le message en tableau en prenant en consideration l'espace
        String date = tabMessage[2]; // la date et heure se trouve sur l element 3
        String heure = date.substring(2, 4);//Obtenir l heure
        String jour = date.substring(0, 2);//obtenir le jour
        Date maintenant = new Date();//obtenri la date actuelle pour chercher l annee
        int anneeActuelle = maintenant.getYear();//obtenir l annee actuelle
        int moisActuelle = maintenant.getMonth();//obtenir le mois courant
        int heureMessage = Integer.parseInt(heure);//obtenir l heure du message
        int jourMessage = Integer.parseInt(jour);//obtenir le jour du message
        //Construire la date du message
        Date dateMessage = new Date(anneeActuelle, moisActuelle, jourMessage, heureMessage, 0);

        return dateMessage;
    }

    @Override
    public String getEntete(String message) {
        String messageCorrige = message.trim();//effacer espace du début et de la fin du message
        String messageAvalider = messageCorrige.replaceAll("\n", " ");//j enleve seulement les retours a la ligne et je les remplace par un espace
        String tabMessage[] = messageAvalider.split(" ");//diviser le message en tableau en prenant en consideration l'espace
        String entete = tabMessage[0];//l entete est le premier element du tableau (chaine)
        return entete;
    }
    public String getEnteteMessageRecu(String message) {
        String messageCorrige = message.trim();//effacer espace du début et de la fin du message
        String messageAvalider = messageCorrige.replaceAll("\n", " ");//j enleve seulement les retours a la ligne et je les remplace par un espace
        String tabMessage[] = messageAvalider.split(" ");//diviser le message en tableau en prenant en consideration l'espace
        String entete = tabMessage[0]+" "+tabMessage[1];//l entete est le premier element du tableau (chaine)
        return entete;
    }

    @Override
    public String getIndicatifOmm(String message) {
        String messageCorrige = message.trim();//effacer espace du début et de la fin du message
        String messageAvalider = messageCorrige.replaceAll("\n", " ");//j enleve seulement les retours a la ligne et je les remplace par un espace
        String tabMessage[] = messageAvalider.split(" ");//diviser le message en tableau en prenant en consideration l'espace
        return tabMessage[5];
    }

    @Override
    public String getIndicatifOaci(String message) {
        String messageCorrige = message.trim();//effacer espace du début et de la fin du message
        String messageAvalider = messageCorrige.replaceAll("\n", " ");//j enleve seulement les retours a la ligne et je les remplace par un espace
        String tabMessage[] = messageAvalider.split(" ");//diviser le message en tableau en prenant en consideration l'espace
        return tabMessage[1];
    }
}
