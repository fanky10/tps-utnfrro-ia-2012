/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.primero;

import org.grupoia.main.tpdos.common.NodoArbol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public abstract class AlgoritmoSolucion {
    protected List<NodoArbol> visitedList = new ArrayList<NodoArbol>();
    public abstract void mostrarLista(NodoArbol nodo);
    public abstract NodoArbol buscarObjetivo(NodoArbol nodo,NodoArbol objetivo);
    public void printVisited(){
        for(NodoArbol na: visitedList){
            System.out.println("visited: "+na);
        }
    }

    public List<NodoArbol> getVisitedList() {
        return visitedList;
    }
    
}
