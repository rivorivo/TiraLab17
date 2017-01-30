import static org.junit.Assert.*;
import org.junit.Test;


public class TekoalyTest {
	Tuloslista lista = new Tuloslista(99);
	Tekoaly aly = new Tekoaly(lista);
	
	@Test
	public void avaussiirtoPaperi() {
		String siirto=aly.getSiirto();
		assertEquals("Paperi",siirto);
	}
	
	@Test
	public void siirtaaMenestyksenPerusteella() {
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("kone", "Paperi");
		lista.lisaaPeli("pelaaja", "Sakset");
		String menestynein = aly.menestyksenPerusteella();
		assertEquals("Paperi",menestynein);
	}
	
	@Test
	public void vastustajanParas(){
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Kivi");
		lista.lisaaPeli("pelaaja", "Paperi");
		lista.lisaaPeli("pelaaja", "Sakset");
		lista.lisaaPeli("pelaaja", "Paperi");
		String paras = aly.vastustajanParas();
		assertEquals("Sakset",paras);
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
		assertEquals(4,aly.getVoitot());
		assertEquals(1,aly.getKonevoitot());
		assertEquals(2, aly.getTasapelit());
		
	}
}
