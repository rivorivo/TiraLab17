package KSPapp;
import java.util.Scanner;
import java.util.InputMismatchException;
/*käyttöliittymä, joka kysyy siirron ja ilmoittaa lopputuloksen
*/
public class KSPmain{
	
	public static void main(String []args){
		Scanner konsoli = new Scanner(System.in);
		String siirto="";
		int monta=0;
		
		System.out.println("Kuinka monta peliä?(ota monta)");
		while(true){	
			try{
				monta = konsoli.nextInt();
				break;
			}catch(InputMismatchException e){
				System.out.println("Anna numero kiitos!");
				konsoli.nextLine();
			}
		}
		Tuloslista tuloslista = new Tuloslista(monta);	
		Tekoaly kone = new Tekoaly(tuloslista);

		while(true){
			if(tuloslista.size()>=monta){
				System.out.println(kone.kokoPelinVoittaja());
				break;
			}

			/*
			*Ihmispelaajan siirron kysyminen
			*@param siirto	tallettaa pelaajan siirron		
			*/ 
			
			while(true){
				System.out.println("Pelaa uusi peli painamalla 'Enter'");
				if(konsoli.nextLine().equals("")){break;}
			}
			System.out.println("Anna siirtosi:");
			System.out.println("K=kivi");
			System.out.println("S=sakset");
			System.out.println("P=paperi");
			while(true){
				siirto = konsoli.nextLine();
				if(siirto.equalsIgnoreCase("K")){siirto="Kivi";break;}
				if(siirto.equalsIgnoreCase("S")){siirto="Sakset";break;}
				if(siirto.equalsIgnoreCase("P")){siirto="Paperi";break;}
				System.out.println("Valitse 'k','s' tai 'p'");			
			}
			/*
			*Tähän väliin tekoälyltä siirron kysyminen
			*@param konesiirto tallettaa konepelaajan siirron	
			*/ 
			String konesiirto = kone.getSiirto();		

		
			/* 
			*lopputuloksen laskeminen ja ilmoitus ihmispelaajalle
			*ja konepelaajalle
			*/
			System.out.println("");
			System.out.println(siirto+" - "+konesiirto);
			System.out.println("");				
			if(siirto.equals(konesiirto)){
			tuloslista.lisaaPeli("tasapeli",siirto);
			System.out.println("Sama siirto! Tasapeli.");		
			} else if(siirto.equals("Kivi")){
				if(konesiirto.equals("Sakset")){
					tuloslista.lisaaPeli("pelaaja",siirto);
					System.out.println("Kivi murskaa sakset! Voitit!");
				}else if(konesiirto.equals("Paperi")){
					tuloslista.lisaaPeli("kone",siirto);
					System.out.println("Paperi peittää kiven! Hävisit.");
				}
			} else if(siirto.equals("Sakset")){
				if(konesiirto.equals("Kivi")){
					tuloslista.lisaaPeli("kone",siirto);
					System.out.println("Kivi murskaa sakset! Hävisit.");
				}else if(konesiirto.equals("Paperi")){
					tuloslista.lisaaPeli("pelaaja",siirto);
					System.out.println("Sakset leikkaavat paperin! Voitit!");
				}
			} else if(siirto.equals("Paperi")){
				if(konesiirto.equals("Kivi")){
					tuloslista.lisaaPeli("pelaaja",siirto);
					System.out.println("Paperi peittää kiven! Voitit!");			
				}else if(konesiirto.equals("Sakset")){
					tuloslista.lisaaPeli("kone",siirto);
					System.out.println("Sakset leikkaavat paperin! Hävisit.");
				}
			}
			System.out.println("");
			System.out.println("Voitot: Sinä: "+kone.getVoitot()+" Kone: "+kone.getKonevoitot()+" Tasapelit: "+kone.getTasapelit());
		}
	}
}
