/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apulogiikka;

/**
 *
 * @author rivorivo
 */
public class Muuntaja {
    	/*Muuttaa numero-koodauksen taas String-muotoon ja toisinpäin*/
	public String muutaSanaksi(int num){
		String sana ="Kivi";
		if (num==1){
			sana="Sakset";
		}else if(num==2){;
			sana="Paperi";
		}
		return sana;
	}
	public int muutaNumeroiksi(String sana){
			int numero=0;
			if(sana.equals("Sakset")||sana.equals("kone")){
				numero=1;
			}else if(sana.equals("Paperi")||sana.equals("tasapeli")){
				numero=2;
			}

			return numero;
	}
	/*
	*Palauttaa siirron, joka voittaa parametrina 
	*@param siirto 
	*annetun siirron.
	*/
	public String vastakkainen(String siirto){

		if(siirto.equals("Paperi")){
			siirto = "Sakset";
		}else if(siirto.equals("Sakset")){
			siirto = "Kivi";
		}else if(siirto.equals("Kivi")){
			siirto = "Paperi";
		}
		return siirto;
	}
}
