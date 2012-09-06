/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.mochila;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Elemento {

    private String nombre;
    private double valor;
    private double peso;

    public Elemento(String nombre, double valor, double peso) {
        this.nombre = nombre;
        this.peso = peso;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("%-15s %,12.2f %,12.2f", nombre, valor, peso);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
