/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.mockedobjects;

import java.util.ArrayList;
import java.util.List;
import org.grupoia.main.tpdos.common.Raiz;
import org.grupoia.main.tpdos.common.NodoArbol;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class MockedArbol {
    public static NodoArbol getNodoArbolValido(){
        return new NodoArbol(30);
    }
    public static NodoArbol getNodoArbolInvalido(){
        return new NodoArbol(3005);
    }
    public static Raiz generaArbol() {
        //todas las NodoArbols
        List<NodoArbol> NodoArbolsIzq = new ArrayList<NodoArbol>();
        NodoArbol h = new NodoArbol(1);
        NodoArbolsIzq.add(h);
        
        //muchas hojitas (:
        NodoArbolsIzq.add(new NodoArbol(110));
        NodoArbolsIzq.add(new NodoArbol(101));
        //una NodoArbol
        NodoArbol na = new NodoArbol(210);
        NodoArbolsIzq.add(na);
        h = new NodoArbol(220);
        na.addChild(h);
        h.addChild(new NodoArbol(14));
        
        


        List<NodoArbol> NodoArbolsDer = new ArrayList<NodoArbol>();
        h = new NodoArbol(25);
        NodoArbolsDer.add(h);
        h = new NodoArbol(35);
        NodoArbolsDer.add(h);

        //NodoArbols primer nivel
        List<NodoArbol> NodoArbols = new ArrayList<NodoArbol>();
        NodoArbol rIzq = new NodoArbol(10, NodoArbolsIzq);
        NodoArbols.add(rIzq);
        NodoArbol rDer = new NodoArbol(30, NodoArbolsDer);
        NodoArbols.add(rDer);
        h = new NodoArbol(141);
        NodoArbols.add(h);

        //raiz
        return new Raiz(NodoArbols);
    }
}
