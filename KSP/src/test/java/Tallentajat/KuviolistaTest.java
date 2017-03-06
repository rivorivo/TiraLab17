package Tallentajat;

import Tietorakenteet.*;
import org.junit.Assert;
import org.junit.Test;

public class KuviolistaTest {

    private Kuviolista k = new Kuviolista();
    private Tuloslista t = new Tuloslista();

    @Test
    public void getParasToimii() {
        t.lisaaPeli(1, 0, 1);
        t.lisaaPeli(1, 0, 1);
        t.lisaaPeli(1, 1, 2);
        k.talletaKuvio(t);
        t.lisaaPeli(1, 0, 1);
        k.talletaKuvio(t);
        t.lisaaPeli(1, 0, 1);
        k.talletaKuvio(t);

        Assert.assertEquals("Kivi", k.getParas(1, 0));
    }

    @Test
    public void puuAlustuu() {
        Siirtopuu p = k.alustaTilastopuu();
        Solmu s = p.getJuuri();

        Assert.assertNotEquals(null, s.getLapsi1());
        Assert.assertNotEquals(null, s.getLapsi2().getLapsi2());
        Assert.assertNotEquals(null, s.getLapsi1().getLapsi2().getLapsi3());

    }
}
