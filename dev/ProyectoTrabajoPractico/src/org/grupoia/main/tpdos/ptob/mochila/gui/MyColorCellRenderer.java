/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.mochila.gui;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author facundo
 */
public class MyColorCellRenderer implements TableCellRenderer {

    private static final DefaultTableCellRenderer default_cell_renderer = new DefaultTableCellRenderer();

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            return default_cell_renderer.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
        }
        Component renderer = default_cell_renderer.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
        ((JLabel) renderer).setOpaque(true);
        return default_cell_renderer.getTableCellRendererComponent(jtable, value, isSelected, hasFocus, row, column);
//        try{
//            DataInput di = data_input.get(row);
//            renderer.setBackground(di.getColor());
//            renderer.setForeground(Color.BLACK);
//            return renderer;
//        }catch(Throwable t){
//            System.out.println("some error: "+t.getMessage());
//            
//        }
    }
}
