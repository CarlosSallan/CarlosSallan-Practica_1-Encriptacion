package cript_object;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CriptObject {
	private String mnsj_original;
	private String mnsj_final;
	//<"Nombre", "clave">
	private Map<String, Object> Patron = new LinkedHashMap<String, Object>();
	private static char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z', 'a', 'b',
			'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '?', '!', '.', ',', '_'};
	
	//Constructor vacio
	public CriptObject() {
	}
	
	//Constructor inicializador
	public CriptObject(String mnsj) {
		this.mnsj_original = mnsj;
	}
	
	//4 getters
	public static String getAlfabeto() {
		String alfaString = "";
		
		for(int x = 0;x < alfabeto.length; x++) {
			alfaString = alfaString.concat(String.valueOf(alfabeto[x]));
		}
		return alfaString;
	}
	
	public String getMensajeOriginal() {
		return mnsj_original;
	}
	
	public String getMensajeFinal() {
		return mnsj_final;
	}
	
	public void getPatron() {
		for(String x : Patron.keySet()) {
			System.out.println("Nombre:" + x + " Clave:" +Patron.get(x));
		}
	}
	
	//Algoritmo Cesar
	public void algCesar(int clave) {
		String mnsj_encrip = "";
		
		for(int x=0;x < mnsj_original.length();x++) {
			char letra = mnsj_original.charAt(x);
			
			for(int y=0;y < alfabeto.length;y++) {
				
				if(letra == alfabeto[y]) {
					
					letra = alfabeto[y + clave];
					mnsj_encrip =  mnsj_encrip.concat(Character.toString(letra));
					y = alfabeto.length;
				}
			}
		}
		
		mnsj_final = mnsj_encrip;
		Patron.put("Cesar", clave);
	}
	
	public void desCesar() {
		
	}
	
	//Algoritmo Monoalfabético
	public void algMonoalfa() {
		
	}
	
	public void desMonoalfa() {
		
	}
	
	//Algoritmo numeracion
	public void algNumeracion() {
		
	}
	
	public void desNumeracion() {
		
	}
	
	//Recuperacion
	public void recTransformacion() {
		
	}
}
