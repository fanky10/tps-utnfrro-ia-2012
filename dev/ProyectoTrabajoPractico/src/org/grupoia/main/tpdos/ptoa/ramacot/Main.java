/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Main {
    public static void main(String args[]){
        //generamos un arbol, con todos sus nodos (:
        Raiz r = generaArbol();
        //comentado para no debuggear
//        muestraRecorrido(new PrimeroProfundidadSolucion(),r);
//        buscaObjetivo(new PrimeroProfundidadSolucion(), r, new Hoja(50));
//        muestraRecorrido(new PrimeroAnchuraSolucion(),r);
//        buscaObjetivo(new PrimeroAnchuraSolucion(), r, new Hoja(30));
        muestraRecorrido(new PlanificacionAcotacionSolucion(),r);
        
        
    }
    private static void muestraRecorrido(AlgoritmoSolucion algor, Raiz r){
        System.out.println("recorrido");
        algor.mostrarLista(r);
        if(algor instanceof PlanificacionAcotacionSolucion){
            ((PlanificacionAcotacionSolucion) algor).mostrarHojaRuta();
        }
        algor.printVisited();
        
    }
    private static void buscaObjetivo(AlgoritmoSolucion algor, Raiz r, NodoArbol objetivo){
        System.out.println("buscando Objetivo");
        NodoArbol encontrado = algor.buscarObjetivo(r, objetivo);
        algor.printVisited();
        if(encontrado!=null){
            System.out.println("lo encontre!!: "+encontrado);
        }else{
            System.out.println("me canse de buscarlo u__u");
        }
        System.out.println("fin solucion (:");
    }
    private static Raiz generaArbol(){
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
        Rama rIzq = new Rama(10,hojasIzq);
        ramas.add(rIzq);
        Rama rDer = new Rama(30,hojasDer);
        ramas.add(rDer);
        
        //raiz
        return new Raiz(ramas);
    }
}
