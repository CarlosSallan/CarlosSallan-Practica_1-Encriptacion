package cript_object;

import java.util.ArrayList;
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
		this.mnsj_final = mnsj;
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
		
		for(int x=0;x < mnsj_final.length();x++) {
			char letra = mnsj_final.charAt(x);
			
			for(int y=0;y < alfabeto.length;y++) {
				
				if(letra == alfabeto[y]) {
					if(y + clave > alfabeto.length) {
						letra = alfabeto[(y + clave) - alfabeto.length];
					}else {
					letra = alfabeto[y + clave];
				}
					mnsj_encrip =  mnsj_encrip.concat(Character.toString(letra));
					y = alfabeto.length;
				}
			}
		}
		
		mnsj_final = mnsj_encrip;
		Patron.put("Cesar", clave);
	}
	
	public void desCesar(int clave) {
		String mnsj_encrip = "";
		
		for(int x=0;x < mnsj_final.length();x++) {
			char letra = mnsj_final.charAt(x);
			
			for(int y=0;y < alfabeto.length;y++) {
				
				if(letra == alfabeto[y]) {
					if((y - clave) < 0) {
						letra = alfabeto[(alfabeto.length - (y - clave))-2];
					}else {
					letra = alfabeto[y - clave];
					}
					mnsj_encrip =  mnsj_encrip.concat(Character.toString(letra));
					y = alfabeto.length;
				}
			}
		}
		
		mnsj_final = mnsj_encrip;
		Patron.put("DesCesar", clave);
	}
	
	//Algoritmo Monoalfabético
	public void algMonoalfa(String clave) {
		String palabraClave = "";
		//quitamos las letras repetidas de la clave
		int[] charRepetidos = new int[alfabeto.length];
		
		for(int x= 0;x < clave.length();x++) {
			for(int y= 0;y<alfabeto.length;y++) {
				if((clave.charAt(x) == alfabeto[y]) && (charRepetidos[y] == 0)) {
					charRepetidos[y] = 1;
					palabraClave.concat(String.valueOf(clave.charAt(x)));
				}
			}
		}
		
		System.out.println(palabraClave + "AAA");
		
		String mnsj_encrip = "";
		ArrayList<String> alfabetoFinal = new ArrayList<String>();
		
		//recorre el alfabeto para quitar las repetidas
		for(int x=0;x<alfabeto.length;x++) {
			if(!palabraClave.contains(String.valueOf(alfabeto[x]))) {
				alfabetoFinal.add(String.valueOf(alfabeto[x]));
			}
		}
		
		
		//prueba recorre alfabeto finalS
				for(String s : alfabetoFinal) {
					System.out.print(s);
				}
				System.out.println();
				
				System.out.println("alfa final= "+alfabetoFinal.size());
				System.out.println("division "+Math.ceil(alfabetoFinal.size() / palabraClave.length()));
				System.out.println("x= "+palabraClave.length());
				System.out.println("y= "+alfabetoFinal.size() / palabraClave.length());
				
				Double matrizXDouble = Math.ceil(alfabetoFinal.size() / palabraClave.length());
				int matrizX = (int) Math.round(matrizXDouble);
				
		char[][] matriz = new char[matrizX][palabraClave.length()];
		
		
		//recorre clave para ponerla en la matriz
		int X = 0;
		int Y = 0;
		int posAlfabeto = 0;
		
		for(int posX = 0;posX<matriz.length;posX ++) {
			for(int posY = 0;posY<matriz[posX].length;posY ++) {
					matriz[posX][posY] = clave.charAt(posY);
			}
		}
		
		for(int posX = 1;posX<matriz.length;posX ++) {
			for(int posY = 0;posY<matriz[posX].length;posY ++) {
					matriz[posX][posY] = alfabetoFinal.get(posAlfabeto).charAt(0);
					posAlfabeto++;
				/*
				matriz[posX][posY] = alfabetoFinal.get(posAlfabeto).charAt(0);
				posAlfabeto++;
				*/
			}
		}
		
		//prueba recorre matriz
		for(int x=0;x<matriz.length;x++) {
			for(int y=0;y<matriz[x].length;y++) {
				System.out.print(matriz[x][y]);
			}
			System.out.println();
		}
		
		
		
		this.mnsj_final = mnsj_encrip;
		Patron.put("Monoalfa", clave);
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
