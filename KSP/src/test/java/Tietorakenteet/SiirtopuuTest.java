package Tietorakenteet;

import org.junit.Test;
import org.junit.Assert;

public class SiirtopuuTest {

    private Solmu s = new Solmu(0, null, null, null, null);
    private Siirtopuu p = new Siirtopuu(s);

    @Test
    public void getJuuriToimii() {
        Assert.assertEquals(s, p.getJuuri());
    }

    @Test
    public void korkeusOikein() {
        Assert.assertEquals(0, p.korkeus(s));
    }

    @Test
    public void arvoKasvaa() {
        p.kasvataArvoa(s);
        Assert.assertEquals(1, s.getArvo());
    }

    @Test
    public void osoitinSiirtyy() {
        Solmu n = new Solmu(0, null, null, null, null);
        s.setLapsi1(n);
        p.siirraOsoitin(0);
        Assert.assertEquals(n, p.getOsoitin());
    }
}
