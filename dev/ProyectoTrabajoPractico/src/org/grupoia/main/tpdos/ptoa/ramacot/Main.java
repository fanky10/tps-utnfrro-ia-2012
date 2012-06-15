/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Main {

    public void main(String[] args) {
    }

    protected static void muestraRecorrido(AlgoritmoSolucion algor, Raiz r) {

        algor.mostrarLista(r);
        if (algor instanceof PlanificacionAcotacionSolucion) {
            ((PlanificacionAcotacionSolucion) algor).mostrarHojaRuta();
        }
        algor.printVisited();

    }
}
