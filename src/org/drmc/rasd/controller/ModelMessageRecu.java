package org.drmc.rasd.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.drmc.rasd.modele.MessageRecu;

/**
 *
 * @author RABBAH
 */
public class ModelMessageRecu extends AbstractTableModel {

    private final List<MessageRecu> messagesRecus;
    private final String[] entetes = { "Entête", "Corps message", "Date Message", "Heure consommation", "Extention"};

    public ModelMessageRecu(List<MessageRecu> messagesRecus) {
//        super();
        this.messagesRecus = messagesRecus;
    }

    @Override
    public int getRowCount() {
        return messagesRecus.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            
            case 0:
                return messagesRecus.get(rowIndex).getEntete();
            case 1:
                return messagesRecus.get(rowIndex).getCorps();
            case 2:
                
                return messagesRecus.get(rowIndex).getDateMessage();
                
            case 3:
                return messagesRecus.get(rowIndex).getDateConsommation();
            case 4:
                return messagesRecus.get(rowIndex).getExtension();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
}
