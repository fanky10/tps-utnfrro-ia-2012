/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class BaseTest {

    protected void testBuscaObjetivoValido(AlgoritmoSolucion algor, Raiz r, NodoArbol objetivo) {
        NodoArbol encontrado = algor.buscarObjetivo(r, objetivo);
        algor.printVisited();
        assertTrue(encontrado!=null);
    }
    protected void testBuscaObjetivoInvalido(AlgoritmoSolucion algor, Raiz r, NodoArbol objetivo) {
        NodoArbol encontrado = algor.buscarObjetivo(r, objetivo);
        algor.printVisited();
        assertTrue(encontrado==null);
        
    }
}
