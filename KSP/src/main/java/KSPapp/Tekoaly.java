package KSPapp;
public class Tekoaly{

	/*
	*Alustetaan tarpeellisia muuttujia
	*/
	private String konesiirto="Paperi";	
	private Tuloslista pelit;
	private String taktiikka = "menestynein";
	
	/*
	*Konstruktori
	*/
	public Tekoaly(Tuloslista pelit){
		this.pelit=pelit;
	}

	/*
	*Metodi, joka antaa siirron riippuen taktiikasta 
	* ja vaihtaa taktiikkaa, jos siltä tuntuu
	*/
	public String getSiirto(){
		
		if (pelit.size() > 2){
			konesiirto = toistuvatKuviot();
		}else if(taktiikka.equals("menestynein")){
			konesiirto = menestyksenPerusteella();
		}else if(taktiikka.equals("vastustajan paras")){
			konesiirto = vastustajanParas();
		}else if(taktiikka.equals("toistuvatKuviot")){
			konesiirto = toistuvatKuviot();
		}
		
		return konesiirto;	
	}
	
		/*
	*Metodi, joka valitsee siirroksi tähän asti parhaiten menestyneen siirron
	*/
	public String menestyksenPerusteella(){
		int kivet=0;
		int sakset=0;
		int paperit=0;
		String isoin = "Paperi";
		for(int i=0; i<pelit.size(); i++){
			if(pelit.getVoittaja(i).equals("kone")){
				if(pelit.getSiirto(i).equals("Kivi")){
					kivet++;
				}else if(pelit.getSiirto(i).equals("Sakset")){
					sakset++;
				}else if(pelit.getSiirto(i).equals("Paperi")){
					paperit++;
				}
			}
		}
		if(kivet>paperit){
			isoin = "Kivi";
			paperit=kivet;
		}if(sakset>paperit){
			isoin = "Sakset";
		}
		return isoin;
	}
	/*
	*Taktiikkaa, joka pelaa vastustajan menestyneimmällä
	*/
	public String vastustajanParas(){
		int kivet=0;
		int sakset=0;
		int paperit=0;
		String isoin = "Paperi";
		for(int i=0; i<pelit.size(); i++){
			if(pelit.getVoittaja(i).equals("pelaaja")){
				if(pelit.getSiirto(i).equals("Kivi")){
					kivet++;
				}else if(pelit.getSiirto(i).equals("Sakset")){
					sakset++;
				}else if(pelit.getSiirto(i).equals("Paperi")){
					paperit++;
				}
			}
		}
		if(kivet>paperit){
			isoin = "Kivi";
			paperit=kivet;
		}if(sakset>paperit){
			isoin = "Sakset";
		}
		return isoin;
	}

	public String toistuvatKuviot(){
		int[][] kuviotA = pelit.getKuvioA();
		int[][] kuviotB = pelit.getKuvioB();
			System.out.println("mones: "+pelit.size());
		String e=pelit.getSiirto(pelit.size()-2);
		String t=pelit.getSiirto(pelit.size()-1);
		int eka=pelit.muutaNumeroiksi(e);
		int toka=pelit.muutaNumeroiksi(t);
			System.out.print("eka:"+eka+" toka:"+toka);
			int alku = 0;
			int i=0;
		for (int[] rivi: kuviotA) {
			if (rivi[0]==eka&&rivi[1]==toka){
					alku = i;
					break;
				}
			i++;
		}

		System.out.println("alku: "+alku);
		int paras= 0;

		for (int j = 0; j<3; j++) {
			if(kuviotB[alku][j]>paras){
				System.out.println(kuviotB[alku][j]);
				paras=j;
			}
		}
		System.out.println(paras);
		System.out.println(muutaSanaksi(paras));
		System.out.println(pelaaVastaan(muutaSanaksi(paras)));


		return pelaaVastaan(muutaSanaksi(paras));

	}

		/*
	*päivittää pelin (ei mahdollisesti enää tarvita)
	*/
	public void paivita(Tuloslista lista){
		pelit=lista;
	}

	public String muutaSanaksi(int num){
		String sana ="Kivi";
		if (num==1){
			sana="Sakset";
		}else if(num==2){;
			sana="Paperi";
		}
		return sana;
	}

	public String pelaaVastaan(String siirto){

		if(siirto.equals("Paperi")){
			siirto = "Sakset";
		}else if(siirto.equals("Sakset")){
			siirto = "Kivi";
		}else if(siirto.equals("Kivi")){
			siirto = "Paperi";
		}
		return siirto;
	}
		/*
	}
	*Laskee voittojen määrän tuloslistasta
	*/
	public int getVoitot(){
		int voitot=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("pelaaja")){
				voitot++;
			}
		}			
		return 	voitot;
	}

	public int getKonevoitot(){
		int konevoitot=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("kone")){
				konevoitot++;
			}
		}
		return konevoitot;	
	}
	
	public int getTasapelit(){
		int tasapelit=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("tasapeli")){
				tasapelit++;
			}
		}
		return tasapelit;	
	}

}
