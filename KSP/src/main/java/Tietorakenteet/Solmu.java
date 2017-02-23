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

    public Solmu(int arvo, Solmu lapsi1, Solmu lapsi2, Solmu lapsi3, Solmu vanhempi) {
        this.arvo = arvo;
        this.lapsi1 = lapsi1;
        this.lapsi2 = lapsi2;
        this.lapsi3 = lapsi3;
        this.vanhempi = vanhempi;
    }

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
    
    public Solmu getLapsi(Solmu s, int siirto){
          switch (siirto) {
            case 0:
                return s.getLapsi1();
            case 1:
                return s.getLapsi2();
            default:
                return s.getLapsi3();
        } 
    }

    public Solmu getVanhempi() {
        return vanhempi;
    }

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


