package com.goedert.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

public class Construtor {

	public static Executador constroiObjetoExecutador(String caminho) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader(caminho));
		Executador e = new Gson().fromJson(br, Executador.class); 
		
		return e;
	}
	
	/*public static Executador constroiObjetoExecutadorMysql(String caminho) throws FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader(caminho));
		Executador e = new Gson().fromJson(br, ExecutadorMysql.class); 
		
		return e;
	}*/
	
}
