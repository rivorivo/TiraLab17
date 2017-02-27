/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietorakenteet;

/**
 *
 * @author rivorivo
 */
public class Solmu {


    int arvo;
    Solmu lapsi1;
    Solmu lapsi2;
    Solmu lapsi3;
    Solmu vanhempi;
    /*
    *@param int arvo
    *@params lapsi1,lapsi2,lapsi3, vanhempi
    *luo solmun, jolla arvo ja tieto lapsista ja vanhemmasta
    */
    public Solmu(int arvo, Solmu lapsi1, Solmu lapsi2, Solmu lapsi3, Solmu vanhempi) {
        this.arvo = arvo;
        this.lapsi1 = lapsi1;
        this.lapsi2 = lapsi2;
        this.lapsi3 = lapsi3;
        this.vanhempi = vanhempi;
    }

    /*
    *palauttavat arvot ja tietyt lapset ja vanhemman
    */
    public int getArvo() {
        return arvo;
    }

    public Solmu getLapsi1() {
        return lapsi1;
    }

    public Solmu getLapsi2() {
        return lapsi2;
    }

    public Solmu getLapsi3() {
        return lapsi3;
    }
    
    public Solmu getVanhempi() {
        return vanhempi;
    }
    /*
    *palauttaa määrätyn @param int siirto lapsen
    */
    public Solmu getLapsi(int siirto){
          switch (siirto) {
            case 0:
                return lapsi1;
            case 1:
                return lapsi2;
            default:
                return lapsi3;
          } 
    }

    /*
    *lisaa solmulle kolme lasta
    */
    public void lisaaLapset(){
                lapsi1=new Solmu(0,null,null,null,lapsi1);
                lapsi2=new Solmu(0,null,null,null,lapsi2);
                lapsi3=new Solmu(0,null,null,null,lapsi3);
    }

    /*Asettavat arvot ja lapset ja vanhemman*/
    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public void setLapsi1(Solmu lapsi1) {
        this.lapsi1 = lapsi1;
    }

    public void setLapsi2(Solmu lapsi2) {
        this.lapsi2 = lapsi2;
    }

    public void setLapsi3(Solmu lapsi3) {
        this.lapsi3 = lapsi3;
    }

    public void setVanhempi(Solmu vanhempi) {
        this.vanhempi = vanhempi;
    }
    
    

}


