package org.grupoia.main.tpdos.ptob.genprueba;

import java.awt.Color;

public class Dado {

    public static Color[] COLORES_DISPONIBLES = new Color[]{Color.BLACK, Color.BLUE, Color.GREEN, Color.RED};
    private Color color;

    public Dado(Color color) {
        this.color = color;
    }

    public Dado() {
        this(COLORES_DISPONIBLES[0]);
    }

    public String toString() {
        return getColor().toString();
    }

    public void cambiaColor() {
        for (int i = 0; i < COLORES_DISPONIBLES.length; i++) {
            Color c = COLORES_DISPONIBLES[i];
            if (c.equals(color)) {
                if (i < (COLORES_DISPONIBLES.length - 1)) {
                    color = COLORES_DISPONIBLES[i + 1];
                    return;
                }
            }
        }
        color = COLORES_DISPONIBLES[0];
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
