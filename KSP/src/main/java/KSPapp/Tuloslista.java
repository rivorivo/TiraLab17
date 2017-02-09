package KSPapp;
public class Tuloslista{

	private String[] siirrot;
	private String[] voittajat;
	private int mones=0;
	private int[][] kuviotA = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
	private int[][] kuviotB;

	public Tuloslista(int koko){
  		this.siirrot = new String[koko];
	 	this.voittajat = new String[koko];
		this.kuviotB = new int[9][koko];
	}
	/*
	*Lisää pelin voittajan @param String voittaja
	*ja ihmispelaajan tekemän siirron @param String siirto
	*listaan ja kutsuu samalla talletaKuvio()-metodia
	*/
	public void lisaaPeli(String voittaja,String siirto){
		voittajat[mones]=voittaja;
		siirrot[mones]=siirto;
		talletaKuvio();	
		mones++;
	}
	public String getVoittaja(int luku){
		return voittajat[luku];
	}
	public String getSiirto(int luku){
		return siirrot[luku];
	}
	public int size(){
		return mones;
	}

	public int muutaNumeroiksi(String siirto){
			int numero=0;
			if(siirto.equals("Sakset")){
				numero=1;
			}else if(siirto.equals("Paperi")){
				numero=2;
			}
			return numero;
	}

	/*
	*Hakee listasta vastustajan kahden edellisen kierroksen siirrot
	*ja hakee niille kuviotA-listasta indeksin. Tallettaa indeksin ja
	*lisää viimeisen siirron mukaiseen sarakkeeseen +1.
	*/
	public void talletaKuvio(){
		if (mones>1){
			int i = 0;
			int eka =muutaNumeroiksi(siirrot[mones-2]);
			int toka=muutaNumeroiksi(siirrot[mones-1]);
			int kolmas=muutaNumeroiksi(siirrot[mones]);

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
