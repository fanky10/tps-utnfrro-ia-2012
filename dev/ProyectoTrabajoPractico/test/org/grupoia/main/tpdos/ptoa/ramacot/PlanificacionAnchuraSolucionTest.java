/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import org.grupoia.main.mockedobjects.MockedArbol;

import org.junit.Test;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class PlanificacionAnchuraSolucionTest extends BaseTest{
    @Test
    public void testValido(){
        Raiz raiz = MockedArbol.generaArbol();
        this.testBuscaObjetivoValido(new PrimeroAnchuraSolucion(), raiz, MockedArbol.getNodoArbolValido());
        this.testBuscaObjetivoIvalido(new PrimeroAnchuraSolucion(), raiz, MockedArbol.getNodoArbolInvalido());
    }
}