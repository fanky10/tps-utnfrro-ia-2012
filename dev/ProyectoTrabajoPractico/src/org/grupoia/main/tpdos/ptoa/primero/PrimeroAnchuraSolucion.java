/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.primero;

import org.grupoia.main.tpdos.common.NodoArbol;
import org.grupoia.main.tpdos.mockedobjects.MockedArbol;

/**
 * En este metodo se evalúa cada nodo del mismo nivel antes de proceder al proceder al siguiente nivel mas profundo.
 * @author Fanky10 <fanky10@gmail.com>
 */
public class PrimeroAnchuraSolucion extends AlgoritmoSolucion {

    @Override
    public void mostrarLista(NodoArbol nodo) {
        if (!nodo.getNodosHijos().isEmpty()) {
            for (NodoArbol na : nodo.getNodosHijos()) {
                visitedList.add(na);
            }
            for (NodoArbol na : nodo.getNodosHijos()) {
                mostrarLista(na);
            }
        }

    }

    @Override
    public NodoArbol buscarObjetivo(NodoArbol nodo, NodoArbol objetivo) {
        debug("buscando nodo: " + objetivo);
        if (!nodo.getNodosHijos().isEmpty()) {

            if (nodo.equals(objetivo)) {
                debug("encontrado: " + nodo);
                return nodo;
            }
            visitedList.add(nodo);
            for (NodoArbol na : nodo.getNodosHijos()) {
                visitedList.add(na);
                if (na.equals(objetivo)) {
                    debug("encontrado: " + na);
                    return na;
                }
            }
            //si para cada hijo no encontro nada, hay que buscar dentro de cada hijo
            // recursive call!
            for (NodoArbol na : nodo.getNodosHijos()) {
                NodoArbol encontrado = buscarObjetivo(na, objetivo);
                if (encontrado != null) {
                    return encontrado;
                }
            }
        }
        debug("no encontre nada: " + nodo);
        return null;
    }
    public static Boolean DEBUG = true;

    private static void debug(String text) {
        if (DEBUG) {
            System.out.println("DEBUG: " + text);
        }
    }

    public static void main(String args[]) {
        AlgoritmoSolucion solucion = new PrimeroAnchuraSolucion();
        NodoArbol encontrado = solucion.buscarObjetivo(MockedArbol.generaArbol(), new NodoArbol(1));
        System.out.println("encontrado!: " + encontrado);
        solucion.printVisited();
    }
}
