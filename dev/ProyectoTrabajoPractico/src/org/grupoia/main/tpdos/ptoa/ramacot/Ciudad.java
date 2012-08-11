/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class Ciudad {
    private String nombre;
    public Ciudad(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        return nombre;
    }
    
    @Override
    public boolean equals(Object object){
        if(object instanceof Ciudad){
            Ciudad arg = (Ciudad) object;
            return (this.getNombre().equals(arg.getNombre()));
        }else{
            return false;
        }
    }
    
}
