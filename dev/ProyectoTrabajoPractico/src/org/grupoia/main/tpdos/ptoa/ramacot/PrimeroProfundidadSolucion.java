/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

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
        if (!nodo.getNodosHijos().isEmpty()) {
            visitedList.add(nodo);
            if (nodo.equals(objetivo)) {
                return nodo;
            }
            for (NodoArbol na : nodo.getNodosHijos()) {
                if(buscarObjetivo(na, objetivo)!=null){
                    return na;
                }
            }
        }
        //si llegue hasta aca, es hoja o finalizo con los bichos
        visitedList.add(nodo);
        if (nodo.equals(objetivo)) {
            return nodo;
        }
        return null;
    }
}
