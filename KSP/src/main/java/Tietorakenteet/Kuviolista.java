package Tietorakenteet;

import Apulogiikka.*;

public class Kuviolista {

    private final int[][] tilastot;
    Linklist lista1 = new Linklist();
    Linklist lista2 = new Linklist();
    Linklist lista3 = new Linklist();

    Muuntaja m = new Muuntaja();
    Tulospalvelu tulospalvelu = new Tulospalvelu();

    public Kuviolista(int koko) {
        this.tilastot = new int[9][koko];

    }

    /*
	*Hakee tuloslistasta vastustajan kahden edellisen kierroksen siirrot
	*ja hakee niille kuviotA-listasta indeksin. Tallettaa indeksin ja
	*lisää viimeisen siirron mukaiseen sarakkeeseen +1.
     */
    public void talletaKuvio(Tuloslista lista) {
        int mones = lista.size();
        Linklist teka = lista.getTulos(2);
        Linklist ttoka = lista.getTulos(1);
        Linklist tkolmas = lista.getTulos(0);
        Alkio e = teka.getAlkio(1);
        Alkio t = ttoka.getAlkio(1);
        Alkio k = tkolmas.getAlkio(1);

        if (mones > 2) {
            int i = 0;
            int eka = e.getArvo();
            int toka = t.getArvo();
            int kolmas = k.getArvo();
            int[][] alkutilat = tulospalvelu.getAlkutilat();
            for (int[] rivi : alkutilat) {

                if (rivi[0] == eka && rivi[1] == toka) {
                    int vanha = tilastot[i][kolmas];
                    tilastot[i][kolmas] = vanha + 1;
                }
                i++;
            }
        }

    }
    
        public Solmu getParas(Siirtopuu p, int siirto1,int siirto2){
        p.osoitin=p.getJuuri();
        p.siirraOsoitin(siirto1);
        p.siirraOsoitin(siirto2);
 
        int kivi=p.osoitin.getLapsi1().getArvo();
        int sakset=p.osoitin.getLapsi2().getArvo();
        int paperi=p.osoitin.getLapsi3().getArvo();
        Solmu solmu=p.osoitin.getLapsi1();
        if (sakset>kivi&&sakset>paperi){
            p.osoitin=p.getJuuri();
            return solmu.getLapsi2();
        }
        if(paperi>kivi&&paperi>sakset){
            p.osoitin=p.getJuuri();
            return solmu.getLapsi3();
        }
        p.osoitin=p.getJuuri();
        return solmu.getLapsi1();
    }

    public int[][] getTilastot() {
        return tilastot;
    }
}
