/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import org.grupoia.main.tpdos.common.NodoArbol;

/**
 * En este metodo se evalúa cada nodo del mismo nivel antes de proceder al proceder al siguiente nivel mas profundo.
 * @author Fanky10 <fanky10@gmail.com>
 */
public class PrimeroAnchuraSolucion extends AlgoritmoSolucion{

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
        if (!nodo.getNodosHijos().isEmpty()) {
            if (nodo.equals(objetivo)) {
                return nodo;
            }
            for (NodoArbol na : nodo.getNodosHijos()) {
                visitedList.add(na);
                if(na.equals(objetivo)){
                    return na;
                }
            }
            for (NodoArbol na : nodo.getNodosHijos()) {
                mostrarLista(na);
            }
        }
        return null;
    }
    
}
