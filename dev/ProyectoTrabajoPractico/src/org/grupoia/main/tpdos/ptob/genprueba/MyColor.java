/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.genprueba;

import java.awt.Color;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class MyColor {

    private Color color;
    private String nombre;

    public MyColor(Color color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }
    public String toString(){
        return nombre;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}