/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;



/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Ruta extends java.util.ArrayList<NodoArbol>{
    
    public Integer getDistanciaActual(){
        Integer dist = 0;
        for(NodoArbol na: this){
            dist = na.getValue() + dist;
        }
        return dist;
    }
    /**
     * si el nodo ya existe, no me importa (: no lo agrego
     * @param nodo
     * @return 
     */
    @Override
    public boolean add(NodoArbol nodo){
        for(NodoArbol na: this){
            if(na.equals(nodo)){
                return this.add(nodo);
            }
        }
        return false;
    }
}
