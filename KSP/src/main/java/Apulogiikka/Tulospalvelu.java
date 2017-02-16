package Apulogiikka;
import Tietorakenteet.*;
public class Tulospalvelu{
  
	/*
	*Laskee ja palauttaa voittojen määrät tuloslistasta
	*/
	public int getVoitot(Tuloslista pelit){
		int voitot=0;
		for(int i=0; i<pelit.size(); i++){
			String[] tulos = pelit.getTulos(i);
			String v = tulos[0];
			if(v.equals("pelaaja")){
				voitot++;
			}
		}			
		return 	voitot;
	}

	public int getKonevoitot(Tuloslista pelit){
		int konevoitot=0;
		for(int i=0; i<pelit.size(); i++){
			String[] tulos = pelit.getTulos(i);
			String v = tulos[0];
			if(v.equals("kone")){
				konevoitot++;
			}
		}
		return konevoitot;	
	}
	
	public int getTasapelit(Tuloslista pelit){
		int tasapelit=0;
		for(int i=0; i<pelit.size(); i++){
			String[] tulos = pelit.getTulos(i);
			String v = tulos[0];
			if(v.equals("tasapeli")){
				tasapelit++;
			}
		}
		return tasapelit;	
	}
	public void ilmoitaTulos(){
			
	}

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

	public String kokoPelinVoittaja(Tuloslista pelit){
		 
		if(getVoitot(pelit)<getKonevoitot(pelit)){
			return "Kone voitti pelin!";
		}else if(getVoitot(pelit)>getKonevoitot(pelit)){
			return "Sinä voitit pelin!";
		}
		return "Tasapeli!";

	}
	public String ilmoitaTilanne(Tuloslista pelit){
		return "Voitot: Sinä: "+getVoitot(pelit)+" Kone: "+getKonevoitot(pelit)+" Tasapelit: "+getTasapelit(pelit);	
	}

}
