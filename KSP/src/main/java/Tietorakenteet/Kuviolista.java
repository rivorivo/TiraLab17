package Tietorakenteet;
import Apulogiikka.*;

public class Kuviolista{

	private int[][] tilastot;
	Muuntaja m = new Muuntaja();
	Tulospalvelu t =new Tulospalvelu();
	
	public Kuviolista(int koko){
		this.tilastot = new int[9][koko];
	}
	/*
	*Hakee tuloslistasta vastustajan kahden edellisen kierroksen siirrot
	*ja hakee niille kuviotA-listasta indeksin. Tallettaa indeksin ja
	*lisää viimeisen siirron mukaiseen sarakkeeseen +1.
	*/
	public void talletaKuvio(Tuloslista lista){
            
		int mones = lista.size();
		String[] teka = lista.getTulos(mones-2);
		String[] ttoka = lista.getTulos(mones-1);
		String[] tkolmas = lista.getTulos(mones);
       		if (mones>2){
			int i = 0;
			int eka =m.muutaNumeroiksi(teka[1]);
			int toka=m.muutaNumeroiksi(ttoka[1]);
			int kolmas=m.muutaNumeroiksi(tkolmas[1]);
			int[][] alkutilat = t.getAlkutilat();
			for(int[] rivi : alkutilat){

				if (rivi[0]==eka&&rivi[1]==toka){
					int vanha = tilastot[i][kolmas];
					tilastot[i][kolmas] = vanha+1;
				}
				i++;
			}
		}
			
	}
	public int[][] getTilastot(){
		return tilastot;
	}
}
