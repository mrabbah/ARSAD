/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drmc.rasd.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.drmc.rasd.modele.MessageEnvoye;

/**
 *
 * @author usim
 */
public class ModelMessageEnvoye extends AbstractTableModel {

    private final List<MessageEnvoye> messageEnvoye;
    private final String[] entetes = { "Entete", "Corps", "Date Message", "Heure Envoie",  "Envoi Valide"};

    public ModelMessageEnvoye(List<MessageEnvoye> messageEnvoye) {
//        super();
        this.messageEnvoye = messageEnvoye;
    }

    @Override
    public int getRowCount() {
        return messageEnvoye.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
           
            case 0:
                return messageEnvoye.get(rowIndex).getEntete();
            case 1:
                return messageEnvoye.get(rowIndex).getCorps();
            case 2:
                return messageEnvoye.get(rowIndex).getDateMessage();
            case 3:
                return messageEnvoye.get(rowIndex).getDateEnvoie();
            case 4:
                return messageEnvoye.get(rowIndex).isEnvoiValide();


            default:
                return null; //Ne devrait jamais arriver
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
}
