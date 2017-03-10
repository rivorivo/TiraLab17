package Apulogiikka;

import Tallentajat.*;
import org.junit.Assert;
import org.junit.Test;

public class TulospalveluTest {

    Tulospalvelu t = new Tulospalvelu();
    Tuloslista l = new Tuloslista();

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

    @Test
    public void getVoittajaToimii(){
        Assert.assertEquals("pelaaja", t.getVoittaja("Kivi","Sakset"));
        Assert.assertEquals("pelaaja", t.getVoittaja("Sakset","Paperi"));
        Assert.assertEquals("pelaaja", t.getVoittaja("Paperi","Kivi"));
        Assert.assertEquals("kone", t.getVoittaja("Paperi","Sakset"));
        Assert.assertEquals("kone", t.getVoittaja("Kivi","Paperi"));
        Assert.assertEquals("kone", t.getVoittaja("Sakset","Kivi"));
        Assert.assertEquals("tasapeli", t.getVoittaja("Kivi","Kivi"));
        Assert.assertEquals("tasapeli", t.getVoittaja("Sakset","Sakset"));
        Assert.assertEquals("tasapeli", t.getVoittaja("Paperi","Paperi"));

    }

    @Test
    public void getKierrosTulos(){
        
        Assert.assertEquals("Paperi - Sakset     Sakset leikkaavat paperin! Hävisit.", t.getKierrosTulos("Paperi","Sakset"));
        Assert.assertEquals("Kivi - Paperi     Paperi peittää kiven! Hävisit.", t.getKierrosTulos("Kivi","Paperi"));
        Assert.assertEquals("Sakset - Kivi     Kivi murskaa sakset! Hävisit.", t.getKierrosTulos("Sakset","Kivi"));
        Assert.assertEquals("Paperi - Paperi     Sama siirto! Tasapeli.", t.getKierrosTulos("Paperi","Paperi"));  
        Assert.assertEquals("Sakset - Sakset     Sama siirto! Tasapeli.", t.getKierrosTulos("Sakset","Sakset")); 
        Assert.assertEquals("Kivi - Kivi     Sama siirto! Tasapeli.", t.getKierrosTulos("Kivi","Kivi"));
        Assert.assertEquals("Paperi - Kivi     Paperi peittää kiven! Voitit!", t.getKierrosTulos("Paperi","Kivi"));
        Assert.assertEquals("Sakset - Paperi     Sakset leikkaavat paperin! Voitit!", t.getKierrosTulos("Sakset","Paperi"));
        Assert.assertEquals("Kivi - Sakset     Kivi murskaa sakset! Voitit!", t.getKierrosTulos("Kivi","Sakset"));       
    }
}
