package Apulogiikka;

import Tietorakenteet.*;
import Tallentajat.Tuloslista;

public class Tulospalvelu {

    /*
	*Laskee ja palauttaa voittojen määrät tuloslistasta
     */
    public int getVoitot(Tuloslista pelit) {
        int voitot = 0;
        int pituus = pelit.size();
        for (int i = 0; i < pituus; i++) {
            Linklist tulos = pelit.getTulos(i);
            Alkio voittaja = tulos.getAlkio(2);
            int v = voittaja.getArvo();
            if (v == 0) {
                voitot++;
            }
        }
        return voitot;
    }

    public int getKonevoitot(Tuloslista pelit) {
        int konevoitot = 0;
        int pituus = pelit.size();
        for (int i = 0; i < pituus; i++) {
            Linklist tulos = pelit.getTulos(i);
            Alkio voittaja = tulos.getAlkio(2);
            int v = voittaja.getArvo();
            if (v == 1) {
                konevoitot++;
            }
        }
        return konevoitot;
    }

    public int getTasapelit(Tuloslista pelit) {
        int tasapelit = 0;
        int pituus = pelit.size();
        for (int i = 0; i < pituus; i++) {
            Linklist tulos = pelit.getTulos(i);
            Alkio voittaja = tulos.getAlkio(2);
            int v = voittaja.getArvo();
            if (v == 2) {
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
    public String getVoittaja(String siirto, String konesiirto) {

        String voittaja = "tasapeli";
        if (siirto.equals(konesiirto)) {
        } else if (siirto.equals("Kivi")) {
            if (konesiirto.equals("Sakset")) {
                voittaja = "pelaaja";
            } else if (konesiirto.equals("Paperi")) {
                voittaja = "kone";
            }
        } else if (siirto.equals("Sakset")) {
            if (konesiirto.equals("Kivi")) {
                voittaja = "kone";
            } else if (konesiirto.equals("Paperi")) {
                voittaja = "pelaaja";
            }
        } else if (siirto.equals("Paperi")) {
            if (konesiirto.equals("Kivi")) {
                voittaja = "pelaaja";
            } else if (konesiirto.equals("Sakset")) {
                voittaja = "kone";
            }
        }
        return voittaja;
    }

    public String getKierrosTulos(String siirto, String konesiirto) {

        String kierros = "";
        if (siirto.equals(konesiirto)) {
            kierros = siirto + " - " + konesiirto + "     " + "Sama siirto! Tasapeli.";
        } else if (siirto.equals("Kivi")) {
            if (konesiirto.equals("Sakset")) {
                kierros = siirto + " - " + konesiirto + "     " + "Kivi murskaa sakset! Voitit!";
            } else if (konesiirto.equals("Paperi")) {
                kierros = siirto + " - " + konesiirto + "     " + "Paperi peittää kiven! Hävisit.";
            }
        } else if (siirto.equals("Sakset")) {
            if (konesiirto.equals("Kivi")) {
                kierros = siirto + " - " + konesiirto + "     " + "Kivi murskaa sakset! Hävisit.";
            } else if (konesiirto.equals("Paperi")) {
                kierros = siirto + " - " + konesiirto + "     " + "Sakset leikkaavat paperin! Voitit!";
            }
        } else if (siirto.equals("Paperi")) {
            if (konesiirto.equals("Kivi")) {
                kierros = siirto + " - " + konesiirto + "     " + "Paperi peittää kiven! Voitit!";
            } else if (konesiirto.equals("Sakset")) {
                kierros = siirto + " - " + konesiirto + "     " + "Sakset leikkaavat paperin! Hävisit.";
            }
        }
        return kierros;
    }

    /*laskee ja tulosta koko pelin voittajan*/
    public String kokoPelinVoittaja(Tuloslista pelit) {

        if (getVoitot(pelit) < getKonevoitot(pelit)) {
            return "Kone voitti pelin!";
        } else if (getVoitot(pelit) > getKonevoitot(pelit)) {
            return "Sinä voitit pelin!";
        }
        return "Tasapeli!";

    }

    /*tulostaa @param pelit -listan perusteella voittajat*/
    public String ilmoitaTilanne(Tuloslista pelit) {
        return "Voitot: Sinä: " + getVoitot(pelit) + " Kone: " + getKonevoitot(pelit) + " Tasapelit: " + getTasapelit(pelit);
    }

}
