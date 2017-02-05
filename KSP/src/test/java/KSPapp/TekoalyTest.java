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
		lista.lisaaPeli("kone", "Kivi");
		lista.lisaaPeli("pelaaja", "Sakset");
		String menestynein = aly.menestyksenPerusteella();
		Assert.assertEquals("Kivi",menestynein);
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
	
	@Test
	public void tunnistaaKuvion(){
		
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja","Kivi");
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja","Kivi");
		lista.lisaaPeli("pelaaja", "Kivi");
		Assert.assertEquals("Kivi",aly.toistuvatKuviot());
		
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja","Paperi");
		lista.lisaaPeli("pelaaja", "Paperi");
		Assert.assertEquals("Paperi",aly.toistuvatKuviot());
		
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Sakset");
		Assert.assertEquals("Sakset",aly.toistuvatKuviot());
		
	}
	@Test
	public void pelaaVastaan(){
		Assert.assertEquals("Kivi",aly.pelaaVastaan("Sakset"));
		Assert.assertEquals("Sakset",aly.pelaaVastaan("Paperi"));
		Assert.assertEquals("Paperi",aly.pelaaVastaan("Kivi"));
	}
		@Test
	public void muuttuuSanaksiOikein(){
		Assert.assertEquals("Kivi",aly.muutaSanaksi(0));
		Assert.assertEquals("Sakset",aly.muutaSanaksi(1));
		Assert.assertEquals("Paperi",aly.muutaSanaksi(2));
	}
	
	
}
