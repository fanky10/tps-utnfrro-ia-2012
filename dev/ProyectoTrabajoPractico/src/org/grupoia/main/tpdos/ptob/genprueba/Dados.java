package org.grupoia.main.tpdos.ptob.genprueba;

import java.util.ArrayList;

public class Dados extends ArrayList<Dado> {

    public boolean verificaConfig() {
        for (int i = 0; i < this.size(); i++) {
            Dado d = this.get(i);
            for (int j = (i + 1); j < this.size(); j++) {
                Dado da = this.get(j);
                if (d.getColor().equals(da.getColor())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void cambiaConfig() {
        for (int i = 0; i < this.size(); i++) {
            Dado d = this.get(i);
            for (int j = (i + 1); j < this.size(); j++) {
                Dado da = this.get(j);
                if (d.getColor().equals(da.getColor())) {
                    da.cambiaColor();
                    return;
                }
            }
        }
    }
}
