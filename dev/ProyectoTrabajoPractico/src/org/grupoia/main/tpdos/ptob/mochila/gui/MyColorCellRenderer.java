/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.mochila.gui;

import java.awt.Color;
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
    private java.util.List<Integer> selectedIndexes = new java.util.ArrayList<Integer>();

    public MyColorCellRenderer() {
    }

    public MyColorCellRenderer(java.util.List<Integer> selectedIndexes) {
        this.selectedIndexes = selectedIndexes;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        for(Integer i: selectedIndexes){
            if(i==row){
                JLabel renderer = new JLabel(value.toString());
                renderer.setOpaque(true);
                renderer.setBackground(Color.GREEN);
                renderer.setForeground(Color.BLACK);
                return renderer;
            }
        }
        JLabel renderer = new JLabel(value.toString());
        renderer.setOpaque(true);
        renderer.setBackground(Color.LIGHT_GRAY);
        renderer.setForeground(Color.BLACK);
        return renderer;
        
    }
}
