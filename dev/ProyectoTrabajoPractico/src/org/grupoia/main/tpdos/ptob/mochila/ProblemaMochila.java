/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class ProblemaMochila {

    private List<Elemento> almacen = new ArrayList<Elemento>();
    private List<Elemento> mochila = new ArrayList<Elemento>();
    private final double pesoMaximo;

    public ProblemaMochila(int pm) {
        pesoMaximo = pm;
        cargarDatos();
    }

    private void cargarDatos() {
        almacen.add(new Elemento("TV", 300, 15));
        almacen.add(new Elemento("PS3", 100, 3));
        almacen.add(new Elemento("Libro Java", 10, 1));
        almacen.add(new Elemento("DVD Player", 5, 0.5));
        almacen.add(new Elemento("Blu-Ray", 50, 0.5));
        almacen.add(new Elemento("Balon", 30, 0.5));
        almacen.add(new Elemento("iPod", 150, 1));
        almacen.add(new Elemento("Printer", 20, 4));
        almacen.add(new Elemento("VideoBeam", 200, 4));
        almacen.add(new Elemento("LapTop", 20, 3));
        almacen.add(new Elemento("iPad", 150, 2));
        almacen.add(new Elemento("PC", 100, 5));
        almacen.add(new Elemento("BlackBerry", 150, 0.5));
    }

    public void mostrarMochila() {
        double pesoMochila = 0;
        double valorMochila = 0;
        for (Elemento e : getElementosSeleccionados().keySet()) {
            Boolean isSelected = getElementosSeleccionados().get(e);
            System.out.println(e + " seleccionado:" + isSelected);
            if (isSelected) {
                pesoMochila += e.getPeso();
                valorMochila += e.getValor();
            }
        }
        System.out.println("------");
        System.out.printf("Peso  = %,12.2f %n", pesoMochila);
        System.out.printf("Valor = %,12.2f %n", valorMochila);
    }

    public void resolverProblema() {
        // Comparador para ordenar los elementos del almacen por valor
        Comparator cmp = new Comparator<Elemento>() {

            public int compare(Elemento x, Elemento y) {
                return (int) (x.getValor() - y.getValor());
            }
        };
        Collections.sort(almacen, cmp);  // ordena usando el comparador anterior
        Collections.reverse(almacen);   // reversa el orden de los elementos

        double pesoMochila = 0;
        int posicion = 0;
        while (pesoMochila < pesoMaximo && posicion < almacen.size()) {
            Elemento tmp = almacen.get(posicion);
            if (pesoMochila + tmp.getPeso() <= pesoMaximo) {
                mochila.add(tmp);
                pesoMochila += tmp.getPeso();
            }
            posicion++;
        }
    }

    public static void main(String[] args) {
        // Crear una mochila que soporta hasta 20 Kg. de peso
        ProblemaMochila pm = new ProblemaMochila(20);
        pm.resolverProblema();
        pm.mostrarMochila();
    }

    public List<Elemento> getAlmacen() {
        return almacen;
    }

    public void setAlmacen(List<Elemento> almacen) {
        this.almacen = almacen;
    }

    public List<Elemento> getMochila() {
        return mochila;
    }

    public void setMochila(List<Elemento> mochila) {
        this.mochila = mochila;
    }

    public Map<Elemento, Boolean> getElementosSeleccionados() {
        Map<Elemento, Boolean> result = new LinkedHashMap<Elemento, Boolean>();
        for (Elemento e : almacen) {
            result.put(e, Boolean.FALSE);
        }
        for (Elemento e : mochila) {
            if (result.containsKey(e)) {
                result.put(e, Boolean.TRUE);
            }
        }
        return result;
    }
}