/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.drmc.rasd.controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.drmc.rasd.modele.Profil;

/**
 *
 * @author usim
 */
public class ModelProfil extends AbstractTableModel {

    private final List<Profil> profil;
    private final String[] entetes = {"Id", "intitule", "login", "password"};

    public ModelProfil(List<Profil> profil) {
//        super();
        this.profil = profil;
    }

    @Override
    public int getRowCount() {
        return profil.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return profil.get(rowIndex).getId();
            case 1:
                return profil.get(rowIndex).getIntitule();
            case 2:
                return profil.get(rowIndex).getLogin();
            case 3:
                return "*****";
           
              
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
    
}
