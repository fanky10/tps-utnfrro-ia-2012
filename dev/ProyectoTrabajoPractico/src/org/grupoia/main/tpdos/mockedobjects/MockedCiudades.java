/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.grupoia.main.tpdos.mockedobjects;

import java.util.ArrayList;
import java.util.List;
import org.grupoia.main.tpdos.ptoa.ramacot.Ciudad;
import org.grupoia.main.tpdos.ptoa.ramacot.Distancia;
import org.grupoia.main.tpdos.ptoa.ramacot.Mapa;

/**
 *
 * @author Fanky10 <fanky10@gmail.com>
 */
public class MockedCiudades {
    public static List<Ciudad> getCiudades(){
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades.add(new Ciudad("Sirio"));
        ciudades.add(new Ciudad("Canopus"));
        ciudades.add(new Ciudad("Aldebaran"));
        ciudades.add(new Ciudad("Betelgeuse"));
        
        return ciudades;
    }
    public static List<Distancia> generaDistanciasCiudades(){
        List<Distancia> result = new ArrayList<Distancia>();
        Ciudad c1 = new Ciudad("Sirio");
        Ciudad c2 = new Ciudad("Canopus");
        Ciudad c3 = new Ciudad("Aldebaran");
        Ciudad c4 = new Ciudad("Betelgeuse");
        
        result.add(new Distancia(c1, c2, 2));
        result.add(new Distancia(c1, c3, 10));
        result.add(new Distancia(c1, c4, 9));
        
        result.add(new Distancia(c2, c1, 2));
        result.add(new Distancia(c2, c3, 7));
        result.add(new Distancia(c2, c4, 12));
        
        result.add(new Distancia(c3, c1, 10));
        result.add(new Distancia(c3, c2, 7));
        result.add(new Distancia(c3, c4, 8));
        
        result.add(new Distancia(c4, c1, 9));
        result.add(new Distancia(c4, c2, 12));
        result.add(new Distancia(c4, c3, 8));
        
        return result;
    }
    public static Mapa generaMapa(){
        Mapa m = new Mapa();
        
        Ciudad c1 = new Ciudad("Sirio");
        Ciudad c2 = new Ciudad("Canopus");
        Ciudad c3 = new Ciudad("Aldebaran");
        Ciudad c4 = new Ciudad("Betelgeuse");
        
        m.add(new Distancia(c1, c2, 2));
        m.add(new Distancia(c1, c3, 10));
        m.add(new Distancia(c1, c4, 9));
        
        m.add(new Distancia(c2, c1, 2));
        m.add(new Distancia(c2, c3, 7));
        m.add(new Distancia(c2, c4, 12));
        
        m.add(new Distancia(c3, c1, 10));
        m.add(new Distancia(c3, c2, 7));
        m.add(new Distancia(c3, c4, 8));
        
        m.add(new Distancia(c4, c1, 9));
        m.add(new Distancia(c4, c2, 12));
        m.add(new Distancia(c4, c3, 8));
        
        return m;
    }
}
