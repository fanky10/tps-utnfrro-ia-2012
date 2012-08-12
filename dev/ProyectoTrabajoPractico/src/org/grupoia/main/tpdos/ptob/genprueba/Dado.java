package org.grupoia.main.tpdos.ptob.genprueba;

import java.awt.Color;

public class Dado {
    
    public static MyColor[] COLORES_DISPONIBLES = new MyColor[]{new MyColor(Color.WHITE,"Blanco"),new MyColor(Color.BLACK, "Negro"),new MyColor(Color.BLUE, "Azul"),new MyColor(Color.GREEN, "Verde"),new MyColor(Color.RED, "Rojo")};
    private Color color;

    public Dado(Color color) {
        this.color = color;
    }

    public Dado() {
        this(COLORES_DISPONIBLES[0].getColor());
    }

    public String toString() {
        return getColor().toString();
    }

    public void cambiaColor() {
        for (int i = 0; i < COLORES_DISPONIBLES.length; i++) {
            Color c = COLORES_DISPONIBLES[i].getColor();
            if (c.equals(color)) {
                if (i < (COLORES_DISPONIBLES.length - 1)) {
                    color = COLORES_DISPONIBLES[i + 1].getColor();
                    return;
                }
            }
        }
        color = COLORES_DISPONIBLES[0].getColor();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
