package KSPapp;

import Tietorakenteet.*;
import Apulogiikka.*;

public class Tekoaly {

    /*
	*Alustetaan tarpeellisia muuttujia
     */
    private String konesiirto = "Paperi";
    private final Tuloslista pelit;

    private String taktiikka = "menestynein";
    private final Kuviolista kuviolista;
    private final Muuntaja m = new Muuntaja();
    private final Tulospalvelu tulospalvelu = new Tulospalvelu();

    /*
	*Konstruktori
     */
    public Tekoaly(Tuloslista pelit) {
        this.pelit = pelit;
        this.kuviolista = new Kuviolista();
    }

    /*
	*Metodi, joka antaa siirron riippuen taktiikasta 
	* ja vaihtaa taktiikkaa, jos siltä tuntuu
     */
    public String getSiirto() {
        if (pelit.size() > 2) {
            kuviolista.talletaKuvio(pelit);
        }
        if (pelit.size() > 9) {
            konesiirto = toistuvatKuviot();
        } else if (taktiikka.equals("menestynein")) {
            konesiirto = menestyksenPerusteella();
            if (pelit.size() > 4) {
                vaihdaTaktiikka("vastustajan paras");
            }
        } else if (taktiikka.equals("vastustajan paras")) {
            konesiirto = vastustajanParas();
        } else if (taktiikka.equals("toistuvat kuviot")) {
            konesiirto = toistuvatKuviot();
        }

        return konesiirto;
    }

    public void vaihdaTaktiikka(String uusi) {
        taktiikka = uusi;
    }

    /*
	*Metodi, joka valitsee siirroksi tähän asti koneen parhaiten 
	* menestyneen siirron, ottaen huomioon voitot ja häviöt
     */
    public String menestyksenPerusteella() {
        int kivet = 0;
        int sakset = 0;
        int paperit = 0;
        String isoin = "Paperi";
        for (int i = 0; i < pelit.size(); i++) {

            Linklist tulos = pelit.getTulos(i);

            int ksiirto = tulos.getVika().getArvo();
            int voitto = tulos.getAlkio(2).getArvo();

            if (voitto == 1) {
                switch (ksiirto) {
                    case 2:
                        paperit++;
                        break;
                    case 0:
                        kivet++;
                        break;
                    case 1:
                        sakset++;
                        break;
                    default:
                        break;
                }
            } else if (voitto == 0) {
                switch (ksiirto) {
                    case 1:
                        sakset--;
                        break;
                    case 2:
                        paperit--;
                        break;
                    case 0:
                        kivet--;
                        break;
                    default:
                        break;
                }
            }
        }
        if (kivet > paperit) {
            isoin = "Kivi";
            paperit = kivet;
        }
        if (sakset > paperit) {
            isoin = "Sakset";
        }
        return isoin;
    }

    /*
	*Taktiikkaa, joka pelaa vastustajan menestyneimmällä
     */
    public String vastustajanParas() {
        int kivet = 0;
        int sakset = 0;
        int paperit = 0;
        String isoin = "Paperi";
        for (int i = 0; i < pelit.size(); i++) {

            Linklist tulos = pelit.getTulos(i);
            int siirto = tulos.getVika().getEdellinen().getArvo();
            int voitto = tulos.getVika().getEdellinen().getEdellinen().getArvo();
            if (voitto == 0) {
                switch (siirto) {
                    case 0:
                        kivet++;
                        break;
                    case 1:
                        sakset++;
                        break;
                    case 2:
                        paperit++;
                        break;
                    default:
                        break;
                }
            }
        }
        if (kivet > paperit) {
            isoin = "Kivi";
            paperit = kivet;
        }
        if (sakset > paperit) {
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
    public String toistuvatKuviot() {

        Linklist e = pelit.getTulos(2);
        Linklist t = pelit.getTulos(1);
        int eka = e.getAlkio(2).getArvo();
        int toka = t.getAlkio(1).getArvo();
        String paras = kuviolista.getParas(eka, toka);
            
        return m.vastakkainen(paras);
    }

    /*
	 * palauttaa käytössä olevan taktiikan
     */
    public String getTaktiikka() {
        return taktiikka;
    }

}
