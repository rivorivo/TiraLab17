package Apulogiikka;
import Tietorakenteet.*;
public class Tulospalvelu{
  
	/*
	*Laskee ja palauttaa voittojen määrät tuloslistasta
	*/
	public int getVoitot(Tuloslista pelit){
		int voitot=0;
		int pituus = pelit.size();
		for(int i=0; i<pituus; i++){
			Linklist tulos = pelit.getTulos(i);
			Alkio voittaja=tulos.getAlkio(0);
			int v = voittaja.getArvo();
			if(v==0){
				voitot++;
			}
		}			
		return 	voitot;
	}

	public int getKonevoitot(Tuloslista pelit){
		int konevoitot=0;
		int pituus = pelit.size();
		for(int i=0; i<pituus; i++){
			Linklist tulos = pelit.getTulos(i);
			Alkio voittaja=tulos.getAlkio(0);
			int v = voittaja.getArvo();
			if(v==1){
				konevoitot++;
			}
		}
		return konevoitot;	
	}
	
	public int getTasapelit(Tuloslista pelit){
		int tasapelit=0;
		int pituus = pelit.size();		
		for(int i=0; i<pituus; i++){
			Linklist tulos = pelit.getTulos(i);
			Alkio voittaja=tulos.getAlkio(0);
			int v = voittaja.getArvo();
			if(v==2){
				tasapelit++;
			}
		}
		return tasapelit;	
	}

	/*
	*parametreinä @siirto ja @konesiirto, joiden ja kivi-sakset-paperin sääntöjen  
	*perusteella katsotaan, kumpi voitti ja tulostetaan ruudulle. Samalla palautetaan voittaja
	*
	*/

	public String getVoittaja(String siirto, String konesiirto){
		System.out.println("");
		System.out.println(siirto+" - "+konesiirto);
		System.out.println("");
		String voittaja = "tasapeli";	
			if(siirto.equals(konesiirto)){
				System.out.println("Sama siirto! Tasapeli.");		
			} else if(siirto.equals("Kivi")){
				if(konesiirto.equals("Sakset")){
					System.out.println("Kivi murskaa sakset! Voitit!");
					voittaja="pelaaja";
				}else if(konesiirto.equals("Paperi")){
					System.out.println("Paperi peittää kiven! Hävisit.");
					voittaja="kone";
				}
			} else if(siirto.equals("Sakset")){
				if(konesiirto.equals("Kivi")){
					System.out.println("Kivi murskaa sakset! Hävisit.");
					voittaja ="kone";
				}else if(konesiirto.equals("Paperi")){
					System.out.println("Sakset leikkaavat paperin! Voitit!");
					voittaja="pelaaja";
				}
			} else if(siirto.equals("Paperi")){
				if(konesiirto.equals("Kivi")){
					System.out.println("Paperi peittää kiven! Voitit!");
					voittaja="pelaaja";			
				}else if(konesiirto.equals("Sakset")){
					System.out.println("Sakset leikkaavat paperin! Hävisit.");
					voittaja ="kone";
				}
			}
		System.out.println("");
 		return voittaja; 	         
	}

	/*laskee ja tulosta koko pelin voittajan*/
	public String kokoPelinVoittaja(Tuloslista pelit){
		 
		if(getVoitot(pelit)<getKonevoitot(pelit)){
			return "Kone voitti pelin!";
		}else if(getVoitot(pelit)>getKonevoitot(pelit)){
			return "Sinä voitit pelin!";
		}
		return "Tasapeli!";

	}
	/*tulostaa @param pelit -listan perusteella voittajat*/
	public String ilmoitaTilanne(Tuloslista pelit){
		return "Voitot: Sinä: "+getVoitot(pelit)+" Kone: "+getKonevoitot(pelit)+" Tasapelit: "+getTasapelit(pelit);	
	}
	/*sisältää kaikki kahden siirron yhdistelmät*/
	public int[][] getAlkutilat(){
		int[][] alkutilat = {{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
		return alkutilat;
	}

}
