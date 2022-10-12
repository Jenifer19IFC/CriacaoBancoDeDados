package com.goedert.classes;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import com.goedert.conn.Conexao;
import com.google.gson.Gson;

public class NovoTeste {

	public static void main(String[] args) throws IOException {
		
		Campo campo1 = new Campo();
		campo1.setTipo("int");
		campo1.setNome("id");
		campo1.setPk(true);
		campo1.setNn(true);
		campo1.setUq(false);
		campo1.setB(false);
		campo1.setUn(false);
		campo1.setZf(false);
		campo1.setAi(true);
		campo1.setG(false);
		
		Campo campo2 = new Campo();
		campo2.setTipo("varchar(45)");
		campo2.setNome("nome");
		campo2.setPk(false);
		campo2.setNn(false);
		campo2.setUq(true);
		campo2.setB(false);
		campo2.setUn(false);
		campo2.setZf(false);
		campo2.setAi(false);
		campo2.setG(false);
		
		Campo campo3 = new Campo();
		campo3.setTipo("varchar(45)");
		campo3.setNome("localizacao");
		campo3.setPk(false);
		campo3.setNn(true);
		campo3.setUq(false);
		campo3.setB(true);
		campo3.setUn(false);
		campo3.setZf(false);
		campo3.setAi(false);
		campo3.setG(false);
		
		Campo campo4 = new Campo();
		campo4.setTipo("varchar(45)");
		campo4.setNome("imovel");
		campo4.setPk(false);
		campo4.setNn(true);
		campo4.setUq(false);
		campo4.setB(false);
		campo4.setUn(false);
		campo4.setZf(false);
		campo4.setAi(false);
		campo4.setG(false);
		
		Tabela tabela1 = new Tabela();
		tabela1.setNome("cliente");
		tabela1.getListCampos().add(campo4);	
		tabela1.db.setNome("mercearia");
		
		Tabela tabela2 = new Tabela();
		tabela2.db.setNome("mercearia");
		tabela2.setNome("proprietario");
		tabela2.listCampos.add(campo2);
		tabela2.listCampos.add(campo3);
		tabela2.listCampos.add(campo1);
		
		Tabela tabela3 = new Tabela();
		tabela3.setNome("bens");
		tabela3.getListCampos().add(campo4);
		
		DataBase dataBase = new DataBase();
		dataBase.setNome("mercearia");
		dataBase.getListTabelas().add(tabela1);
		dataBase.getListTabelas().add(tabela2);
		dataBase.getListTabelas().add(tabela3);
		
		tabela2.db.setNome(dataBase.getNome());
		tabela3.db.setNome(dataBase.getNome());
		tabela1.db.setNome(dataBase.getNome());
		//System.out.println(dataBase.toString());
		
		Conexao c = new Conexao();
		c.setHost("localhost");
		c.setPorta("3306");
		c.setUsuario("root");
		c.setSenha("");
		
		Executador e = new ExecutadorMysql();
		e.setConn(c); 
		e.setDb(dataBase);
		e.setSgbd("mysql");
		
		//Gravação no Json para gerar meu Json inicial
		System.out.println("\nIniciando gravação no Json...\n");
		String jsonUser1 = new Gson().toJson(e);
		System.out.println(jsonUser1);
	    FileWriter fileWriter1 = new FileWriter("C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\arquivoDeDados.json");
		fileWriter1.write(jsonUser1);
		fileWriter1.flush();
		fileWriter1.close();
		System.out.println("\nJson gravado com sucesso!\n");
		
		
		
		
		
		
		
		
	}

}
