package com.goedert.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
		
		Scanner input = new Scanner(System.in);
		
		String caminho = "C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\finallyExecutador.json";
		
		Facade facade = new Facade();
		
		System.out.println(facade.showSql(caminho));
		System.out.println(facade.start(caminho));
		
		
		
		
		
		
		
		
		
			/*Executador e = new ExecutadorMysql();
			
			System.out.println(e.mostrarSql(caminho));
			System.out.println(e.executar(caminho));*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*if(Construtor.constroiObjetoExecutador(caminho).getSgbd().getNome().equals("mysql")){
			Executador e = Construtor.constroiObjetoExecutadorMysql(caminho);
			System.out.println(e.mostrarSql(caminho));
			System.out.println(e.executar(caminho));
		}*/
		
		
		//Executador e = new Executador();

		//System.out.println(e.mostrarSql(caminho));
		//System.out.println(e.executar(caminho));
		
		
		
		
		
		
		
		
		
		
		
		
		//String caminho = "C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\teste.json";
		
		//System.out.println(Construtor.constroiObjetoExecutadorMysql(caminho).getSgbd().getNome());

		
		
		/*/BufferedReader br = new BufferedReader(new FileReader(caminho));
		//Executador e = new Gson().fromJson(br, ExecutadorMysql.class);  
		
		System.out.println(e.mostrarSql(caminho, e));
		System.out.println(e.executar(caminho, e));*/
		
		/*//Executador eM = Construtor.constroiObjetoExecutadorMysql(caminho);
		//Executador e = Construtor.constroiObjetoExecutador(caminho);
		
		
		//System.out.println(e);
		
		//System.out.println(e.getSgbd());
		
		
		//System.out.println(Teste.constroiObjetoExecutador().driverJdbc());
		
		
		//Reconstruir objetos
		//Injeção de dependência
		
		
		
		//String json = "{\"conn\":{\"usuario\":\"root\",\"senha\":\"\",\"porta\":\"3306\",\"host\":\"localhost\"},\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[{\"nome\":\"cliente\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"proprietario\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"nome\",\"pk\":false,\"nn\":false,\"uq\":true,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"varchar(45)\",\"nome\":\"localizacao\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":true,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"int\",\"nome\":\"id\",\"pk\":true,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":true,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"bens\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}}]},\"sgbd\":\"mysql\"}";
		//Gson gson = new Gson(); // conversor*/
		
	}

}
