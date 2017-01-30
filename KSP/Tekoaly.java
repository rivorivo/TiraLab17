public class Tekoaly{

	/*
	*Alustetaan tarpeellisia muuttujia
	*/
	private String konesiirto="Paperi";	
	private Tuloslista pelit;
	private String taktiikka = "vastustajan paras";
	
	public Tekoaly(Tuloslista pelit){
		this.pelit=pelit;
	}

	public String getSiirto(){
		if (pelit.size() % 2 == 0){
			vaihdaTaktiikka();
		}
		if(taktiikka.equals("menestynein")){
			konesiirto = menestyksenPerusteella();
		}
		if(taktiikka.equals("vastustajan paras")){
			konesiirto = vastustajanParas();
		}
		
		return konesiirto;	
	}
	public String vastustajanParas(){
		String paras = menestyksenPerusteella();
		if(paras.equals("Paperi")){
			paras = "Sakset";
		}else if(paras.equals("Sakset")){
			paras = "Kivi";
		}else if(paras.equals("Kivi")){
			paras = "Paperi";
		}
		return paras;
	}
	
	public void vaihdaTaktiikka(){
		if(taktiikka.equals("vastustajan paras")){
			taktiikka = "menestynein";
		}else if(taktiikka.equals("menestynein")){
			taktiikka = "vastustajan paras";
		}
	}
	
	public String menestyksenPerusteella(){
		int kivet=0;
		int sakset=0;
		int paperit=0;
		String isoin = "Paperi";
		for(int i=0; i<pelit.size(); i++){
			if(pelit.getSiirto(i).equals("Kivi")){
				kivet = laske(kivet,i);
			}else if(pelit.getSiirto(i).equals("Sakset")){
				sakset = laske(sakset,i);
			}else if(pelit.getSiirto(i).equals("Paperi")){
				paperit=laske(paperit,i);
			}
		}
		if(kivet>paperit){
			isoin = "Kivi";
			paperit=kivet;
		}if(sakset>paperit){
			isoin = "Sakset";
		}
		return isoin;
	}
	
	private int laske(int l, int m){
		if(pelit.getVoittaja(m).equals("kone")){
			l--;
		}else if(pelit.getVoittaja(m).equals("tasapeli")){
		}else{
			l++;
		}
		return l;
	}
	
	public void paivita(Tuloslista lista){
		pelit=lista;
	}
	
	public int getVoitot(){
		int voitot=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("pelaaja")){
				voitot++;
			}
		}			
		return 	voitot;
	}

	public int getKonevoitot(){
		int konevoitot=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("kone")){
				konevoitot++;
			}
		}
		return konevoitot;	
	}
	
	public int getTasapelit(){
		int tasapelit=0;
		for(int i=0; i<pelit.size(); i++){
			String v = pelit.getVoittaja(i);
			if(v.equals("tasapeli")){
				tasapelit++;
			}
		}
		return tasapelit;	
	}

}
