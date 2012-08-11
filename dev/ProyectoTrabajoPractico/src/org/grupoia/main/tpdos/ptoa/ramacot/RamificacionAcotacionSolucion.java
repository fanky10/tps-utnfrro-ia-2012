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

    public static List<HojaRuta> getHojaRuta(Ciudad ciudad) {
        Integer ciudadSeleccionada = getIndex(ciudad);
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
                List<Ciudad> ciudadesPosibles = Arrays.asList(row);
                //System.out.println("permutacion generada: " + ciudadesPosibles);
                HojaRuta hr = new HojaRuta();
                //todo / cada dos, generar una map.getDistancia(c1, c2).
                for (int j = 0; j < ciudadesPosibles.size(); j++) {
                    Distancia d = null;
                    if (j == (ciudadesPosibles.size() - 1)) {
                        d = mapa.getDistancia(ciudadesPosibles.get(j), ciudadesPosibles.get(0));
                    } else {
                        d = mapa.getDistancia(ciudadesPosibles.get(j), ciudadesPosibles.get(j + 1));
                    }
                    if (d != null) {//avoid nullpointerException (:
                        hr.add(d);
                    }
                }
                hojasPosibles.add(hr);
                System.out.println("HojaRuta generada: " + hr + " con distancia: " + hr.getDistanciaTotal());
                // si estoy en la ultima y no hay mejor opcion, es la mejor opc (:
                // o si estoy en la ultima y mi opcion es mejor (:
                // hay una mejor opcion.
                if ((i + 1) == indices.length
                        && (mejorOpcion == null || mejorOpcion.getDistanciaTotal() > hr.getDistanciaTotal())) {
                    mejorOpcion = hr;
                } //si la actual (ya sea ultima o no, es peor que la posta then fuck it!
                else if (mejorOpcion != null && mejorOpcion.getDistanciaTotal() < hr.getDistanciaTotal()) {
                    System.out.println("basta de buscar, esta es malisima!");
                    break;
                }
            }


        }
        System.out.println("Mejor hoja de ruta!: " + mejorOpcion + " con distancia total: " + mejorOpcion.getDistanciaTotal());
        return hojasPosibles;

    }

    private static Integer getIndex(Ciudad ciudad) {
        int i = 0;
        for (Ciudad c : MockedCiudades.getCiudades()) {
            if (ciudad != null && c.equals(ciudad)) {
                return i;
            }
            i++;
        }
        return -1;
    }

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
                List<Ciudad> ciudadesPosibles = Arrays.asList(row);
                //System.out.println("permutacion generada: " + ciudadesPosibles);
                HojaRuta hr = new HojaRuta();
                //todo / cada dos, generar una map.getDistancia(c1, c2).
                for (int j = 0; j < ciudadesPosibles.size(); j++) {
                    Distancia d = null;
                    if (j == (ciudadesPosibles.size() - 1)) {
                        d = mapa.getDistancia(ciudadesPosibles.get(j), ciudadesPosibles.get(0));
                    } else {
                        d = mapa.getDistancia(ciudadesPosibles.get(j), ciudadesPosibles.get(j + 1));
                    }
                    if (d != null) {//avoid nullpointerException (:
                        hr.add(d);
                    }
                }
                System.out.println("HojaRuta generada: " + hr + " con distancia: " + hr.getDistanciaTotal());
                // si estoy en la ultima y no hay mejor opcion, es la mejor opc (:
                // o si estoy en la ultima y mi opcion es mejor (:
                // hay una mejor opcion.
                if ((i + 1) == indices.length
                        && (mejorOpcion == null || mejorOpcion.getDistanciaTotal() > hr.getDistanciaTotal())) {
                    mejorOpcion = hr;
                } //si la actual (ya sea ultima o no, es peor que la posta then fuck it!
                else if (mejorOpcion != null && mejorOpcion.getDistanciaTotal() < hr.getDistanciaTotal()) {
                    System.out.println("basta de buscar, esta es malisima!");
                    break;
                }
            }


        }
        System.out.println("Mejor hoja de ruta!: " + mejorOpcion + " con distancia total: " + mejorOpcion.getDistanciaTotal());


    }
}
