/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.primero;

import org.grupoia.main.tpdos.common.NodoArbol;
import org.grupoia.main.tpdos.mockedobjects.MockedArbol;

/**
 * Se explora c/camino posible hacia el objetivo hasta su conclusion, antes de intentar otro camino.
 * @author Fanky10 <fanky10@gmail.com>
 */
public class PrimeroProfundidadSolucion extends AlgoritmoSolucion {

    /**
     * @param nodo 
     */
    @Override
    public void mostrarLista(NodoArbol nodo) {
        if (!nodo.getNodosHijos().isEmpty()) {
            visitedList.add(nodo);
            for (NodoArbol na : nodo.getNodosHijos()) {
                mostrarLista(na);
            }
        }
        //si llegue hasta aca, es hoja o finalizo con los bichos
        visitedList.add(nodo);

    }

    @Override
    public NodoArbol buscarObjetivo(NodoArbol nodo, NodoArbol objetivo) {
        debug("evaluando nodo: "+nodo);
        // primero me fijo si soy yo el elegido (jaja)
        // luego me fijo los demas.
        visitedList.add(nodo);
        if (nodo.equals(objetivo)) {
            debug("encontrado: "+nodo);
            return nodo;
        }
        if (!nodo.getNodosHijos().isEmpty()) {
            for (NodoArbol na : nodo.getNodosHijos()) {
                NodoArbol encontrado = buscarObjetivo(na, objetivo);
                if(encontrado!=null){
                    debug("child encontrado: "+encontrado);
                    return encontrado;
                }
            }
        }
        //si llegue hasta aca, es hoja o finalizo con los bichos
//        visitedList.add(nodo);
//        if (nodo.equals(objetivo)) {
//            debug("encontrado: "+nodo);
//            return nodo;
//        }
//        debug("NO ENCONTRADO: nodo actual "+nodo);
        return null;
    }
    public static Boolean DEBUG = true;
    
    private static void debug(String text){
        if(DEBUG){
            System.out.println("DEBUG: "+text);
        }
    }
    public static void main(String args[]){
        AlgoritmoSolucion solucion = new PrimeroProfundidadSolucion();
        NodoArbol encontrado = solucion.buscarObjetivo(MockedArbol.generaArbol(), new NodoArbol(25));
        System.out.println("encontrado!: "+encontrado);
        solucion.printVisited();
    }
}
