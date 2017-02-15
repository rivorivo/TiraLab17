package Tietorakenteet;
import Apulogiikka.*;
public class Tuloslista{

	private String[] siirrot;
	private String[] voittajat;
	private int pituus=0;
        private int max;

	public Tuloslista(int max){
  		this.siirrot = new String[max];
	 	this.voittajat = new String[max];
                this.max=max;
	}
	/*
	*Lisää pelin voittajan @param String voittaja
	*ja ihmispelaajan tekemän siirron @param String siirto
	*listaan.
	*/
	public void lisaaPeli(String voittaja,String siirto){
		voittajat[pituus]=voittaja;
		siirrot[pituus]=siirto;
		pituus++;
	}
	public String getVoittaja(int luku){
		return voittajat[luku];
	}
	public String getSiirto(int luku){
		return siirrot[luku];
	}

	public int size(){
		return pituus;
	}
        public int getMax(){
                return max;
        }

}
