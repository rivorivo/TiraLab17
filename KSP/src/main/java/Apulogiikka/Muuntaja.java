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
	public int muutaNumeroiksi(String siirto){
			int numero=0;
			if(siirto.equals("Sakset")){
				numero=1;
			}else if(siirto.equals("Paperi")){
				numero=2;
			}
			return numero;
	}
}
