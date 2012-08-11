/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class HojaRuta extends java.util.ArrayList<Distancia> {

    public Integer getDistanciaTotal() {
        Integer result = 0;
        for (Distancia d : this) {
            result = result + d.getDistancia();
        }
        return result;
    }
}
