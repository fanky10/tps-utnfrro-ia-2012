/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.escalada.gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class PnlTablero extends JPanel {

    private static enum EstadoCelda {

        SIN_USO, ESTADO_ACTUAL, ESTADO_OBJETIVO
    };
    public static int TAM = 10;
    private EstadoCelda tablero[][] = new EstadoCelda[TAM][TAM];  //Representación del tablero
    private EstadoCelda visible[][] = new EstadoCelda[TAM][TAM]; //
    private Dimension dCelda = null;
    private Integer constCelda = 10;

    public PnlTablero(Dimension dimension) {
        setSize(dimension);
        init();

    }

    private void init() {
        //configura tamanho de celda
        dCelda = new Dimension((int) getSize().width / TAM, (int) getSize().height / TAM);
        constCelda = (int) getSize().width / TAM;
        //Crea el tablero
        crearTablero();
    }

    private void crearTablero() {
        //Inicializa el tablero
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                tablero[f][c] = EstadoCelda.SIN_USO;
                visible[f][c] = EstadoCelda.SIN_USO;
            }
        }
    }

    public void muevePosicionActual(int f, int c) {
        //Si la casilla esta tapada//Descubre la casilla
        muevePosicion(f, c, EstadoCelda.ESTADO_ACTUAL);
    }

    public void muevePosicionObjetivo(int f, int c) {
        //Si la casilla esta tapada//Descubre la casilla
        muevePosicion(f, c, EstadoCelda.ESTADO_OBJETIVO);
    }

    private void muevePosicion(int f, int c, EstadoCelda estado) {
        eliminaPosicion(estado);
        visible[f][c] = estado;
        repaint();
    }

    private void eliminaPosicion(EstadoCelda estado) {
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                if (visible[f][c] == estado) {
                    visible[f][c] = EstadoCelda.SIN_USO;
                }
            }
        }
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {

        g.setFont(new Font("ARIAL", Font.BOLD, 14));
//        g.clearRect(0, 0, getWidth(), constCelda);

        //Pinta las casillas
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                int x = c * constCelda;
                int y = f * constCelda;
                if (visible[f][c] == EstadoCelda.ESTADO_OBJETIVO) {
                    g.setColor(Color.red);
                    g.fillRect(x, y, constCelda, constCelda);
                } else if (visible[f][c] == EstadoCelda.ESTADO_ACTUAL) {
                    g.setColor(Color.blue);
                    g.fillRect(x, y, constCelda, constCelda);
                } else if (visible[f][c] == EstadoCelda.SIN_USO) {
                    g.setColor(Color.DARK_GRAY);
                }else{
                    g.setColor(Color.BLACK);
                }
                g.drawRect(x, y, constCelda, constCelda);
            }
        }
    }

    public static void main(String args[]) {
        DiagEscalada.main(args);
    }
}
