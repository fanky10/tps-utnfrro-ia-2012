/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Distancia {
    private Ciudad origen;
    private Ciudad destino;
    private Integer distancia;

    public Distancia(Ciudad origen, Ciudad destino, Integer distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }
    
    @Override
    public String toString(){
        return origen + " -- " + destino + ": "+distancia; 
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }
    
}
