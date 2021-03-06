package Tietorakenteet;

public class Linklist {

    /*
  *Listaa varten tarvittavat muuttujat.
     */
    Alkio alku;
    Alkio uusi;
    Alkio vika;
    int luku;

    public Linklist() {
        alku = null;
        uusi = null;
        vika = null;
        luku = 0;
    }

    /*
  *@param numero on alkiolle asetettava arvo
  *uusi alkio luodaan ja asetetaan viimeiseksi
  *jos alkio on ensimmäinen, se asetetaan listan alkuun.
     */
    public void uusiAlkio(int numero) {
        uusi = new Alkio(numero, vika);
        if (alku == null) {
            alku = uusi;
        }
        vika = uusi;
    }

    /*
  *Palauttaa listan viimeisen eli uusimman alkion.
     */
    public Alkio getVika() {
        return vika;
    }

    /*@param uutuus kertoo, monenneksiko uusin alkio haetaan
  *listaa käydään läpi hakemalla edellinen tarpeeksi monta kertaa.
     */
    public Alkio getAlkio(int uutuus) {
        Alkio a = vika;
        for (int i = 0; i < uutuus; i++) {
            a = a.getEdellinen();
        }
        return a;
    }

    /*
  *Laskee ja palauttaa listan pituuden käymällä listaa taaksepäin, 
  *kunnes käsiteltävän alkion edellinen on null eli alkio on listan 
  *ensimmäinen ja summaamalla kuljetut askeleet.
     */
    public int pituus() {
        Alkio a = vika;
        int pituus = 0;
        while (a != null) {
            a = a.getEdellinen();
            pituus++;
        }
        return pituus;
    }

}
