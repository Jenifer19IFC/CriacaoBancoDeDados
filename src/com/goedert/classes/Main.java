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
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\arquivoDeDados.json"));
		Executador e = new Gson().fromJson(br, ExecutadorMysql.class);  
		
		if(e.getSgbd().equals("mysql")) {
			
			Executador executador = new ExecutadorMysql();
			
			while(true) {
				
				System.out.println("O que você quer fazer?\n\n"
						+ "1 - Ver comandos SQL\n"
						+ "2 - Executar SQL\n"
						+ "0 - Sair");
				int resp = input.nextInt();
				
				if(resp == 1) {
					System.out.println(executador.mostrarSql());
					System.out.println("Deseja executar?\n"
							+ "1 - Sim\n"
							+ "2 - Não\n");
					int resp2 = input.nextInt();
					if(resp2 == 1) {
						System.out.println(executador.executar());
					}
				}else if(resp == 2){
					System.out.println(executador.executar());
				}else {
					System.out.println("\nFim do programa!");
					System.exit(0);
				}
			
			}//while
			
		}// if mysql
	
	}

}
