/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.mockedobjects;

import org.grupoia.main.tpdos.ptob.escalada.Posicion;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class MockedPosiciones {
    public static Posicion getPosicionInicial(){
        return new Posicion(1, 2);
    }
    public static Posicion getPosicionObjetivo(){
        return new Posicion(5, 7);
    }
}
