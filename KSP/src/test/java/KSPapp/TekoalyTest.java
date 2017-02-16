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
		lista.lisaaPeli("pelaaja", "Sakset","Paperi");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("kone", "Paperi","Sakset");
		lista.lisaaPeli("kone", "Sakset","Kivi");
		lista.lisaaPeli("kone", "Sakset","Kivi");
		lista.lisaaPeli("pelaaja", "Sakset","Paperi");
		String menestynein = aly.menestyksenPerusteella();
		Assert.assertEquals("Kivi",menestynein);
	}
	
	@Test
	public void vastustajanParas(){
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("kone", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		String paras = aly.vastustajanParas();
		Assert.assertEquals("Paperi",paras);
	}
	
	@Test
	public void kirjaaVoitot(){
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("tasapeli","kivi","Sakset");
		lista.lisaaPeli("kone", "Paperi","Sakset");
		lista.lisaaPeli("tasapeli","kivi","Sakset");

		
	}
	
	@Test
	public void tunnistaaKuvion(){
		
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja","Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja","Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		//Assert.assertEquals("Kivi",aly.toistuvatKuviot());
		
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja","Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		Assert.assertEquals("Paperi",aly.toistuvatKuviot());
		
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("pelaaja", "Paperi","Sakset");
		lista.lisaaPeli("pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("pelaaja", "Sakset","Sakset");
		//Assert.assertEquals("Sakset",aly.toistuvatKuviot());
	}	
}
