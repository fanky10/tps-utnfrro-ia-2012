/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import java.util.Arrays;
import java.util.List;
import org.grupoia.main.tpdos.mockedobjects.MockedCiudades;
import org.grupoia.main.tpdos.ptoa.explcomb.PermutationGenerator;

/**
 * Deja de explorar una ruta tan pronto como su distancia total, hasta ese momento, sea mayor que la que se ha marcado como la mas corta.
 * @author Fanky10 <fanky10@gmail.com>
 */
public class RamificacionAcotacionSolucion{
    // la ruta + corta ( con distancia total )
    // lista nodos recorridos. 
    // las relaciones entre nodos.
    private HojaRuta hojaRutaMasCorta = null;
    private List<Ciudad> ciudadesDisponibles = MockedCiudades.getCiudades();
    
    // buscar un buen algoritmo que genere una lista de hojas de ruta!
    // al encontrarlo aplicarle para cada iteracion, nuestro algoritmo de validacion. de distancia y esa cosa loca (:
    public static void main(String args[]){
        
        Integer ciudadSeleccionada = -1;
        List<Ciudad> ciudadesDisponibles = MockedCiudades.getCiudades();
        List<Distancia[]> result = new java.util.ArrayList<Distancia[]>();
        Mapa mapa = MockedCiudades.generaMapa();
        
        int[] indices;
        
        PermutationGenerator x = new PermutationGenerator(ciudadesDisponibles.size());
        while (x.hasMore()) {
            indices = x.getNext();
            if(ciudadSeleccionada>=0 && indices[0] != ciudadSeleccionada){ // aca chequear con cual quiero empezar (:
                continue;
            }  
            
            Ciudad[] row = new Ciudad[indices.length];
            for (int i = 0; i < indices.length; i++) {
                //que arranque con la primer ciudad no mas
                row[i] = ciudadesDisponibles.get(indices[i]);
            }
            List<Ciudad> hr = Arrays.asList(row);
            System.out.println("permutacion generada: "+hr);
            //todo / cada dos, generar una map.getDistancia(c1, c2).
        }
        
    }
}
