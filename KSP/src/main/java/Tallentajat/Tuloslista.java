package Tallentajat;
import Tietorakenteet.*;

public class Tuloslista {

    private final Linklist siirtolista;
    private final Linklist voittolista;
    private final Linklist konesiirtolista;
    /*luo kolme listaa*/
    public Tuloslista() {
        siirtolista = new Linklist();
        voittolista = new Linklist();
        konesiirtolista = new Linklist();
    }
    /*
    *lisää listoihinsa @params int voittaja,siirto,konesiirto
    */
    public void lisaaPeli(int voittaja, int siirto, int konesiirto) {
        voittolista.uusiAlkio(voittaja);
        siirtolista.uusiAlkio(siirto);
        konesiirtolista.uusiAlkio(konesiirto);
    }
    /*
    *etsii listoista @param int j -mukaisen tuloksen ja
    *palauttaa listan, jossa siirto,koneen siirto ja voittaja
    *
    */
    public Linklist getTulos(int j) {
        Linklist tulos = new Linklist();
        tulos.uusiAlkio(voittolista.getAlkio(j).getArvo());
        tulos.uusiAlkio(siirtolista.getAlkio(j).getArvo());
        tulos.uusiAlkio(konesiirtolista.getAlkio(j).getArvo());
        return tulos;
    }
    /*palauttaa listan pituuden*/
    public int size() {
        return voittolista.pituus();
    }

}
