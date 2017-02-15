package KSPapp;
import Apulogiikka.*;
import Tietorakenteet.*;
public class Tulospalvelu{

	private int[][] kuviotA = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
	private int[][] kuviotB;
        Muuntaja m = new Muuntaja();
        
        public Tulospalvelu(int koko){
        this.kuviotB = new int[9][koko];
        }	
        /*
	*Hakee tuloslistasta vastustajan kahden edellisen kierroksen siirrot
	*ja hakee niille kuviotA-listasta indeksin. Tallettaa indeksin ja
	*lisää viimeisen siirron mukaiseen sarakkeeseen +1.
	*/
	public void talletaKuvio(Tuloslista lista){
            
		int mones = lista.size();
       		if (mones>2){
			int i = 0;
			int eka =m.muutaNumeroiksi(lista.getSiirto(mones-3));
			int toka=m.muutaNumeroiksi(lista.getSiirto(mones-2));
			int kolmas=m.muutaNumeroiksi(lista.getSiirto(mones-1));

			for(int[] rivi : kuviotA){

				if (rivi[0]==eka&&rivi[1]==toka){
					int vanha = kuviotB[i][kolmas];
					kuviotB[i][kolmas] = vanha+1;
				}
				i++;
			}
		}
			
	}

	public int[][] getKuvioA(){
		return kuviotA;
	}
	public int[][] getKuvioB(){
		return kuviotB;
	}
	/*
	*Laskee ja palauttaa voittojen määrät tuloslistasta
	*/
	public int getVoitot(Tuloslista pelit){
		int voitot=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("pelaaja")){
				voitot++;
			}
		}			
		return 	voitot;
	}

	public int getKonevoitot(Tuloslista pelit){
		int konevoitot=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("kone")){
				konevoitot++;
			}
		}
		return konevoitot;	
	}
	
	public int getTasapelit(Tuloslista pelit){
		int tasapelit=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("tasapeli")){
				tasapelit++;
			}
		}
		return tasapelit;	
	}

	public String kokoPelinVoittaja(Tuloslista pelit){
		 
		if(getVoitot(pelit)<getKonevoitot(pelit)){
			return "Kone voitti pelin!";
		}else if(getVoitot(pelit)>getKonevoitot(pelit)){
			return "Sinä voitit pelin!";
		}
		return "Tasapeli!";

	}
	public String ilmoitaTulos(Tuloslista pelit){
		return "Voitot: Sinä: "+getVoitot(pelit)+" Kone: "+getKonevoitot(pelit)+" Tasapelit: "+getTasapelit(pelit);	
	}

}
