package KSPapp;
import Tietorakenteet.*;
import Apulogiikka.*;
public class Tekoaly{

	/*
	*Alustetaan tarpeellisia muuttujia
	*/
	private String konesiirto="Paperi";	
	private final Tuloslista pelit;

	private String taktiikka = "vastustajan paras";
	private final Kuviolista kuviolista;
    private final Muuntaja m = new Muuntaja();
    private final Tulospalvelu tulospalvelu = new Tulospalvelu();
	
	/*
	*Konstruktori
	*/
	public Tekoaly(Tuloslista pelit){
		this.pelit=pelit;
        this.kuviolista = new Kuviolista(99);
	}

	/*
	*Metodi, joka antaa siirron riippuen taktiikasta 
	* ja vaihtaa taktiikkaa, jos siltä tuntuu
	*/
	public String getSiirto(){
		if (pelit.size()>2){
                	kuviolista.talletaKuvio(pelit);
		}
		if (pelit.size() > 9999){
			
			konesiirto = toistuvatKuviot();
			
		}else if(taktiikka.equals("menestynein")){
			konesiirto = menestyksenPerusteella();
			if(pelit.size() > 4){
				vaihdaTaktiikka("vastustajan paras");
		
			}
		}else if(taktiikka.equals("vastustajan paras")){
		long aikaAlussa = System.currentTimeMillis(); 
			konesiirto = vastustajanParas();
	long aikaLopussa = System.currentTimeMillis(); 
	System.out.println("Operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");

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

			Linklist tulos = pelit.getTulos(i);
			
			int ksiirto=tulos.getVika().getArvo();
			int voitto=tulos.getAlkio(3).getArvo();


			if(voitto==1){
				if(ksiirto==2){
					paperit++;
				}else if(ksiirto==0){
					kivet++;
				}else if(ksiirto==1){
					sakset++;
				}
			}else if(voitto==0){
				if(ksiirto==1){
					sakset--;
				}else if(ksiirto==2){
					paperit--;
				}else if(ksiirto==0){
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

			Linklist tulos = pelit.getTulos(i);
			int siirto=tulos.getVika().getEdellinen().getArvo();
			int voitto=tulos.getVika().getEdellinen().getEdellinen().getArvo();
			if(voitto==0){
				if(siirto==0){
					kivet++;
				}else if(siirto==1){
					sakset++;
				}else if(siirto==2){
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
		int[][] alkutilat = tulospalvelu.getAlkutilat();
		int[][] tilastot = kuviolista.getTilastot();
		Linklist e = pelit.getTulos(2);
		Linklist t = pelit.getTulos(1);
		int eka=e.getAlkio(2).getArvo();
		int toka=t.getAlkio(1).getArvo();
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
