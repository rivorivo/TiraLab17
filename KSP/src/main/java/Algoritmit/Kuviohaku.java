package Algoritmit;
import Tietorakenteet.*;

Public class Kuviohaku{

	Tuloslista t;
	String[][] alkutilat;

	public Kuviohaku(Tuloslista t){
		this.t=t;	
		kahdenAlkutilat = alustaKahdenAlkutilat();
		kolmenAlkutilat = alustaKolmenAlkutilat();
	}
	
	public String[][] alustaKolmenAlkutilat(){

		String[8][] tilat;
			int i=0;
			for for (int i;i<9;i++){
				for (int j;j<3;j++){				
					tilat[i][j] = 0;
				}					
			}					
		return tilat;
	}

	public String[][] alustaKahdenAlkutilat(){
		String tilat[][]=null;
		
		for (int i;i<3;i++){
			for (int j;j<3;j++){
				String tilat[i][j]=0;				
			}		
		}			
		return tilat;
	}
		


	public String[] getKuviot(String siirto){
		double todnakK=0.0;
		double todnakS=0.0;
		double todnakP=0.0;		
		int i=0;
		int kaksSumma=0;
		int kolmeSumma=0;	
		String[] kaksEd=null;
		String[] kolmeEd=null;	
		for (String[] rivi: t){
			if (rivi[1].equals(siirto)&&i>1){
				kaksEd = kaksiEdellist(i);
				kolmeEd = kolmeEdellist(i);
				for(String[] kaks:kahdenAlkutilat){
					if(kaksEd[0].equals(kaks[0])&&kaksEd[1].equals(kaks[1])){
						kahdenAlkutilat[kaks[0]][kaks[1]]+=1;
						kaksSumma++;
					}				
				}
				
				for (String[] kolme : kolmenAlkutilat){
					if(kolmeEd[0].equals(kolme[0])&&kolmeEd[1].equals(kolme[1])&&kolmeEd[3].equals(kolme[3]))
						int j =0;
						for(String[] kaks:kahdenAlkutilat){
							if(kolmeEd[0].equals(kaks[0])&&kolmeEd[1].equals(kaks[1])){
								kolmenAlkutilat[j][kolmeEd[2]]+=1;
								kolmeSumma++;		
							}
							j++;					
						}					
				}
			}
			i++;
		}
		int[] kahden = kahdenPerusteella(kahdenAlkutilat);
		todnakK = kahden[0]/summa;
		todnakS = kahden[1]/summa;
		todnakP = kahden[2]/summa;
		

	
	}
	public int[] kahdenPerusteella(String[][] kahdet){		
		int K = 0;
		int S = 0;
		int P = 0;
			for (int i;i<3;i++){
				for (int j;j<3;j++){
					luku = kahdet[i][j];
					if (j==0){
						K++;
					}else if(j==1){
						S++;
					}else{
						P++;
					}			
				}
			}
		return {K,S,P};		
	}
	
	public int kolmenPerusteella(){

	}

	public String[] kaksiEdellist(int i){
		String[] eka = t.getTulos(i-2);
		String[] toka = t.getTulos(i-1):
		return {eka[1],toka[1]};
				
	}
	public String[] kolmeEdellist(int i){
		String[] eka = t.getTulos(i-3);
		String[] toka = t.getTulos(i-2):
		String[] kolmas = t.getTulos(i-1);
		return {eka[1],toka[1],kolmas[1]};
				
	}
}
