package Apulogiikka;

import Tietorakenteet.*;
import org.junit.Assert;
import org.junit.Test;

public class MuuntajaTest{

	private Muuntaja m = new Muuntaja();

	@Test
	public void muuttuuSanaksi(){
		Assert.assertEquals("Kivi",m.muutaSanaksi(0));
		Assert.assertEquals("Sakset",m.muutaSanaksi(1));
		Assert.assertEquals("Paperi",m.muutaSanaksi(2));
	}

	@Test
	public void muuttuuNumeroksi(){		
		Assert.assertEquals(0,m.muutaNumeroiksi("Kivi"));
		Assert.assertEquals(1,m.muutaNumeroiksi("Sakset"));
		Assert.assertEquals(2,m.muutaNumeroiksi("Paperi"));
	}

	@Test
	public void antaaVastapelin(){
		Assert.assertEquals("Paperi",m.vastakkainen("Kivi"));
		Assert.assertEquals("Kivi",m.vastakkainen("Sakset"));
		Assert.assertEquals("Sakset",m.vastakkainen("Paperi"));
		
	}

}