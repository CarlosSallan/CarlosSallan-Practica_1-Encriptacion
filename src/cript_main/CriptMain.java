package cript_main;

import cript_object.CriptObject;

public class CriptMain {

	public static void main(String[] args) {
		CriptObject prueba = new CriptObject("hola");
		prueba.algCesar(3);
		System.out.println(prueba.getMensajeFinal());
		prueba.getPatron();
	}

}
