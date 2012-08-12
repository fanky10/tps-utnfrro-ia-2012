/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.escalada;

import java.awt.Dimension;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Escalador {
    private static Boolean DEBUG = true;
    private Posicion posicionActual;
    private Posicion posicionObjetivo;

    public Escalador(Posicion posicionActual, Posicion posicionObjetivo) {
        this.posicionActual = posicionActual;
        this.posicionObjetivo = posicionObjetivo;
    }

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(Posicion posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Posicion getPosicionObjetivo() {
        return posicionObjetivo;
    }

    public void setPosicionObjetivo(Posicion posicionObjetivo) {
        this.posicionObjetivo = posicionObjetivo;
    }

    public int evaluaPosicionX(Posicion proximaPosicion) {
        debug("posicion actual: "+posicionActual);
        debug("posicion nueva: "+proximaPosicion);
        debug("posicion objetivo: "+posicionObjetivo);
        return posicionActual.compareToX(proximaPosicion, posicionObjetivo);
    }

    public int evaluaPosicionY(Posicion proximaPosicion) {
        debug("posicion actual: "+posicionActual);
        debug("posicion nueva: "+proximaPosicion);
        debug("posicion objetivo: "+posicionObjetivo);
        
        return posicionActual.compareToY(proximaPosicion, posicionObjetivo);
    }

    public Posicion muevePosicionX(Integer movimiento) {
        return new Posicion(getPosicionActual().getX() + movimiento, getPosicionActual().getY());
    }
    public Posicion muevePosicionY(Integer movimiento) {
        return new Posicion(getPosicionActual().getX(), getPosicionActual().getY()+movimiento);
    }
    
    public static Posicion buscaNuevaPosicion(Posicion pActual,Posicion pObjetivo){
        Escalador escalador = new Escalador(pActual, pObjetivo);
        debug("\tevaluando X");
        Posicion p = null;
        int movimiento = -1;
        while (true) {
            p = escalador.muevePosicionX(movimiento);
            int estado = escalador.evaluaPosicionX(p);
            debug("estado: "+estado);
            if (estado == 0) {
                debug("llegue!");
                break;
            } else if (estado < 0) {//no estoy en una buena posicion
                //rewrite!
                debug("sobrescribiendo mi posicion chota");
                escalador.setPosicionActual(p);
                return p;
            } else {//estoy en una buena posicion!
                movimiento = -movimiento;
            }
            debug("=======================================");
            


        }
        debug("\tevaluando Y");
        movimiento = -1;
        while (true) {
            p = escalador.muevePosicionY(movimiento);
            int estado = escalador.evaluaPosicionY(p);
            debug("estado: "+estado);
            if (estado == 0) {
                debug("llegue!");
                break;
            } else if (estado < 0) {//no estoy en una buena posicion
                //rewrite!
                debug("sobrescribiendo mi posicion chota");
                escalador.setPosicionActual(p);
                return p;
            } else {//estoy en una buena posicion!
                movimiento = -movimiento;
            }
            debug("=======================================");
            

        }
        //se supone que siempre es la mejorcita (:
        return null;//
        
    }

    public static void main(String args[]) {
        Posicion pActual = new Posicion(1, 1);
        Posicion pObjetivo = new Posicion(5, 7);
        Escalador escalador = new Escalador(pActual, pObjetivo);
        int movimiento = -1;
        while (true) {
            Posicion p = escalador.muevePosicionX(movimiento);
            int estado = escalador.evaluaPosicionX(p);
            debug("estado: "+estado);
            if (estado == 0) {
                debug("llegue!");
                break;//llegue!
            } else if (estado < 0) {//no estoy en una buena posicion
                //rewrite!
                debug("sobrescribiendo mi posicion chota");
                escalador.setPosicionActual(p);
            } else {//estoy en una buena posicion!
                movimiento = -movimiento;
            }
            debug("=======================================");
            

        }
        movimiento = -1;
        while (true) {
            Posicion p = escalador.muevePosicionY(movimiento);
            int estado = escalador.evaluaPosicionY(p);
            debug("estado: "+estado);
            if (estado == 0) {
                debug("llegue!");
                break;//llegue!
            } else if (estado < 0) {//no estoy en una buena posicion
                //rewrite!
                debug("sobrescribiendo mi posicion chota");
                escalador.setPosicionActual(p);
            } else {//estoy en una buena posicion!
                movimiento = -movimiento;
            }
            debug("=======================================");
            

        }
    }
    private static void debug(String text){
        if(DEBUG){
            System.out.println(text);
        }
    }
}
