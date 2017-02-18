package Tietorakenteet;
import Apulogiikka.*;
public class Tuloslista{

	private String[] siirrot;
	private String[] voittajat;
	private String[] konesiirrot;
	private int pituus=0;
        private int max;
    

	public Tuloslista(int max){
  		this.siirrot = new String[max];
		this.konesiirrot = new String[max];
	 	this.voittajat = new String[max];
                this.max=max;
	}
	/*
	*Lisää listaan pelin voittajan @param String voittaja
	*ja ihmispelaajan tekemän siirron @param String siirto ja koneen siirron 
	*@param String konesiirto  
	*/
	public void lisaaPeli(String voittaja,String siirto, String konesiirto){
		voittajat[pituus]=voittaja;
		siirrot[pituus]=siirto;
		konesiirrot[pituus]=konesiirto;
		pituus++;
	}
	/*
	*Kertoo listana pelin tietyn kierroksen tuloksen indeksin @param int i -perusteella
	*/
	public String[] getTulos(int i){
		String voittaja = voittajat[i];
		String pelaajanSiirto = siirrot[i];
		String konesiirto = konesiirrot[i];
		String[] tulos = {voittaja,pelaajanSiirto,konesiirto};
		return tulos;
	}

	public int size(){
		return pituus;
	}
    public int getMax(){
            return max;
    }

}
