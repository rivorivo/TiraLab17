public class Tekoaly{

	/*
	*Alustetaan tarpeellisia muuttujia
	*/

	private String siirto;
	private String konesiirto="Paperi";	
	private int voitot=0;
	private int konevoitot=0;
	private int tasapelit=0;
	private int kivia=0;
	private int papereita=0;
	private int saksia=0;

	
	public String getSiirto(){	
		return konesiirto;	
	}

	
	public void lisaaTulos(String voittaja,String siirto,String konesiirto){
		
		if(siirto.equals("Kivi")){
			kivia++;
		}else if(siirto.equals("Sakset")){
			saksia++;
		}else if(siirto.equals("Paperi")){
			papereita++;
		}

		if(voittaja.equals("pelaaja")){
			voitot++;		
		}else if(voittaja.equals("kone")){
			konevoitot++;
		}else if(voittaja.equals("tasan")){
			tasapelit++;		
		}	
	}
	

	public int getVoitot(){
		return 	voitot;
	}

	public int getKonevoitot(){
		return konevoitot;	
	}
	public int getTasapelit(){
		return tasapelit;	
	}

}
