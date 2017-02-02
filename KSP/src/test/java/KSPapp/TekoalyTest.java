package KSPapp;
import junit.framework.Assert;
import org.junit.Test;


public class TekoalyTest{
	Tuloslista lista = new Tuloslista(99);
	Tekoaly aly = new Tekoaly(lista);
	
	@Test
	public void avaussiirtoPaperi() {
		String siirto=aly.getSiirto();
		Assert.assertEquals("Paperi",siirto);
	}
	
	@Test
	public void siirtaaMenestyksenPerusteella() {
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("kone", "Paperi");
		lista.lisaaPeli("pelaaja", "Sakset");
		String menestynein = aly.menestyksenPerusteella();
		Assert.assertEquals("Paperi",menestynein);
	}
	
	@Test
	public void vastustajanParas(){
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("kone", "Sakset");
		lista.lisaaPeli("pelaaja", "Paperi");
		String paras = aly.vastustajanParas();
		Assert.assertEquals("Paperi",paras);
	}
	
	@Test
	public void kirjaaVoitot(){
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("tasapeli","kivi");
		lista.lisaaPeli("kone", "Paperi");
		lista.lisaaPeli("tasapeli","kivi");
		Assert.assertEquals(4,aly.getVoitot());
		Assert.assertEquals(1,aly.getKonevoitot());
		Assert.assertEquals(2, aly.getTasapelit());
		
	}
}
