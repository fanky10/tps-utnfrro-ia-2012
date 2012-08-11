/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DiagPrimero.java
 *
 * Created on Aug 10, 2012, 9:05:00 PM
 */
package org.grupoia.main.tpdos.ptoa.primero.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import org.grupoia.main.tpdos.common.Hoja;
import org.grupoia.main.tpdos.common.NodoArbol;
import org.grupoia.main.tpdos.common.Raiz;
import org.grupoia.main.tpdos.common.Rama;

/**
 *
 * @author fanky
 */
public class DiagPrimero extends javax.swing.JDialog {

    private static final Boolean DEBUG = true;
    private DynamicTree dynamicTree = null;

    /** Creates new form DiagPrimero */
    public DiagPrimero(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        setLocationRelativeTo(null);
    }

    private void init() {
        dynamicTree = new DynamicTree();
        populateTree(dynamicTree);
        treePanel.add(dynamicTree);
    }

    public void populateTree(DynamicTree treePanel) {
        String p1Name = new String("Parent 1");
        String p2Name = new String("Parent 2");
        String c1Name = new String("Child 1");
        String c2Name = new String("Child 2");

        DefaultMutableTreeNode p1, p2;

        p1 = treePanel.addObject(null, p1Name);
        p2 = treePanel.addObject(null, p2Name);

        treePanel.addObject(p1, c1Name);
        treePanel.addObject(p1, c2Name);

        treePanel.addObject(p2, c1Name);
        treePanel.addObject(p2, c2Name);
    }

    private void createNodes(DefaultMutableTreeNode top) {
        NodoArbol raiz = generaArbol();
        List<NodoArbol> ramas = raiz.getNodosHijos();
        //ver de hacer una recursiva (:
        for (NodoArbol r : ramas) {
            DefaultMutableTreeNode rama = new DefaultMutableTreeNode("Rama " + r.getValue());
            top.add(rama);
            for (NodoArbol hoja : r.getNodosHijos()) {
                rama.add(new DefaultMutableTreeNode(hoja));
            }
        }
    }

    public static Raiz generaArbol() {
        //todas las hojas
        List<NodoArbol> hojasIzq = new ArrayList<NodoArbol>();
        Hoja h = new Hoja(1);
        hojasIzq.add(h);
        h = new Hoja(14);
        hojasIzq.add(h);


        List<NodoArbol> hojasDer = new ArrayList<NodoArbol>();
        h = new Hoja(25);
        hojasDer.add(h);
        h = new Hoja(35);
        hojasDer.add(h);

        //ramas primer nivel
        List<NodoArbol> ramas = new ArrayList<NodoArbol>();
        Rama rIzq = new Rama(10, hojasIzq);
        ramas.add(rIzq);
        Rama rDer = new Rama(30, hojasDer);
        ramas.add(rDer);

        //raiz
        return new Raiz(ramas);
    }

    private void eliminarNodo() {
        dynamicTree.removeCurrentNode();
    }

    private void agregarNodo() {
        // primero buscarlo y seleccionarlo (?
        // si no lo encuentro, agregarlo jeje
        dynamicTree.addObject(txtNodoNuevo.getText());
    }

    private void buscarNodo() {
    }

    private void cerrar() {
        this.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarNodo = new javax.swing.JButton();
        btnEliminarNodo = new javax.swing.JButton();
        txtNodoNuevo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtNodoObjetivo = new javax.swing.JTextField();
        btnBuscarNodo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        treePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nodos"));

        btnAgregarNodo.setText("Agregar");
        btnAgregarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarNodoActionPerformed(evt);
            }
        });

        btnEliminarNodo.setText("Eliminar");
        btnEliminarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarNodoActionPerformed(evt);
            }
        });

        txtNodoNuevo.setText("Nodo");
        txtNodoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNodoNuevoActionPerformed(evt);
            }
        });
        txtNodoNuevo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNodoNuevoFocusGained(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(txtNodoNuevo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnAgregarNodo)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEliminarNodo)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(txtNodoNuevo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAgregarNodo)
                    .add(btnEliminarNodo))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));

        txtNodoObjetivo.setText("Nodo Objetivo");
        txtNodoObjetivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNodoObjetivoActionPerformed(evt);
            }
        });
        txtNodoObjetivo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNodoObjetivoFocusGained(evt);
            }
        });

        btnBuscarNodo.setText("Buscar");
        btnBuscarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNodoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtNodoObjetivo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
            .add(jPanel3Layout.createSequentialGroup()
                .add(btnBuscarNodo)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(txtNodoObjetivo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnBuscarNodo))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        treePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        treePanel.setLayout(new java.awt.BorderLayout());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(treePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(treePanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarNodoActionPerformed
        eliminarNodo();
    }//GEN-LAST:event_btnEliminarNodoActionPerformed

    private void btnAgregarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarNodoActionPerformed
        agregarNodo();
    }//GEN-LAST:event_btnAgregarNodoActionPerformed

    private void txtNodoNuevoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNodoNuevoFocusGained
        txtNodoNuevo.selectAll();
    }//GEN-LAST:event_txtNodoNuevoFocusGained

    private void txtNodoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNodoNuevoActionPerformed
        agregarNodo();
    }//GEN-LAST:event_txtNodoNuevoActionPerformed

    private void txtNodoObjetivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNodoObjetivoActionPerformed
        buscarNodo();
    }//GEN-LAST:event_txtNodoObjetivoActionPerformed

    private void btnBuscarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNodoActionPerformed
        buscarNodo();
    }//GEN-LAST:event_btnBuscarNodoActionPerformed

    private void txtNodoObjetivoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNodoObjetivoFocusGained
        txtNodoObjetivo.selectAll();
    }//GEN-LAST:event_txtNodoObjetivoFocusGained

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(DiagPrimero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagPrimero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagPrimero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagPrimero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DiagPrimero dialog = new DiagPrimero(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarNodo;
    private javax.swing.JButton btnBuscarNodo;
    private javax.swing.JButton btnEliminarNodo;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel treePanel;
    private javax.swing.JTextField txtNodoNuevo;
    private javax.swing.JTextField txtNodoObjetivo;
    // End of variables declaration//GEN-END:variables
}
