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
public class Siirtopuu {

    Solmu juuri;
    Solmu osoitin;

    public Siirtopuu(Solmu juuri) {
        this.juuri = juuri;
        this.osoitin=juuri;
    }

    public Solmu getJuuri() {
        return juuri;
    }
   
    /**
     *
     * @param s
     * @return
     */
    public int korkeus(Solmu s){
        
        if (s==null){
            return -1;
        }
        int k1=korkeus(s.getLapsi1());
        int k2=korkeus(s.getLapsi2());
        int k3=korkeus(s.getLapsi3());
        int k=k1;
        if(k2>k1){
            k=k2;
        }
        if(k3>k){
            k=k3;
        }
       return k+1; 
    }

    public void siirraOsoitin(int siirto){
        switch (siirto) {
            case 0:
                osoitin=osoitin.getLapsi1();
                break;
            case 1:
                osoitin =osoitin.getLapsi2();
                break;
            default:
                osoitin=osoitin.getLapsi3();
                break;
        } 
    }
    
    public void muutaArvoa(Solmu s){
        if(s==null){
            
        }else if(s==osoitin){
            osoitin=juuri;
            int uusi =s.getArvo()+1;
            s.setArvo(uusi);
        }else{
            muutaArvoa(s.getLapsi1());
            muutaArvoa(s.getLapsi2());
            muutaArvoa(s.getLapsi3());
        }
        
    }
           
}
