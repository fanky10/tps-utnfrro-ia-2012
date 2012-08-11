/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import org.grupoia.main.tpdos.ptoa.primero.PrimeroProfundidadSolucion;
import org.grupoia.main.tpdos.ptoa.primero.PrimeroAnchuraSolucion;
import org.grupoia.main.tpdos.common.Raiz;
import org.grupoia.main.mockedobjects.MockedArbol;
import org.junit.Test;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class SolucionTest extends BaseTest{
    
    @Test
    public void primeroAnchuraTest(){
        Raiz raiz = MockedArbol.generaArbol();
        this.testBuscaObjetivoValido(new PrimeroAnchuraSolucion(), raiz, MockedArbol.getNodoArbolValido());
        this.testBuscaObjetivoInvalido(new PrimeroAnchuraSolucion(), raiz, MockedArbol.getNodoArbolInvalido());
    }
    
    @Test
    public void primeroProfundidadTest(){
        Raiz raiz = MockedArbol.generaArbol();
        this.testBuscaObjetivoValido(new PrimeroProfundidadSolucion(), raiz, MockedArbol.getNodoArbolValido());
        this.testBuscaObjetivoInvalido(new PrimeroProfundidadSolucion(), raiz, MockedArbol.getNodoArbolInvalido());
    }
}
