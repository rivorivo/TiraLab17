package Tietorakenteet;
import junit.framework.Assert;
import org.junit.Test;

public class TuloslistaTest{
	Tuloslista lista = new Tuloslista(99);
	
	@Test
	public void tallentaaJaMuistaaTuloksen(){
		
		lista.lisaaPeli("Pelaaja", "Sakset","Sakset");
		String[] tulos=lista.getTulos(0);
		String voittaja =  tulos[0];
		String siirto = tulos[1];
		Assert.assertEquals("Pelaaja",voittaja);
		Assert.assertEquals("Sakset",siirto);
	}
	
	@Test
	public void laskeePelit(){
		lista.lisaaPeli("Pelaaja", "Sakset","Sakset");
		lista.lisaaPeli("Kone", "Sakset","Sakset");
		lista.lisaaPeli("Pelaaja", "Kivi","Sakset");
		lista.lisaaPeli("Kone", "Paperi","Sakset");
		lista.lisaaPeli("Pelaaja", "Sakset","Sakset");
		int peleja = lista.size();
		Assert.assertEquals(5,peleja);
	}
	
	
	
}
