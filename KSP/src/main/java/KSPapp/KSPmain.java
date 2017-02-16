package KSPapp;
import Tietorakenteet.*;
import Apulogiikka.*;
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
		Tulospalvelu tulospalvelu = new Tulospalvelu();

		while(true){
			if(tuloslista.size()>=monta){
				System.out.println(tulospalvelu.kokoPelinVoittaja(tuloslista));
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
			long aikaAlussa = System.currentTimeMillis();
			String konesiirto = kone.getSiirto();		
			long aikaLopussa = System.currentTimeMillis(); 
			System.out.println("Operaatioon kone.getSiirto kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms.");
		
			/* 
			*lopputuloksen laskeminen ja ilmoitus ihmispelaajalle
			*ja konepelaajalle
			*/
			String voittaja = tulospalvelu.getVoittaja(siirto,konesiirto);
			tuloslista.lisaaPeli(voittaja, siirto, konesiirto);                 
			System.out.println(tulospalvelu.ilmoitaTilanne(tuloslista));
		}
	}
}
