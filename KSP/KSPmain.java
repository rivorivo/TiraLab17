import java.util.Scanner;

public class KSPmain{
	//käyttöliittymä, joka kysyy siirron ja ilmoittaa lopputuloksen
	public static void main(String []args){
		Scanner konsoli = new Scanner(System.in);
			String siirto="";	

		while(true){
			// Ihmispelaajan siirron kysyminen
			System.out.println("");
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
			//Tähän väliin tekoälyltä siirron kysyminen 
			String konesiirto = "Paperi";		

		
			// lopputuloksen laskenta ja ilmoitus
			System.out.println("");
			System.out.println("Siirtosi: "+siirto);
			System.out.println("Koneen siirto: "+konesiirto);				
			if(siirto.equals(konesiirto)){
			System.out.println("");
			System.out.println("Sama siirto! Tasapeli.");		
			} else if(siirto.equals("Kivi")){
				if(konesiirto.equals("Sakset")){
					System.out.println("");
					System.out.println("Kivi murskaa sakset! Voitit!");
				}else if(konesiirto.equals("Paperi")){
					System.out.println("");	
					System.out.println("Paperi peittää kiven! Hävisit.");
				}
			} else if(siirto.equals("Sakset")){
				if(konesiirto.equals("Kivi")){
					System.out.println("");
					System.out.println("Kivi murskaa sakset! Hävisit.");
				}else if(konesiirto.equals("Paperi")){
					System.out.println("Sakset leikkaavat paperin! Voitit!");
				}
			} else if(siirto.equals("Paperi")){
				if(konesiirto.equals("Kivi")){
					System.out.println("");
					System.out.println("Paperi peittää kiven! Voitit!");			
				}else if(konesiirto.equals("Sakset")){
					System.out.println("");
					System.out.println("Sakset leikkaavat paperin! Hävisit.");
				}
			}
		}
	}
}
