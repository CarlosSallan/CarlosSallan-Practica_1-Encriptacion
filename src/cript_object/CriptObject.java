package cript_object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.management.StringValueExp;

public class CriptObject {
	private String mnsj_original;
	private String mnsj_final;
	// <"Nombre", "clave">
	private Map<String, Object> Patron = new LinkedHashMap<String, Object>();
	private static char[] alfabeto = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
			'Q', 'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', '?', '!', '.', ',', '_' };

	// Constructor vacio
	public CriptObject() {
	}

	// Constructor inicializador
	public CriptObject(String mnsj) {
		this.mnsj_original = mnsj;
		this.mnsj_final = mnsj;
	}

	// 4 getters
	public static String getAlfabeto() {
		String alfaString = "";

		for (int x = 0; x < alfabeto.length; x++) {
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
		for (String x : Patron.keySet()) {
			System.out.println("Nombre:" + x + " Clave:" + Patron.get(x));
		}
	}

	// Algoritmo Cesar
	public void algCesar(int clave) {
		String mnsj_encrip = "";

		for (int x = 0; x < mnsj_final.length(); x++) {
			char letra = mnsj_final.charAt(x);

			for (int y = 0; y < alfabeto.length; y++) {

				if (letra == alfabeto[y]) {
					if (y + clave > alfabeto.length) {
						letra = alfabeto[(y + clave) - alfabeto.length];
					} else {
						letra = alfabeto[y + clave];
					}
					mnsj_encrip = mnsj_encrip.concat(Character.toString(letra));
					y = alfabeto.length;
				}
			}
		}

		mnsj_final = mnsj_encrip;
		Patron.put("Cesar", clave);
	}

	public void desCesar(int clave) {
		String mnsj_encrip = "";

		for (int x = 0; x < mnsj_final.length(); x++) {
			char letra = mnsj_final.charAt(x);

			for (int y = 0; y < alfabeto.length; y++) {

				if (letra == alfabeto[y]) {
					if ((y - clave) < 0) {
						letra = alfabeto[(alfabeto.length - (y - clave)) - 2];
					} else {
						letra = alfabeto[y - clave];
					}
					mnsj_encrip = mnsj_encrip.concat(Character.toString(letra));
					y = alfabeto.length;
				}
			}
		}

		mnsj_final = mnsj_encrip;
		Patron.put("DesCesar", clave);
	}

	// Algoritmo Monoalfabético
	public void algMonoalfa(String clave) {
		String mnsj_encrip = "";
		
		//contamos el número de letras en la clave
		String ClaveFinal = "";
		for(int x = 0 ; x < clave.length() ; x++) {
			if(!ClaveFinal.contains(String.valueOf(clave.charAt(x)))) {
				ClaveFinal = ClaveFinal.concat(String.valueOf(clave.charAt(x)));
			}
		}
		
		System.out.println("Clave sin repetidos: " + ClaveFinal);
		
		
		//Ponemos el resto de caracteres al final en un nuevo String
		
		String alfabetoLimpio = ClaveFinal;
		
		for(int x = 0 ; x < alfabeto.length ; x++) {
			if(!alfabetoLimpio.contains(String.valueOf(alfabeto[x]))) {
				alfabetoLimpio = alfabetoLimpio.concat(String.valueOf(alfabeto[x]));
			}
		}
		
		System.out.println("Clave con alfabeto: " + alfabetoLimpio);
		
		//Creamos la matriz y metemos la clave final
		double decimal = (alfabetoLimpio.length() / ClaveFinal.length()) + ((alfabetoLimpio.length() % ClaveFinal.length()) * 0.1);
		System.out.println("decimal = " + decimal);
		System.out.println(alfabetoLimpio.length() + "/" + ClaveFinal.length() +"="+ Math.ceil(decimal));
		char[][] matriz = new char[(int)Math.ceil(decimal)][ClaveFinal.length()];
		int alfabetoPos = 0;
		
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				if(alfabetoPos < alfabetoLimpio.length()) {
				matriz[x][y] = alfabetoLimpio.charAt(alfabetoPos);
				alfabetoPos++;
				}else {
					matriz[x][y] = ' ';
				}
			}
		}
		
		//Imprimimos la matriz
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				System.out.print(matriz[x][y]);
			}
			System.out.println();
		}
		System.out.println();
		
		//Creamos el alfabeto final
		char[] alfabetoFinal = new char[alfabetoLimpio.length()];
		int alfabetoFinalPos = 0;
		
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				alfabetoFinal[alfabetoFinalPos] = matriz[x][y];
				alfabetoFinalPos++;
			}
		}
		
		//Imprimimos alfabeto final
		for(int x = 0; x < alfabetoFinal.length; x++) {
			System.out.print(alfabetoFinal[x]);
		}
		
		
		mnsj_final = mnsj_encrip;
	}

	public void desMonoalfa() {

	}

	// Algoritmo numeracion
	public void algNumeracion() {

	}

	public void desNumeracion() {

	}

	// Recuperacion
	public void recTransformacion() {

	}
}
