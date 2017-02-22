package Tietorakenteet;

public class Alkio {

    int luku;
    Alkio edellinen;

    public Alkio(int luku, Alkio edellinen) {
        this.luku = luku;
        this.edellinen = edellinen;
    }

    /*palauttaa alkion arvon*/
    public int getArvo() {
        return luku;
    }

    /*palauttaa alkion, joka on asetettu edelliseksi*/
    public Alkio getEdellinen() {
        return edellinen;
    }

    /*asettaa edellisen alkion, 
  *voi olla käyttöä ehkä välistä vetämisessä
     */
    public void setEdellinen(Alkio a) {
        edellinen = a;
    }

    /*asettaa arvon alkiolle*/
    public void setArvo(int a) {
        luku = a;
    }

}
