package org.grupoia.main.tpdos.ptob.genprueba;

import java.awt.Color;

public class GenPrueba {
    // los metodos se hacen¨acceso public private static si es estatico
    // lo que devuelven el nombre y entre parentesis los parametros y por ultimo las LLAVES

    public static void main(String[] args) {
        
        Dados dados = new Dados();
        dados.add(new Dado());
        dados.add(new Dado());
        dados.add(new Dado());
        
        boolean finalizo = false;
        //generar una posible solucion
        //configurar dados
        //verificar si el objetivo se cumplió
        //si no verifica, cambiar configuracion
        int i = 0;
        while(finalizo || i<20){
            finalizo = dados.verificaConfig();
            if (!finalizo){
                dados.cambiaConfig();
                System.out.println("nueva config:"+dados);
            }
            
            i++;
        }
        
        
        
        
    }
}
