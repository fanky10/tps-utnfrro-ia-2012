/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.escalada.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class DiagTablero extends JFrame {

    private static final String TITLE = "Tablero ";
    public static int TAM = 10;
    private static final Integer ACTUAL = 1;
    private static final Integer OBJETIVO = 2;
    private int tablero[][] = new int[TAM][TAM];  //Representación del tablero
    private int visible[][] = new int[TAM][TAM]; //0 tapado, 1 descubierto, 2 bandera

    public DiagTablero() {
        //Configuracion de la ventana
        setVisible(true);
        setSize(405, 440);
        setTitle(TITLE);
        setResizable(false);

        //Crea el tablero
        crearTablero();

    }

    private void crearTablero() {
        //Inicializa el tablero
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                tablero[f][c] = 0;
                visible[f][c] = 0;
            }
        }
    }

    public void mueveCasilla(int f, int c) {
        //Si la casilla esta tapada//Descubre la casilla
        visible[f][c] = 1;
        repaint();
    }

    public void paint(Graphics g) {
        g.setFont(new Font("ARIAL", Font.BOLD, 14));
        g.clearRect(0, 0, getWidth(), 40);
        //Pinta las casillas
        for (int f = 0; f < TAM; f++) {
            for (int c = 0; c < TAM; c++) {
                int x = c * 40;
                int y = f * 40 + 40;
                if (visible[f][c] == ACTUAL) {
                    g.setColor(Color.gray);
                    g.fillRect(x, y, 40, 40);
                } else if (visible[f][c] == OBJETIVO) {
                    g.setColor(Color.blue);
                    g.fillRect(x, y, 40, 40);
                }
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, 40, 40);
            }
        }
    }

    //Funciones para abreviar letras.
    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public int min(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String arg[]) {
        new DiagTablero();
    }
}
