/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.mufidjamaluddin.RoosterApp.View;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mufidjamaluddin
 */
public class TableView extends DefaultTableModel
{   
    /**
     * Instansiasi
     * @param attrVal
     * @param attrName
     * @return 
     */
    public static TableView getInstance(String[][] attrVal, String[] attrName)
    {
        return new TableView(attrVal, attrName);
    }
    
    /**
     * Konstruktor
     * @param attrVal
     * @param attrName
     */
    public TableView(String[][] attrVal, String[] attrName)
    {
        super(attrVal, attrName);
    }
    
    /**
     * 
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) 
    {
        return false;
    }
}
