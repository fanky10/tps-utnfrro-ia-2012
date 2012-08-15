/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.common;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class NodoObjetivo extends NodoArbol{
    public NodoObjetivo(Integer value){
        super(value);
    }
    @Override
    public String toString(){
        return "Nodo Obetivo - "+getValue();
    }
}
