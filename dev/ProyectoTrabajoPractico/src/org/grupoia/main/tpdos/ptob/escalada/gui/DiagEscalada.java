/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DiagEscalada.java
 *
 * Created on Aug 12, 2012, 4:29:09 PM
 */
package org.grupoia.main.tpdos.ptob.escalada.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.grupoia.main.tpdos.ptob.escalada.Escalador;
import org.grupoia.main.tpdos.ptob.escalada.Posicion;

/**
 *
 * @author fanky
 */
public class DiagEscalada extends javax.swing.JDialog {

    private List<Posicion> movimientos = new ArrayList<Posicion>();
    private static final Integer CELDA = 25;
    private Posicion pActual = new Posicion(1, 2);
    private Posicion pObjetivo = new Posicion(5, 7);
    private PnlTablero tablero;

    /** Creates new form DiagEscalada */
    public DiagEscalada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        setLocationRelativeTo(null);
    }

    private void init() {
        Escalador.DEBUG = false;
        generaTablero();
    }

    private void generaTablero() {
        pnlTablero.removeAll();
        pnlTablero.updateUI();
        tablero = new PnlTablero(pnlTablero.getSize());
        pnlTablero.setSize(tablero.getSize());
        pnlTablero.add(tablero);
        pnlTablero.repaint();
        muevePosicionActual();
        tablero.muevePosicionObjetivo(pObjetivo.getX(), pObjetivo.getY());
    }

    private void muevePosicionActual() {
        tablero.muevePosicionActual(pActual.getX(), pActual.getY());
    }

    private void siguienteMovimiento() {
        if (pActual != null) {
            pActual = Escalador.buscaNuevaPosicion(pActual, pObjetivo);
            if (pActual != null) {
                movimientos.add(pActual);
                generaTablero();
            }
        }else{
            btnNextMove.setEnabled(false);
        }
    }
    private void actualizaPosicion(){
        Integer posicionX = Integer.parseInt(txtPosicionX.getText());
        Integer posicionY = Integer.parseInt(txtPosicionY.getText());
        if(rbPosicionActual.isSelected()){
            pActual = new Posicion(posicionX, posicionY);
        }
        else if(rbPosicionObjetivo.isSelected()){
            pObjetivo = new Posicion(posicionX, posicionY);
        }else{
            throw new IllegalArgumentException("radio button not supported ");
        }
        generaTablero();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlTablero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbPosicionActual = new javax.swing.JRadioButton();
        rbPosicionObjetivo = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        txtPosicionX = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtPosicionY = new javax.swing.JTextField();
        btnActualizarPosicion = new javax.swing.JButton();
        btnNextMove = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlTablero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTablero.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        buttonGroup1.add(rbPosicionActual);
        rbPosicionActual.setSelected(true);
        rbPosicionActual.setText("Posicion Actual");
        jPanel2.add(rbPosicionActual);

        buttonGroup1.add(rbPosicionObjetivo);
        rbPosicionObjetivo.setText("Posicion Objetivo");
        jPanel2.add(rbPosicionObjetivo);

        jPanel1.add(jPanel2);

        txtPosicionX.setText("Posicion X");
        txtPosicionX.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPosicionXFocusGained(evt);
            }
        });
        jPanel3.add(txtPosicionX);

        jPanel4.setLayout(new java.awt.GridLayout());
        jPanel3.add(jPanel4);

        txtPosicionY.setText("Posicion Y");
        txtPosicionY.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPosicionYFocusGained(evt);
            }
        });
        jPanel3.add(txtPosicionY);

        jPanel1.add(jPanel3);

        btnActualizarPosicion.setText("Actualizar Posicion");
        btnActualizarPosicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPosicionActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarPosicion);

        btnNextMove.setText("SiguienteMovimiento");
        btnNextMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextMoveActionPerformed(evt);
            }
        });
        jPanel1.add(btnNextMove);

        btnReiniciar.setText("Reiniciar");
        jPanel1.add(btnReiniciar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, pnlTablero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 500, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlTablero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 500, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextMoveActionPerformed
        siguienteMovimiento();
    }//GEN-LAST:event_btnNextMoveActionPerformed

    private void btnActualizarPosicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPosicionActionPerformed
        actualizaPosicion();
    }//GEN-LAST:event_btnActualizarPosicionActionPerformed

    private void txtPosicionXFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPosicionXFocusGained
        txtPosicionX.selectAll();
    }//GEN-LAST:event_txtPosicionXFocusGained

    private void txtPosicionYFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPosicionYFocusGained
        txtPosicionY.selectAll();
    }//GEN-LAST:event_txtPosicionYFocusGained

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
            java.util.logging.Logger.getLogger(DiagEscalada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiagEscalada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiagEscalada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiagEscalada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DiagEscalada dialog = new DiagEscalada(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPosicion;
    private javax.swing.JButton btnNextMove;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pnlTablero;
    private javax.swing.JRadioButton rbPosicionActual;
    private javax.swing.JRadioButton rbPosicionObjetivo;
    private javax.swing.JTextField txtPosicionX;
    private javax.swing.JTextField txtPosicionY;
    // End of variables declaration//GEN-END:variables
}
