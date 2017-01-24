import java.util.Scanner;
/*käyttöliittymä, joka kysyy siirron ja ilmoittaa lopputuloksen
*/
public class KSPmain{
	
	public static void main(String []args){
		Scanner konsoli = new Scanner(System.in);
			String siirto="";	
		Tekoaly kone = new Tekoaly();		

		while(true){
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
				System.out.println("Valitse 'K','S' tai 'P'");			
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
			//System.out.println("Siirtosi -"+"  Koneen siirto");
			System.out.println(siirto+" - "+konesiirto);
			System.out.println("");				
			if(siirto.equals(konesiirto)){
			kone.lisaaTulos("tasan",siirto,konesiirto);
			System.out.println("Sama siirto! Tasapeli.");		
			} else if(siirto.equals("Kivi")){
				if(konesiirto.equals("Sakset")){
					kone.lisaaTulos("pelaaja",siirto,konesiirto);
					System.out.println("Kivi murskaa sakset! Voitit!");
				}else if(konesiirto.equals("Paperi")){
					kone.lisaaTulos("kone",siirto,konesiirto);
					System.out.println("Paperi peittää kiven! Hävisit.");
				}
			} else if(siirto.equals("Sakset")){
				if(konesiirto.equals("Kivi")){
					kone.lisaaTulos("kone",siirto,konesiirto);
					System.out.println("Kivi murskaa sakset! Hävisit.");
				}else if(konesiirto.equals("Paperi")){
					kone.lisaaTulos("pelaaja",siirto,konesiirto);
					System.out.println("Sakset leikkaavat paperin! Voitit!");
				}
			} else if(siirto.equals("Paperi")){
				if(konesiirto.equals("Kivi")){
					kone.lisaaTulos("pelaaja",siirto,konesiirto);
					System.out.println("Paperi peittää kiven! Voitit!");			
				}else if(konesiirto.equals("Sakset")){
					kone.lisaaTulos("kone",siirto,konesiirto);
					System.out.println("Sakset leikkaavat paperin! Hävisit.");
				}
			}
			System.out.println("");
			System.out.println("Voitot: Sinä: "+kone.getVoitot()+" Kone: "+kone.getKonevoitot()+" Tasapelit: "+kone.getTasapelit());
		}
	}
}
