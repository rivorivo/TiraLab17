package Tietorakenteet;

import junit.framework.Assert;
import org.junit.Test;

public class AlkioTest {

    private Alkio a = new Alkio(2, null);

    @Test
    public void getArvoToimii() {
        Assert.assertEquals(2, a.getArvo());
    }

    @Test
    public void setArvoToimii() {
        a.setArvo(3);
        Assert.assertEquals(3, a.getArvo());
    }

    @Test
    public void getEdellinenToimii() {
        Alkio b = new Alkio(4, a);
        Assert.assertEquals(a, b.getEdellinen());
    }

    @Test
    public void setEdellinenToimii() {
        Alkio b = new Alkio(4, null);
        a.setEdellinen(b);
        Assert.assertEquals(b, a.getEdellinen());
    }

}
