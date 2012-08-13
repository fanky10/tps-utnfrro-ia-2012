/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.escalada.gui;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

public class TableColumnSizeTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                // prepare table
                JTable table = new JTable(new String[][]{
                            {"Row 1 Col A", "Row 1 Col B"},
                            {"Row 2 Col A", "Row 2 Col B"}},
                        new String[]{"ColA", "ColB"});
                table.doLayout();
                Dimension d = new Dimension(300, 500);
                table.setMinimumSize(d);
                table.setSize(d);
                table.setMaximumSize(d);
                JScrollPane scroll = new JScrollPane(table);
                scroll.setSize(d);
                // add into scroll pane
                f.getContentPane().add(scroll);
                f.setSize(d);

                // turn off auto resize
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                int tWidth = table.getWidth();
                System.out.println("headerwith (: " + table.getTableHeader().getWidth());
                int cCount = table.getTableHeader().getColumnModel().getColumnCount();
                for (int i = 0; i < cCount; i++) {
                    TableColumn tc = table.getTableHeader().getColumnModel().getColumn(i);
                    tc.setPreferredWidth(300/(cCount-1));
                }
                // set preferred column widths
//                int index = 0;
//                while (index < 2) {
//                    TableColumn a = table.getColumnModel().getColumn(index);
//                    a.setPreferredWidth(tWidth/5);
//                    index++;
//                }

//                f.pack();

                f.setVisible(true);
            }
        });
    }
}
