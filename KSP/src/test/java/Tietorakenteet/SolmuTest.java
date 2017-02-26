package Tietorakenteet;

import org.junit.Test;
import org.junit.Assert;
public class SolmuTest{

private Solmu s = new Solmu(1,null,null,null,null);


@Test
public void getArvoToimii(){
	Assert.assertEquals(1,s.getArvo());
}

@Test
public void lisaaLapsetToimii(){
	Assert.assertEquals(null,s.getLapsi1());
	Assert.assertEquals(null,s.getLapsi3());
	s.lisaaLapset();
	Assert.assertNotEquals(null,s.getLapsi1());
	Assert.assertNotEquals(null,s.getLapsi3());	
}

@Test
public void setJaGetVanhempiToimii(){
	Solmu n = new Solmu(1,null,null,null,null);
	Assert.assertEquals(null,n.getVanhempi());
	n.setVanhempi(s);
	Assert.assertEquals(s,n.getVanhempi());
}

@Test
public void getTiettyLapsiToimii(){
	Solmu n = new Solmu(1,null,null,null,null);
	Solmu m = new Solmu(1,s,n,null,null);

	Assert.assertEquals(null,m.getLapsi(2));
	Assert.assertEquals(n,m.getLapsi(1));
	Assert.assertEquals(s,m.getLapsi(0));
}

@Test
public void setLapsiToimii(){
	Solmu n = new Solmu(1,null,null,null,null);
	Solmu m = new Solmu(1,null,null,null,null);
	Solmu p = new Solmu(1,null,null,null,null);
	s.setLapsi1(n);
	s.setLapsi2(m);
	s.setLapsi3(p);

	Assert.assertEquals(n,s.getLapsi1());
	Assert.assertEquals(m,s.getLapsi2());
	Assert.assertEquals(p,s.getLapsi3());
}

}