package Tietorakenteet;
public class Tuloslista{

	private Linklist siirtolista;
	private Linklist voittolista;
	private Linklist konesiirtolista;

	public Tuloslista(){
		siirtolista=new Linklist();
		voittolista=new Linklist();
		konesiirtolista=new Linklist();
	}
	public void lisaaPeli(int voittaja,int siirto,int konesiirto){
			
			voittolista.uusiAlkio(voittaja);
			siirtolista.uusiAlkio(siirto);
			konesiirtolista.uusiAlkio(konesiirto);
	}

	public Linklist getTulos(int j){
		Linklist tulos = new Linklist();
		tulos.uusiAlkio(voittolista.getAlkio(j).getArvo());
		tulos.uusiAlkio(siirtolista.getAlkio(j).getArvo());
		tulos.uusiAlkio(konesiirtolista.getAlkio(j).getArvo());
		return tulos;
	}

	public int size(){
		return voittolista.pituus();
	}

}
