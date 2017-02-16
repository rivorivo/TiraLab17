package Algoritmit;
import Tietorakenteet.*;
import Apulogiikka.*;

public class Kuviohaku{

	Tuloslista t;
	int[][] kahdenAlkutilat;
        int[][] kolmenAlkutilat;
        Muuntaja m= new Muuntaja();

	public Kuviohaku(Tuloslista t){
		this.t=t;	
		kahdenAlkutilat = alustaKahdenAlkutilat();
		kolmenAlkutilat = alustaKolmenAlkutilat();
	}
	
	public int[][] alustaKolmenAlkutilat(){

		int[][] tilat = new int[8][2];
			int i=0;
			for (int h=0;h<9;h++){
				for (int j=0;j<3;j++){				
					tilat[h][j] = 0;
				}					
			}					
		return tilat;
	}

	public int[][] alustaKahdenAlkutilat(){
		int tilat[][]=null;
		
		for (int i=0;i<3;i++){
			for (int j=0;j<3;j++){
				tilat[i][j]=0;				
			}		
		}			
		return tilat;
	}
		


	public String getKuviot(String siirto){
		double todnakK=0.33;
		double todnakS=0.33;
		double todnakP=0.33;		
		int i=0;
                int h=0;
		int kaksSumma=0;
		int kolmeSumma=0;	
		String[] kaksEd=null;
		String[] kolmeEd=null;	
		for (int j = 2; j < t.size(); j++) {
                    String[] rivi=t.getTulos(j);
                    if (rivi[1].equals(siirto)&&i>1){
                            kaksEd = kaksiEdellist(i);
                            kolmeEd = kolmeEdellist(i);
                            for(int[] kaks:kahdenAlkutilat){
                                    if(kaksEd[0].equals(kaks[0])&&kaksEd[1].equals(kaks[1])){
                                            kahdenAlkutilat[kaks[0]][kaks[1]]+=1;
                                            kaksSumma++;
                                    }				
                            }

                            for (int[] kolme : kolmenAlkutilat){
                                    if(kolmeEd[0].equals(kolme[0])&&kolmeEd[1].equals(kolme[1])&&kolmeEd[3].equals(kolme[3]))
                                            h =0;
                                            for(int[] kaks:kahdenAlkutilat){
                                                    if(kolmeEd[0].equals(kaks[0])&&kolmeEd[1].equals(kaks[1])){
                                                            kolmenAlkutilat[j][m.muutaNumeroiksi(kolmeEd[2])]+=1;
                                                            kolmeSumma++;		
                                                    }
                                                    j++;					
                                            }					
                            }
                    }
                    i++;
                    
		}
		int[] kahden = kahdenPerusteella(kahdenAlkutilat);

                double todnak=todnakK;
		
                
                
                
                String uusi="kivi";
                if(todnakS>todnakK&&todnakS>todnakP){
                    todnak=todnakS;
                    uusi="sakset";
                }else if(todnakP>todnakK){
                    uusi="paperi";
                    todnak=todnakS;
                }
                if (todnak<0.4&&kolmeSumma!=0){
                    int[] kolmen =kolmenPerusteella(kolmenAlkutilat);
                    todnakK = kolmen[0]/kolmeSumma;
                    todnakS = kolmen[1]/kolmeSumma;
                    todnakP = kolmen[2]/kolmeSumma;
                        if(todnakS>todnakK&&todnakS>todnakP){
                            uusi="sakset";
                        }else if(todnakP>todnakK){
                            uusi="paperi";
                        }
                }
                return uusi;
	
	}
	public int[] kahdenPerusteella(int[][] kahdet){		
		int K = 0;
		int S = 0;
		int P = 0;
                    for (int i=0;i<3;i++){
                            for (int j=0;j<3;j++){
                                    int luku = kahdet[i][j];
                                    if(luku>0){
                                        switch (j) {
                                            case 0:
                                                K+=luku;
                                                break;
                                            case 1:
                                                S+=luku;
                                                break;
                                            default:
                                                P+=luku;
                                                break;	
                                        }
                                    }
                            }
                    }
                int[] KSP = {K,S,P};
		return KSP;		
	}
	
	public int[] kolmenPerusteella(int[][] kolmet){
                int K = 0;
		int S = 0;
		int P = 0;
                   for (int i=0;i<9;i++){    
                            for (int j=0;j<3;j++){
                                    int luku = kolmet[i][j];
                                    if(luku>0){
                                        switch (j) {
                                            case 0:
                                                K+=luku;
                                                break;
                                            case 1:
                                                S+=luku;
                                                break;
                                            default:
                                                P+=luku;
                                                break;	
                                        }
                                    }
                            }
                       
                   }      
                int[] KSP = {K,S,P};
		return KSP;
	}

	public String[] kaksiEdellist(int i){
		String[] eka = t.getTulos(i-2);
		String[] toka = t.getTulos(i-1);
                String[] K = {eka[1],toka[1]};
		return K;
				
	}
	public String[] kolmeEdellist(int i){
		String[] eka = t.getTulos(i-3);
		String[] toka = t.getTulos(i-2);
		String[] kolmas = t.getTulos(i-1);
                String[] K = {eka[1],toka[1],kolmas[1]};
		return K;
				
	}
}
