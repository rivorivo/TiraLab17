package KSPapp;

import Tietorakenteet.*;
import junit.framework.Assert;
import org.junit.Test;

public class TekoalyTest {

    Tuloslista lista = new Tuloslista();
    Tekoaly aly = new Tekoaly(lista);

    @Test
    public void avaussiirtoPaperi() {
        Assert.assertEquals("Paperi", aly.getSiirto());
    }

    @Test
    public void siirtaaMenestyksenPerusteella() {
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(0, 2, 1);
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(2, 1, 1);
        Assert.assertEquals("Kivi", aly.menestyksenPerusteella());

    }

    @Test
    public void vastustajanParas() {
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(0, 1, 2);
        lista.lisaaPeli(0, 1, 2);
        lista.lisaaPeli(0, 0, 1);
        Assert.assertEquals("Sakset", aly.vastustajanParas());
    }

    @Test
    public void tunnistaaKuvion() {
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 0, 2);
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 0, 2);
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 1, 0);
        Assert.assertEquals("Paperi", aly.toistuvatKuviot());

    }
}
