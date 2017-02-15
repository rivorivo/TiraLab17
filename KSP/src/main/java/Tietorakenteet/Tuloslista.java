package Tietorakenteet;
public class Tuloslista{

	private String[] siirrot;
	private String[] voittajat;
	private int mones=0;
        private int max;

	public Tuloslista(int koko){
  		this.siirrot = new String[koko];
	 	this.voittajat = new String[koko];
                this.max=koko;
	}
	/*
	*Lisää pelin voittajan @param String voittaja
	*ja ihmispelaajan tekemän siirron @param String siirto
	*listaan.
	*/
	public void lisaaPeli(String voittaja,String siirto){
		voittajat[mones]=voittaja;
		siirrot[mones]=siirto;
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
        public int getMax(){
                return max;
        }

}
