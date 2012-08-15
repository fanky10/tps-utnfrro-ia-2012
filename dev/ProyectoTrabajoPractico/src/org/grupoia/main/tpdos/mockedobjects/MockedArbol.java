/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.mockedobjects;

import java.util.ArrayList;
import java.util.List;
import org.grupoia.main.tpdos.common.Raiz;
import org.grupoia.main.tpdos.common.NodoArbol;
import org.grupoia.main.tpdos.common.NodoObjetivo;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class MockedArbol {
    public static NodoArbol getNodoArbolValido(){
        return new NodoObjetivo(30);
    }
    public static NodoArbol getNodoArbolInvalido(){
        return new NodoObjetivo(3005);
    }
    public static Raiz generaArbol() {
        List<NodoArbol> rootChildren = new ArrayList<NodoArbol>();
        
        NodoArbol rama = new NodoArbol(10);
        NodoArbol ramaInner = new NodoArbol(211);
        ramaInner.addChild(new NodoArbol(11));
        rama.addChild(ramaInner);
        ramaInner = new NodoArbol(212);
        ramaInner.addChild(new NodoArbol(110));
        rama.addChild(ramaInner);
        ramaInner = new NodoArbol(213);
        ramaInner.addChild(new NodoArbol(111));
        rama.addChild(ramaInner);
        rootChildren.add(rama);
        
        rama = new NodoArbol(30);
        rama.addChild(new NodoArbol(25));
        rama.addChild(new NodoArbol(35));
        rootChildren.add(rama);
        
        rootChildren.add(new NodoArbol(241));  
        
        return new Raiz(rootChildren);
    }
}
