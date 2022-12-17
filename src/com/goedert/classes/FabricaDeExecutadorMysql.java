package com.goedert.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

/**
 * Classe implementadora Mysql da interface FabricaDeExecutador
 * 
 * @author Jenifer
 *
 */
public class FabricaDeExecutadorMysql implements FabricaDeExecutador{

	/**
	 * Cria ExecutadorMysql construído a partir do arquivo Json
	 * @param caminho
	 * @return Executador 
	 */
	@Override
	public Executador criaExecutador(String caminho) {
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(caminho));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Executador e = new Gson().fromJson(br, ExecutadorMysql.class); 
		
		return e;
	}  
	
	

}
