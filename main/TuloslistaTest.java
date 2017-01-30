import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TuloslistaTest {
	Tuloslista lista = new Tuloslista(99);
	
	@Test
	public void tallentaaJaMuistaaTuloksen(){
		lista.lisaaPeli("Pelaaja", "Sakset");
		String voittaja = lista.getVoittaja(0);
		String siirto = lista.getSiirto(0);
		assertEquals("Pelaaja",voittaja);
		assertEquals("Sakset",siirto);
	}
	
	@Test
	public void laskeePelit(){
		lista.lisaaPeli("Pelaaja", "Sakset");
		lista.lisaaPeli("Kone", "Sakset");
		lista.lisaaPeli("Pelaaja", "Kivi");
		lista.lisaaPeli("Kone", "Paperi");
		lista.lisaaPeli("Pelaaja", "Sakset");
		int peleja = lista.size();
		assertEquals(5,peleja);
	}
}
