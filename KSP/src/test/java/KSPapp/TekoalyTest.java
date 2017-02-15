package KSPapp;
import Tietorakenteet.*;
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
	//	Assert.assertEquals("Kivi",aly.toistuvatKuviot());
		
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
	//	Assert.assertEquals("Sakset",aly.toistuvatKuviot());
		
	}
	@Test
	public void pelaaVastaan(){

	}
	@Test
	public void muuttuuSanaksiOikein(){

	}
	
	
}
