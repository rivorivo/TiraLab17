package Tietorakenteet;

import junit.framework.Assert;
import org.junit.Test;

public class LinklistTest {

    Linklist l = new Linklist();

    @Test
    public void uusiAlkioMeneeVikaksi() {
        Assert.assertEquals(null, l.getVika());
        l.uusiAlkio(22);
        Assert.assertEquals(22, l.getVika().getArvo());
    }

    @Test
    public void getAlkioJaGetVikaToimii() {

        l.uusiAlkio(1);
        l.uusiAlkio(2);
        l.uusiAlkio(3);
        l.uusiAlkio(4);

        Assert.assertEquals(2, l.getAlkio(2).getArvo());
        Assert.assertEquals(1, l.getAlkio(3).getArvo());
        Assert.assertEquals(4, l.getVika().getArvo());
    }

    @Test
    public void pituusToimii() {

        l.uusiAlkio(1);
        l.uusiAlkio(2);
        l.uusiAlkio(3);
        l.uusiAlkio(4);

        Assert.assertEquals(4, l.pituus());
    }

}
