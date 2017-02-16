package KSPapp;
import Tietorakenteet.*;
import Apulogiikka.*;
public class Tekoaly{

	/*
	*Alustetaan tarpeellisia muuttujia
	*/
	private String konesiirto="Paperi";	
	private final Tuloslista pelit;
	private String taktiikka = "menestynein";
	private final Kuviolista kuviolista;
        private final Muuntaja m = new Muuntaja();
	
	/*
	*Konstruktori
	*/
	public Tekoaly(Tuloslista pelit){
		this.pelit=pelit;
        this.kuviolista = new Kuviolista(pelit.getMax());
	}

	/*
	*Metodi, joka antaa siirron riippuen taktiikasta 
	* ja vaihtaa taktiikkaa, jos siltä tuntuu
	*/
	public String getSiirto(){
		if (pelit.size()>2){
                	kuviolista.talletaKuvio(pelit);
		}
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
			String[] tulos = pelit.getTulos(i);
			
			if(tulos[0].equals("kone")){
				if(tulos[2].equals("Paperi")){
					paperit++;
				}else if(tulos[2].equals("Kivi")){
					kivet++;
				}else if(tulos[2].equals("Sakset")){
					sakset++;
				}
			}else if(tulos[0].equals("pelaaja")){
				if(tulos[2].equals("Sakset")){
					sakset--;
				}else if(tulos[2].equals("Paperi")){
					paperit--;
				}else if(tulos[2].equals("Kivi")){
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
			String[] tulos = pelit.getTulos(i);
			if(tulos[0].equals("pelaaja")){
				if(tulos[1].equals("Kivi")){
					kivet++;
				}else if(tulos[1].equals("Sakset")){
					sakset++;
				}else if(tulos[1].equals("Paperi")){
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
		int[][] alkutilat = kuviolista.getAlkutilat();
		int[][] tilastot = kuviolista.getTilastot();
		String[] e=pelit.getTulos(pelit.size()-2);
		String[] t=pelit.getTulos(pelit.size()-1);
		String ek=e[1];
		String to=t[1];
		int eka=m.muutaNumeroiksi(ek);
		int toka=m.muutaNumeroiksi(to);
		int alku = 0;
		int i=0;

		for (int[] rivi: alkutilat) {
			if (rivi[0]==eka&&rivi[1]==toka){
					alku = i;
					break;
				}
			i++;
		}
		int todnak= 0;
		int isoin= 0;

		for (int j = 0; j<3; j++) {
			int maara =tilastot[alku][j];
			if(maara>isoin){
				isoin=maara;
				todnak=j;
			}
		}
		return m.vastakkainen(m.muutaSanaksi(todnak));

	}

	
	/*
	 * palauttaa käytössä olevan taktiikan
	 */
	 public String getTaktiikka(){
		return taktiikka;
	 }
	 
	
}
