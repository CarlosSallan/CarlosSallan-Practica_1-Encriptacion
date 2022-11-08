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
		String mnsjFinal = "";
		
		for(int x = 0; x < mnsj_final.length() ; x++) {
			if(mnsj_final.charAt(x) != ' ') {
				mnsjFinal = mnsjFinal.concat(String.valueOf(mnsj_final.charAt(x)));
			}
		}
		
		return mnsjFinal;
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
		
		
		//Ponemos el resto de caracteres al final en un nuevo String
		
		String alfabetoLimpio = ClaveFinal;
		
		for(int x = 0 ; x < alfabeto.length ; x++) {
			if(!alfabetoLimpio.contains(String.valueOf(alfabeto[x]))) {
				alfabetoLimpio = alfabetoLimpio.concat(String.valueOf(alfabeto[x]));
			}
		}
		
		//Creamos la matriz y metemos la clave final
		double decimal = (alfabetoLimpio.length() / ClaveFinal.length()) + ((alfabetoLimpio.length() % ClaveFinal.length()) * 0.1);
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
		
		/*
		//Imprimimos la matriz
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[x].length; y++) {
				System.out.print(matriz[x][y]);
			}
			System.out.println();
		}
		System.out.println();
		*/
		
		//Creamos el alfabeto final
		char[] alfabetoFinal = new char[alfabetoLimpio.length()];
		int alfabetoFinalPos = 0;
		
		for(int x = 0; x < matriz[0].length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				if(alfabetoFinalPos < alfabetoFinal.length) {
					if(!(matriz[y][x] == ' ')) {
						alfabetoFinal[alfabetoFinalPos] = matriz[y][x];
						alfabetoFinalPos++;
					}
				}
			}
		}
		
		//Imprimimos alfabeto final
		for(int x = 0; x < alfabetoLimpio.length(); x++) {
			System.out.print(alfabetoLimpio.charAt(x));
		}
		
		System.out.println();
		
		//Imprimimos alfabeto final
		for(int x = 0; x < alfabetoFinal.length; x++) {
			System.out.print(alfabetoFinal[x]);
		}
		System.out.println();
		
		//Ciframos
		for(int x = 0; x < mnsj_final.length(); x++) {
			for(int y = 0 ; y < alfabetoFinal.length; y++) {
				if(mnsj_final.charAt(x) == alfabetoLimpio.charAt(y)) {
					mnsj_encrip = mnsj_encrip.concat(String.valueOf(alfabetoFinal[y]));
				}
			}
		}
		
		
		
		Patron.put("AlgMonoalfa", clave);
		mnsj_final = mnsj_encrip;
	}

	public void desMonoalfa(String clave) {
		String mnsj_encrip = "";
		
		//contamos el número de letras en la clave
		String ClaveFinal = "";
		for(int x = 0 ; x < clave.length() ; x++) {
			if(!ClaveFinal.contains(String.valueOf(clave.charAt(x)))) {
				ClaveFinal = ClaveFinal.concat(String.valueOf(clave.charAt(x)));
			}
		}
		
		//Imprimimos clave final
		System.out.println(ClaveFinal);
		
		//Ponemos el resto de caracteres al final en un nuevo String
		
		String alfabetoLimpio = ClaveFinal;
		
		for(int x = 0 ; x < alfabeto.length ; x++) {
			if(!alfabetoLimpio.contains(String.valueOf(alfabeto[x]))) {
				alfabetoLimpio = alfabetoLimpio.concat(String.valueOf(alfabeto[x]));
			}
		}
		
		//Creamos la matriz y metemos la clave final
		double decimal = (alfabetoLimpio.length() / ClaveFinal.length()) + ((alfabetoLimpio.length() % ClaveFinal.length()) * 0.1);
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
		
		
		//Creamos el alfabeto final
		char[] alfabetoFinal = new char[alfabetoLimpio.length()];
		int alfabetoFinalPos = 0;
		
		for(int x = 0; x < matriz[0].length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				if(alfabetoFinalPos < alfabetoFinal.length) {
					if(!(matriz[y][x] == ' ')) {
						alfabetoFinal[alfabetoFinalPos] = matriz[y][x];
						alfabetoFinalPos++;
					}
				}
			}
		}
		
		//Ciframos
		for(int x = 0; x < mnsj_final.length(); x++) {
			for(int y = 0 ; y < alfabetoFinal.length; y++) {
				if(mnsj_final.charAt(x) == alfabetoFinal[y]) {
					mnsj_encrip = mnsj_encrip.concat(String.valueOf(alfabetoLimpio.charAt(y)));
				}
			}
		}
		
		
		Patron.put("DesMonoalfa", clave);
		mnsj_final = mnsj_encrip;
	}

	// Algoritmo numeracion
	public void algNumeracion(String clave) {
		String mnsj_encrip = "";
		
		//contamos el número de letras en la clave
		String ClaveFinal = "";
		for(int x = 0 ; x < clave.length() ; x++) {
			if(!ClaveFinal.contains(String.valueOf(clave.charAt(x)))) {
				ClaveFinal = ClaveFinal.concat(String.valueOf(clave.charAt(x)));
			}
		}
		
		//Ponemos el resto de caracteres al final en un nuevo String
		String caracteres = ClaveFinal.concat(mnsj_final);
		
		//Creamos la matriz y metemos la clave y el mensaje
		double decimal = (caracteres.length() / ClaveFinal.length()) + ((caracteres.length() % ClaveFinal.length()) * 0.1);
		char[][] matriz = new char[(int)Math.ceil(decimal)][ClaveFinal.length()];
		
		int caracteresPos = 0;
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				if(caracteresPos < caracteres.length()) {
					matriz[x][y] = caracteres.charAt(caracteresPos);
					caracteresPos++;
				}else {
					matriz[x][y] = ' ';
				}
			}
		}
		
		//Ordenamos alfabeticamente
		
		String ClaveOrdenada = "";
		
		for(int alfPos = 0; alfPos < alfabeto.length;alfPos++) {
			for(int clavePos = 0; clavePos < ClaveFinal.length();clavePos++) {
				if(alfabeto[alfPos] == ClaveFinal.charAt(clavePos)) {
					ClaveOrdenada = ClaveOrdenada.concat(String.valueOf(alfabeto[alfPos]));
				}
			}
		}
		
		//Creamos una nueva matriz final
		char[][] matrizFinal = new char[(int)Math.ceil(decimal)][ClaveFinal.length()];
		
		//Ordenamos la matriz alfabeticamente
		int matrizFinalPos = 0;
		
		//Por la clave
		for(int alfPos = 0; alfPos < ClaveOrdenada.length();alfPos++) {
			//Primera linea matriz[0][y]
			for(int y = 0; y < matriz[0].length; y++) {
				//Si coincide
				if(ClaveOrdenada.charAt(alfPos) == matriz[0][y]) {
					for(int x = 0; x < matriz.length; x++) {
						mnsj_encrip = mnsj_encrip.concat(String.valueOf(matriz[x][y]));
					}
				}
			}
		}
		
		Patron.put("AlgNumeracio", clave);
		mnsj_final = mnsj_encrip;
	}

	public void desNumeracion(String clave) {
		String mnsj_encrip = "";

		//contamos el número de letras en la clave
		String ClaveFinal = "";
		for(int x = 0 ; x < clave.length() ; x++) {
			if(!ClaveFinal.contains(String.valueOf(clave.charAt(x)))) {
				ClaveFinal = ClaveFinal.concat(String.valueOf(clave.charAt(x)));
			}
		}
		
		//Creamos la matriz y metemos el mnsj final
		double decimal = (mnsj_final.length() / ClaveFinal.length()) + ((mnsj_final.length() % ClaveFinal.length()) * 0.1);
		char[][] matriz = new char[(int)Math.ceil(decimal)][ClaveFinal.length()];
		int mnsjPos = 0;
		
		for(int x = 0; x < matriz[0].length; x++) {
			for(int y = 0; y < matriz.length; y++) {
				matriz[y][x] = mnsj_final.charAt(mnsjPos);
				mnsjPos++;
			}
		}
		
		/*
		//Imprimimos
		for(int x = 0; x < matriz.length; x++) {
			for(int y = 0; y < matriz[0].length; y++) {
				System.out.print(matriz[x][y]);
			}
			System.out.println();
		}
		*/
		
		//Por la clave
		for(int alfPos = 0; alfPos < ClaveFinal.length();alfPos++) {
			//Primera linea matriz[0][y]
			for(int y = 0; y < matriz[0].length; y++) {
				//Si coincide
				if(ClaveFinal.charAt(alfPos) == matriz[0][y]) {
					for(int x = 0; x < matriz.length; x++) {
						mnsj_encrip = mnsj_encrip.concat(String.valueOf(matriz[x][y]));
					}
				}
			}
		}
		
		Patron.put("DesNumeracio", clave);
		mnsj_final = mnsj_encrip;
	}

	// Recuperacion
	public void recTransformacion() {

	}
}
