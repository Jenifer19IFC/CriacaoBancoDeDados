package com.goedert.classes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

/**
 * Classe construtora de Objeto Executador 
 * 
 * @author jenifergoedert10@gmail.com
 * 
 */

public class Construtor {

	/**
	 * @param caminho
	 * @return objeto Executador constru�do a partir do Json
	 * @throws FileNotFoundException
	 */
	public static Executador constroiObjetoExecutador(String caminho) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader(caminho));
		Executador e = new Gson().fromJson(br, Executador.class); 
		
		return e;
	}
	
	
	
}
