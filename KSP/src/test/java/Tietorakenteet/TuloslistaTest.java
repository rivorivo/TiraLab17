package Tietorakenteet;

import junit.framework.Assert;
import org.junit.Test;

public class TuloslistaTest {

    Tuloslista lista = new Tuloslista();

    @Test
    public void tallentaaJaMuistaaTuloksen() {
        lista.lisaaPeli(1, 1, 0);
        Linklist tulos = lista.getTulos(0);
        Alkio ksiirto = tulos.getVika();
        Alkio siirto = ksiirto.getEdellinen();
        Alkio voittaja = siirto.getEdellinen();

        Assert.assertEquals(0, ksiirto.getArvo());
        Assert.assertEquals(1, siirto.getArvo());
        Assert.assertEquals(1, voittaja.getArvo());

    }

    @Test
    public void laskeePelit() {
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 1, 0);
        lista.lisaaPeli(1, 1, 0);
        Assert.assertEquals(4, lista.size());
    }

}
