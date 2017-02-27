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

    public Solmu juuri;
    public Solmu osoitin;
    /*
    *konstruktori @param Solmu juuri 
    *parametrina puun juuri
    */
    public Siirtopuu(Solmu juuri) {
        this.juuri = juuri;
        this.osoitin=juuri;
    }
    /*palauttaa juuren*/
    public Solmu getJuuri() {
        return juuri;
    }
    /*palauttaa solmun, jonka kohdalla osoitin on*/
    public Solmu getOsoitin(){
        return osoitin;
    }
   
    /**
     *laskee parametrina annetun solmun korkeuden
     *käymälllä puun rekursiivisesti läpi
     * @param s
     *palauttaa -1, jos solmu null
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

    /*
    *siirtää osoittimen yhen tason alaspäin puussa
    *@param int siirto kertoo mihin lapseen
    */
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
    /*
    *kasvattaa yhdellä @param Solmu s juurena olevan puun
    *alkiota, johon osoitin osoittaa
    */
    public void kasvataArvoa(Solmu s){
        if(s==null){
            
        }else if(osoitin==s){
            osoitin=juuri;
            int uusi =s.getArvo()+1;
            s.setArvo(uusi);
        }else{
            kasvataArvoa(s.getLapsi1());
            kasvataArvoa(s.getLapsi2());
            kasvataArvoa(s.getLapsi3());
        }
        
    }
           
}
