package com.goedert.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * Classe que apresenta somente os métodos principais do projeto: Mostrar Sql e Executar Sql
 * Tem como entrada um caminho de um arquivo Json
 * 
 * @author jenifergoedert10@gmail.com
 * 
 * @param caminho
 */

public class Main {
	
	public static void main(String[] args) throws
	FileNotFoundException, SQLException, ClassNotFoundException {
		
		Scanner input = new Scanner(System.in);
		
		String caminho = "C:\\Users\\Jenifer\\Documents\\"
				+ "Github\\POO II\\Trabalho1\\src\\aqui.json";
		
		SGBDFacade facade = new SGBDFacade(caminho);
		
		System.out.println(facade.showSql());
		System.out.println(facade.start());
		
	}
}

