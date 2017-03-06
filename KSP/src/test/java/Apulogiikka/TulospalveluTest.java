package Apulogiikka;

import Tallentajat.*;
import org.junit.Assert;
import org.junit.Test;

public class TulospalveluTest {

    Tulospalvelu t = new Tulospalvelu();
    Tuloslista l = new Tuloslista();

    @Test
    public void getVoittajaToimii() {
        Assert.assertEquals("kone", t.getVoittaja("Kivi", "Paperi"));
        Assert.assertEquals("pelaaja", t.getVoittaja("Kivi", "Sakset"));
    }

    @Test
    public void voittoGetteritToimii() {
        l.lisaaPeli(1, 1, 0);
        l.lisaaPeli(0, 2, 1);
        l.lisaaPeli(1, 1, 2);
        l.lisaaPeli(2, 1, 1);
        Assert.assertEquals(1, t.getVoitot(l));
        Assert.assertEquals(2, t.getKonevoitot(l));
        Assert.assertEquals(1, t.getTasapelit(l));

    }
}
