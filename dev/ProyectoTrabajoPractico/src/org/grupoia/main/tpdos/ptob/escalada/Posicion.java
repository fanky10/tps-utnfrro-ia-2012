/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptob.escalada;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Posicion {

    private Integer x;
    private Integer y;

    public Posicion(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString(){
        return "["+x+","+y+"]";
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * 
     * @param proximaPosicion
     * @param objetivo
     * @return -1 actual es peor, 1 actual mejor, 0 llegamos!
     */
    public int compareToX(Posicion proximaPosicion, Posicion objetivo) {
        //primero comparamos la x
        Integer xDiffActual = objetivo.getX() - this.getX();
        Integer xDiffNueva = objetivo.getX() - proximaPosicion.getX();
        if (this.getX() == objetivo.getX()) { // llegue!
            return 0;
        }
        return (xDiffActual > xDiffNueva ? -1 : 1);

    }

    public int compareToY(Posicion proximaPosicion, Posicion objetivo) {
        //primero comparamos la x
        if (this.getY() == objetivo.getY()) { // llegue!
            return 0;
        }

        Integer yDiffActual = objetivo.getY() - this.getY();
        Integer yDiffNueva = objetivo.getY() - proximaPosicion.getY();
        return (yDiffActual > yDiffNueva ? -1 : 1);

    }
}
