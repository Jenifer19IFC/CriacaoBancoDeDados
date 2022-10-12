package com.goedert.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class GeradorObjectJson {
	

	public Object getObjectJson() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\arquivoDeDados.json"));
		Executador e = new Gson().fromJson(br, ExecutadorMysql.class); 
		System.out.println(e.toString());
		
		return e;
	}
//String nomeArquivoJson
}
