package Tallentajat;
import Tietorakenteet.*;

public class Kuviolista {

    private final Siirtopuu tilastopuu = alustaTilastopuu();

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

            int eka = e.getArvo();
            int toka = t.getArvo();
            int kolmas = k.getArvo();
            
            tilastopuu.siirraOsoitin(eka);
            tilastopuu.siirraOsoitin(toka);
            tilastopuu.siirraOsoitin(kolmas);
            tilastopuu.kasvataArvoa(tilastopuu.getJuuri());
        }

    }
    
    public String getParas(int siirto1,int siirto2){
        tilastopuu.siirraOsoitin(siirto1);
        tilastopuu.siirraOsoitin(siirto2);
        
        int kivi=tilastopuu.osoitin.getLapsi1().getArvo();
        int sakset=tilastopuu.osoitin.getLapsi2().getArvo();
        int paperi=tilastopuu.osoitin.getLapsi3().getArvo();

        if (sakset>kivi&&sakset>paperi){
            tilastopuu.osoitin=tilastopuu.getJuuri();
            return "Sakset";
        }
        if(paperi>kivi&&paperi>sakset){
            tilastopuu.osoitin=tilastopuu.getJuuri();
            return "Paperi";
        }
        tilastopuu.osoitin=tilastopuu.getJuuri();
        return "Kivi";
    }
        
    public Siirtopuu alustaTilastopuu(){
        Solmu kivi = new Solmu(0,null,null,null,null);
        Solmu sakset = new Solmu(0,null,null,null,null);
        Solmu paperi = new Solmu(0,null,null,null,null);
        kivi.lisaaLapset();
        sakset.lisaaLapset();
        paperi.lisaaLapset();
        
        for (int i = 0; i < 3; i++) {
            kivi.getLapsi(i).lisaaLapset();
            sakset.getLapsi(i).lisaaLapset();
            paperi.getLapsi(i).lisaaLapset();
        }
        
        Solmu juuri = new Solmu (-1,kivi,sakset,paperi,null);
        Siirtopuu p = new Siirtopuu(juuri);
        return p;
    }
}
