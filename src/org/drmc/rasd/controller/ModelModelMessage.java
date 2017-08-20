/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.drmc.rasd.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.drmc.rasd.modele.ModelMessage;

/**
 *
 * @author DRMC
 */
public class ModelModelMessage extends AbstractTableModel{
  private final List<ModelMessage> modelMessage;
    private final String[] entetes = {"entete","Nom du model" };

    public ModelModelMessage(List<ModelMessage> modelMessage) {
//        super();
        this.modelMessage = modelMessage;
    }

        public int getRowCount() {
        return modelMessage.size();
    }

        public int getColumnCount() {
        return entetes.length;
    }

        public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return modelMessage.get(rowIndex).getCorpsModel();
            case 1:
                return modelMessage.get(rowIndex).getIntitule();
            
            default:
                return null; //Ne devrait jamais arriver
        }
    }

        public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
}
