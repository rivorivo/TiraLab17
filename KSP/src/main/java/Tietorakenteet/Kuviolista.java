package Tietorakenteet;
import Apulogiikka.*;
public class Kuviolista{

	private int[][] kuviotA = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
	private int[][] kuviotB;
        Muuntaja m = new Muuntaja();
        
        public Kuviolista(int koko){
        this.kuviotB = new int[9][koko];
        }	
        /*
	*Hakee listasta vastustajan kahden edellisen kierroksen siirrot
	*ja hakee niille kuviotA-listasta indeksin. Tallettaa indeksin ja
	*lisää viimeisen siirron mukaiseen sarakkeeseen +1.
	*/
	public void talletaKuvio(Tuloslista lista){
            int mones = lista.size();

            if (mones>2){
			int i = 0;
        System.out.println(lista.getSiirto(mones-1));
        System.out.println(lista.getSiirto(mones-2));
        System.out.println(lista.getSiirto(mones-3));
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
}