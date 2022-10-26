package cript_main;

import cript_object.CriptObject;

public class CriptMain {

	public static void main(String[] args) {
		CriptObject prueba = new CriptObject("NOPQ");
		
		/*
		prueba.algCesar(3);
		System.out.println(prueba.getMensajeFinal());
		prueba.getPatron();
		prueba.desCesar(3);
		System.out.println(prueba.getMensajeFinal());
		prueba.getPatron();
		*/
		
		prueba.algMonoalfa("calee");
		System.out.println(prueba.getMensajeFinal());
		prueba.getPatron();
		prueba.desMonoalfa("calee");
		System.out.println(prueba.getMensajeFinal());
		prueba.getPatron();
	}

}
