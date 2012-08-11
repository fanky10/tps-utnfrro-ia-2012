/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.ptoa.ramacot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.grupoia.main.tpdos.mockedobjects.MockedCiudades;
import org.grupoia.main.tpdos.ptoa.explcomb.PermutationGenerator;

/**
 * Deja de explorar una ruta tan pronto como su distancia total, hasta ese momento, sea mayor que la que se ha marcado como la mas corta.
 * @author Fanky10 <fanky10@gmail.com>
 */
public class RamificacionAcotacionSolucion {
    // la ruta + corta ( con distancia total )
    // lista nodos recorridos. 
    // las relaciones entre nodos.

    private HojaRuta hojaRutaMasCorta = null;
    private List<Ciudad> ciudadesDisponibles = MockedCiudades.getCiudades();

    // buscar un buen algoritmo que genere una lista de hojas de ruta!
    // al encontrarlo aplicarle para cada iteracion, nuestro algoritmo de validacion. de distancia y esa cosa loca (:
    public static void main(String args[]) {

        Integer ciudadSeleccionada = 1;
        List<Ciudad> ciudadesDisponibles = MockedCiudades.getCiudades();
        List<HojaRuta> hojasPosibles = new ArrayList<HojaRuta>();
        HojaRuta mejorOpcion = null;
        Mapa mapa = MockedCiudades.generaMapa();

        int[] indices;

        PermutationGenerator x = new PermutationGenerator(ciudadesDisponibles.size());
        while (x.hasMore()) {
            indices = x.getNext();
            if (ciudadSeleccionada >= 0 && indices[0] != ciudadSeleccionada) { // aca chequear con cual quiero empezar (:
                continue;
            }

            Ciudad[] row = new Ciudad[indices.length];
            for (int i = 0; i < indices.length; i++) {
                //que arranque con la primer ciudad no mas
                row[i] = ciudadesDisponibles.get(indices[i]);
            }
            List<Ciudad> ciudadesPosibles = Arrays.asList(row);
            //System.out.println("permutacion generada: " + ciudadesPosibles);
            HojaRuta hr = new HojaRuta();
            //todo / cada dos, generar una map.getDistancia(c1, c2).
            for (int i = 0; i < ciudadesPosibles.size(); i++) {
                Distancia d = null;
                if (i == (ciudadesPosibles.size() - 1)) {
                    d = mapa.getDistancia(ciudadesPosibles.get(i), ciudadesPosibles.get(0));
                } else {
                    d = mapa.getDistancia(ciudadesPosibles.get(i), ciudadesPosibles.get(i+1));
                }
                if(d!=null){//avoid nullpointerException (:
                    hr.add(d);
                }
            }
            System.out.println("HojaRuta generada: " + hr + " con distancia: "+hr.getDistanciaTotal() );
            hojasPosibles.add(hr);
        }
        //ahora evaluamos de alguna forma, la mejor hoja de ruta! :D
        for(HojaRuta hr: hojasPosibles){
            if(mejorOpcion==null){
                mejorOpcion = hr;
                continue;
            }
            //si la nueva hoja de ruta es mejor sobre escribir la actual (:
            if(mejorOpcion.getDistanciaTotal()>hr.getDistanciaTotal()){
                mejorOpcion = hr;
            }
        }
        System.out.println("Mejor hoja de ruta!: " + mejorOpcion + " con distancia total: " + mejorOpcion.getDistanciaTotal());
        

    }
}
