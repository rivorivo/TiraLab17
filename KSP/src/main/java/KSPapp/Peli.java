package KSPapp;

import Apulogiikka.*;
import Tallentajat.*;
import java.util.Scanner;

/*käyttöliittymä, joka kysyy siirron ja ilmoittaa lopputuloksen
 */
public class Peli {

    Scanner konsoli = new Scanner(System.in);
    int monta;
    Muuntaja m = new Muuntaja();
    Tuloslista tuloslista = new Tuloslista();
    Tekoaly kone = new Tekoaly(tuloslista);
    Tulospalvelu tulospalvelu = new Tulospalvelu();
    String tilanne = "";
    String voittaja = "";
    String kierros = "";

    public Peli(int monta) {
        this.monta = monta;
    }

    public boolean tarkistaPituus() {
        return tuloslista.size() >= monta;
    }

    public String getTilanne() {
        return tilanne;
    }

    public String getKokoPelinVoittaja() {
        return tulospalvelu.kokoPelinVoittaja(tuloslista);
    }

    public String getKierros() {
        return kierros;
    }

    public void pelaa(String siirto) {

        /*
			*Tähän väliin tekoälyltä siirron kysyminen
			*@param konesiirto tallettaa konepelaajan siirron	
         */
        String konesiirto = kone.getSiirto();

        /* 
			*lopputuloksen laskeminen ja ilmoitus ihmispelaajalle
			*ja konepelaajalle
         */
        voittaja = tulospalvelu.getVoittaja(siirto, konesiirto);
        kierros = tulospalvelu.getKierrosTulos(siirto, konesiirto);
        tuloslista.lisaaPeli(m.muutaNumeroiksi(voittaja), m.muutaNumeroiksi(siirto), m.muutaNumeroiksi(konesiirto));
        tilanne = tulospalvelu.ilmoitaTilanne(tuloslista);
    }

}
