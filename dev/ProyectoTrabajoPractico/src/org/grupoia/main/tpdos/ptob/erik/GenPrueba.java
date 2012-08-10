package org.grupoia.main.tpdos.ptob.erik;

import java.awt.Color;

public class GenPrueba {
    // los metodos se hacen¨acceso public private static si es estatico
    // lo que devuelven el nombre y entre parentesis los parametros y por ultimo las LLAVES

    public static void main(String[] args) {
        
        Dados dados = new Dados();
        
        Dado da = new Dado();
        da.setColor(Color.yellow);
        dados.add(da);
        
        da = new Dado();
        da.setColor(Color.red);
        dados.add(da);
        
        da = new Dado();
        da.setColor(Color.BLUE);
        dados.add(da);
        
        da = new Dado();
        da.setColor(Color.BLACK);
        dados.add(da);
        
        boolean finalizo = false;
        //generar una posible solucion
        //configurar dados
        //verificar si el objetivo se cumplió
        //si no verifica, cambiar configuracion
        do {
            
            if (dados.verificaConfig())
            {
                finalizo = true;
                
            }
            else
            {
                dados.cambiaConfig();
            }
            
        } while (!finalizo);
        
        
        
        
    }
}
