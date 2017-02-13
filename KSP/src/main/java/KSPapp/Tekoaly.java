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
		
		if (pelit.size() > 9){
			konesiirto = toistuvatKuviot();
		}else if(taktiikka.equals("menestynein")){
			konesiirto = menestyksenPerusteella();
			if(pelit.size() > 4){
				vaihdaTaktiikka("vastustajan paras");
			}
		}else if(taktiikka.equals("vastustajan paras")){
			konesiirto = vastustajanParas();
		}else if(taktiikka.equals("toistuvat kuviot")){
			konesiirto = toistuvatKuviot();
		}
		
		return konesiirto;	
	}
	
	public void vaihdaTaktiikka(String uusi){
		taktiikka=uusi;
	}
	
	/*
	*Metodi, joka valitsee siirroksi tähän asti koneen parhaiten 
	* menestyneen siirron, ottaen huomioon voitot ja häviöt
	*/
	public String menestyksenPerusteella(){
		int kivet=0;
		int sakset=0;
		int paperit=0;
		String isoin = "Paperi";
		for(int i=0; i<pelit.size(); i++){
			if(pelit.getVoittaja(i).equals("kone")){
				if(pelit.getSiirto(i).equals("Kivi")){
					paperit++;
				}else if(pelit.getSiirto(i).equals("Sakset")){
					kivet++;
				}else if(pelit.getSiirto(i).equals("Paperi")){
					sakset++;
				}
			}else if(pelit.getVoittaja(i).equals("pelaaja")){
				if(pelit.getSiirto(i).equals("Kivi")){
					sakset--;
				}else if(pelit.getSiirto(i).equals("Sakset")){
					paperit--;
				}else if(pelit.getSiirto(i).equals("Paperi")){
					kivet--;
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

	/*
	*Käy läpi vastustajan edellisiä siirtoja ja etsii niistä kolmen
	*siirron pituisia toistuvia kuvioita.
	*Algoritmin on tarkoitus jäljitellä perinteistä tekoälyn palauteoppimisen tapaista
	*päätöksentekomallia
	*int alku voidaan ajatella tilana, jonka voimassa ollessa kolmella eri 		
	*valintavaihtoehdolla
	*on eri todennäköisyydet johtaa positiiviseen palkintoon. Todenäköisyys vain lasketaan 
	*prosenttien
	*sijaan kokonaislukujen summana ja palkinto on binäärinen häviö/voitto. Todennäköisenä 
	*vastustajan
	*siirtona pidetään aikaisemmin saman tilan voimassa olessa useiten käytettyä siirtoa ja 
	*toiminnoksi valikoituu sen voittava siirto.
	*/
	public String toistuvatKuviot(){
		int[][] kuviotA = pelit.getKuvioA();
		int[][] kuviotB = pelit.getKuvioB();
		String e=pelit.getSiirto(pelit.size()-2);
		String t=pelit.getSiirto(pelit.size()-1);
		int eka=pelit.muutaNumeroiksi(e);
		int toka=pelit.muutaNumeroiksi(t);
			int alku = 0;
			int i=0;
		for (int[] rivi: kuviotA) {
			if (rivi[0]==eka&&rivi[1]==toka){
					alku = i;
					break;
				}
			i++;
		}
		int paras= 0;
		int isoin= 0;

		for (int j = 0; j<3; j++) {
			int maara =kuviotB[alku][j];
			if(maara>isoin){
				isoin=maara;
				paras=j;
			}
		}
		return pelaaVastaan(muutaSanaksi(paras));

	}

	/*Muuttaa numero-koodauksen taas String-muotoon*/

	public String muutaSanaksi(int num){
		String sana ="Kivi";
		if (num==1){
			sana="Sakset";
		}else if(num==2){;
			sana="Paperi";
		}
		return sana;
	}
	/*
	*Palauttaa siirron, joka voittaa parametrina 
	*@param siirto 
	*annetun siirron.
	*/
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
	 * palauttaa käytössä olevan taktiikan
	 */
	 public String getTaktiikka(){
		return taktiikka;
	 }
	 
		/*
	}
	*Laskee ja palauttaa voittojen määrät tuloslistasta
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

	public String kokoPelinVoittaja(){
		 
		if(getVoitot()<getKonevoitot()){
			return "Kone voitti pelin!";
		}else if(getVoitot()>getKonevoitot()){
			return "Sinä voitit pelin!";
		}
		return "Tasapeli!";
	}

}
