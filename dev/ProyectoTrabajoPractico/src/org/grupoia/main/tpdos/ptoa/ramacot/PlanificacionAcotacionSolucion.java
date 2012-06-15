/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

/**
 * Deja de explorar una ruta tan pronto como su distancia total, hasta ese momento, sea mayor que la que se ha marcado como la mas corta.
 * @author Fanky10 <fanky10@gmail.com>
 */
public class PlanificacionAcotacionSolucion extends AlgoritmoSolucion {

    protected Ruta hojaRuta = new Ruta();
    protected Integer distanciaAnterior = 1000;

    @Override
    public void mostrarLista(NodoArbol nodo) {
        if (!nodo.getNodosHijos().isEmpty()) {
            visitedList.add(nodo);
            hojaRuta.add(nodo);
            for (NodoArbol na : nodo.getNodosHijos()) {
                mostrarLista(na);
            }
        }
        //si llegue hasta aca, es hoja o finalizo con los bichos
        visitedList.add(nodo);
        hojaRuta.add(nodo);
        //llegue a una hoja --> printeo! :D
        System.out.println("hoja de ruta en hoja: ");
        for(NodoArbol na: hojaRuta){
            System.out.println("na: "+na);
        }
    }

    public void mostrarHojaRuta() {
        for (NodoArbol na : hojaRuta) {
            System.out.println("visited: " + na);
        }
    }

    @Override
    public NodoArbol buscarObjetivo(NodoArbol nodo, NodoArbol objetivo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
