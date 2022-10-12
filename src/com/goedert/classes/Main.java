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
		
		/*BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\arquivoDeDados.json"));
		Executador e = new Gson().fromJson(br, ExecutadorMysql.class);  
		
		System.out.println("Digite o nome do arquivo json:");
		String nomeArquivoJson = input.nextLine();*/
		
		String json = "{\"conn\":{\"usuario\":\"root\",\"senha\":\"\",\"porta\":\"3306\",\"host\":\"localhost\"},\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[{\"nome\":\"cliente\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"proprietario\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"nome\",\"pk\":false,\"nn\":false,\"uq\":true,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"varchar(45)\",\"nome\":\"localizacao\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":true,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"int\",\"nome\":\"id\",\"pk\":true,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":true,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"bens\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}}]},\"sgbd\":\"mysql\"}";
		Gson gson = new Gson(); // conversor
		Executador e = gson.fromJson(json, Executador.class);
		
		if(e.getSgbd().equals("mysql")) {
			
			Executador executador = new ExecutadorMysql();
			
			while(true) {
				
				System.out.println("O que você quer fazer?\n\n"
						+ "1 - Ver comandos SQL\n"
						+ "2 - Executar SQL\n"
						+ "0 - Sair");
				int resp = input.nextInt();
				
				if(resp == 1) {
					System.out.println(executador.mostrarSql(json));
					System.out.println("Deseja executar?\n"
							+ "1 - Sim\n"
							+ "2 - Não\n");
					int resp2 = input.nextInt();
					if(resp2 == 1) {
						System.out.println(executador.executar(json));
					}
				}else if(resp == 2){
					System.out.println(executador.executar(json));
				}else {
					System.out.println("\nFim do programa!");
					System.exit(0);
				}
			
			}//while
			
		}// if mysql
	
	}

}
