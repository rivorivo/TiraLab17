package Tietorakenteet;
import junit.framework.Assert;
import org.junit.Test;

public class TuloslistaTest{
	Tuloslista lista = new Tuloslista(99);
	
	@Test
	public void tallentaaJaMuistaaTuloksen(){
		lista.lisaaPeli("Pelaaja", "Sakset");
		String voittaja = lista.getVoittaja(0);
		String siirto = lista.getSiirto(0);
		Assert.assertEquals("Pelaaja",voittaja);
		Assert.assertEquals("Sakset",siirto);
	}
	
	@Test
	public void laskeePelit(){
		lista.lisaaPeli("Pelaaja", "Sakset");
		lista.lisaaPeli("Kone", "Sakset");
		lista.lisaaPeli("Pelaaja", "Kivi");
		lista.lisaaPeli("Kone", "Paperi");
		lista.lisaaPeli("Pelaaja", "Sakset");
		int peleja = lista.size();
		Assert.assertEquals(5,peleja);
	}
	
	
	@Test
	public void tallettaaKuvion(){
		lista.lisaaPeli("Pelaaja", "Sakset");
		lista.lisaaPeli("Kone", "Sakset");
		lista.lisaaPeli("Pelaaja", "Kivi");

	}
	
	
}
