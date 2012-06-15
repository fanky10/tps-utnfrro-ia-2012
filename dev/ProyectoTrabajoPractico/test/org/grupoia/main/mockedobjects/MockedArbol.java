/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.mockedobjects;

import java.util.ArrayList;
import java.util.List;
import org.grupoia.main.tpdos.ptoa.ramacot.Hoja;
import org.grupoia.main.tpdos.ptoa.ramacot.NodoArbol;
import org.grupoia.main.tpdos.ptoa.ramacot.Raiz;
import org.grupoia.main.tpdos.ptoa.ramacot.Rama;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class MockedArbol {
    public static NodoArbol getNodoArbolValido(){
        return new Hoja(30);
    }
    public static NodoArbol getNodoArbolInvalido(){
        return new Hoja(3005);
    }
    public static Raiz generaArbol() {
        //todas las hojas
        List<NodoArbol> hojasIzq = new ArrayList<NodoArbol>();
        Hoja h = new Hoja(1);
        hojasIzq.add(h);
        h = new Hoja(14);
        hojasIzq.add(h);


        List<NodoArbol> hojasDer = new ArrayList<NodoArbol>();
        h = new Hoja(25);
        hojasDer.add(h);
        h = new Hoja(35);
        hojasDer.add(h);

        //ramas primer nivel
        List<NodoArbol> ramas = new ArrayList<NodoArbol>();
        Rama rIzq = new Rama(10, hojasIzq);
        ramas.add(rIzq);
        Rama rDer = new Rama(30, hojasDer);
        ramas.add(rDer);

        //raiz
        return new Raiz(ramas);
    }
}
