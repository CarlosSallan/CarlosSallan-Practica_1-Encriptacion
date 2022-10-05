package cript_object;

public class CriptObject {
	private String mnsj_original;
	private String mnsj_final;
	private static char[] alfabeto = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W', 'X', 'Y', 'Z', 'a', 'b',
			'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', '?', '!', '.', ',', '_'};
	
	//Inicializador
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
	
	/*
	 -Getter patron transformaciones
	 * */
	
	//Algoritmo Cesar
	public void algCesar(int clave) {
	}
	
	//Pruebas
	public static void main(String[] args) {
		System.out.println(getAlfabeto());
	}
}
