/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import java.util.ArrayList;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Mapa extends ArrayList<Distancia> {
    
    public Distancia getDistancia(Ciudad d1, Ciudad d2){
        for(Distancia dist: this){
            if(dist.getOrigen().equals(d1) && dist.getDestino().equals(d2)){
                return dist;
            }
        }
        throw new IllegalArgumentException("distancia no encontrada: d1 "+d1+ " d2 "+d2);
    }
}
