/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DiagRamAcot.java
 *
 * Created on Aug 11, 2012, 3:41:30 PM
 */
package org.grupoia.main.tpdos.ptoa.ramacot.gui;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.grupoia.main.tpdos.mockedobjects.MockedCiudades;
import org.grupoia.main.tpdos.ptoa.ramacot.Ciudad;
import org.grupoia.main.tpdos.ptoa.ramacot.Distancia;
import org.grupoia.main.tpdos.ptoa.ramacot.HojaRuta;
import org.grupoia.main.tpdos.ptoa.ramacot.RamificacionAcotacionSolucion;

/**
 *
 * @author fanky
 */
public class DiagRamAcot extends javax.swing.JDialog {

    private List<Distancia> distancias = MockedCiudades.generaDistanciasCiudades();
    private List<HojaRuta> hojasGen;

    /** Creates new form DiagRamAcot */
    public DiagRamAcot(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        setLocationRelativeTo(null);
    }

    private void init() {
        //inicializo las tablas locas
        tblParCiudades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblParCiudades.setAutoCreateRowSorter(false);
        tblParCiudades.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    return;
                }
                btnEditarDistancia.setEnabled(!(tblParCiudades.getSelectedRow() < 0));
                txtDistancia.grabFocus();
            }
        });
        populaDistancias();
        populaCombo();
        buscarHojaDeRuta();
    }

    private void populaDistancias() {
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Origen", "Destino", "Distancia"}, 0);
        for (Distancia d : distancias) {
            tableModel.addRow(new Object[]{d.getOrigen(), d.getDestino(), d.getDistancia()});
        }
        tblParCiudades.setModel(tableModel);
    }

    private void populaCombo() {

        List<Ciudad> ciudadesDisponibles = MockedCiudades.getCiudades();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("Seleccione una estrella a buscar");
        for (Ciudad c : ciudadesDisponibles) {
            model.addElement(c);

        }
        cmbCiudades.setModel(model);

    }

    private void refrescaTablaResultados() {
        DefaultTableModel tableModel = new DefaultTableModel();
        if (hojasGen == null) {
            tableModel.setColumnIdentifiers(new Object[]{"Seleccione alguna estrella"});
        } else {
            tableModel.setColumnIdentifiers(new Object[]{"Camino", "Distancia"});
            for (HojaRuta d : hojasGen) {
                tableModel.addRow(new Object[]{d, d.getDistanciaTotal()});
            }
        }
        tblResultados.setModel(tableModel);
        for(int i = 0; i< tblResultados.getColumnCount();i++){
            if(i==1){//columna de distancia
                TableColumn tc = tblResultados.getColumnModel().getColumn(i);
                tc.setMaxWidth(80);
            }
        }
    }

    private void editarDistancia() {
        String input = txtDistancia.getText();
        if (input.isEmpty()) {
            return;
        }
        int index = tblParCiudades.getSelectedRow();
        if (index < 0) {
            return;
        }
        try {
            Distancia distancia = distancias.get(index);
            int i = Integer.parseInt(input);
            distancia.setDistancia(i);
            populaDistancias();
        } catch (NumberFormatException x) {
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblParCiudades = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtDistancia = new javax.swing.JTextField();
        btnEditarDistancia = new javax.swing.JButton();
        cmbCiudades = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblParCiudades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblParCiudades);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDistanciaActionPerformed(evt);
            }
        });
        txtDistancia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDistanciaFocusGained(evt);
            }
        });

        btnEditarDistancia.setText("Editar Distancia");
        btnEditarDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDistanciaActionPerformed(evt);
            }
        });

        cmbCiudades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiudadesActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(cmbCiudades, 0, 313, Short.MAX_VALUE)
            .add(jPanel1Layout.createSequentialGroup()
                .add(txtDistancia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 161, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEditarDistancia))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtDistancia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnEditarDistancia))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cmbCiudades, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblResultados);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1145, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane1, 0, 0, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDistanciaActionPerformed

        editarDistancia();     }//GEN-LAST:event_btnEditarDistanciaActionPerformed

    private void txtDistanciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDistanciaFocusGained

        txtDistancia.selectAll();     }//GEN-LAST:event_txtDistanciaFocusGained

    private void txtDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDistanciaActionPerformed

        editarDistancia();     }//GEN-LAST:event_txtDistanciaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrar();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cmbCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiudadesActionPerformed
        buscarHojaDeRuta();
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCiudadesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiagRamAcot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagRamAcot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagRamAcot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagRamAcot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DiagRamAcot dialog = new DiagRamAcot(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                dialog.dispose();
                System.exit(0);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditarDistancia;
    private javax.swing.JComboBox cmbCiudades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblParCiudades;
    private javax.swing.JTable tblResultados;
    private javax.swing.JTextField txtDistancia;
    // End of variables declaration//GEN-END:variables

    private void cerrar() {
        this.dispose();
    }

    private void buscarHojaDeRuta() {
        Ciudad c = null;
        try {
            c = (Ciudad) cmbCiudades.getSelectedItem();

        } catch (ClassCastException x) {
        }
        hojasGen = RamificacionAcotacionSolucion.getHojaRuta(c);
        refrescaTablaResultados();
    }
}
