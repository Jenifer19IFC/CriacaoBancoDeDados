package com.goedert.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.goedert.conn.Conexao;
import com.google.gson.Gson;

public class ExecutadorMysql extends Executador{
	
	public String driverJdbc() {
		return "com.mysql.cj.jdbc.Driver";
	}
	
	public String urlJdbc() {
		return "jdbc:mysql";
	}
	
	public StringBuilder mostrarSql(String json) throws FileNotFoundException {
		Gson gson = new Gson(); // conversor
		Executador e = gson.fromJson(json, ExecutadorMysql.class);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(e.getDb().toString());
		for (int i = 0; i < e.getDb().getListTabelas().size(); i++) {
			builder.append(e.getDb().getListTabelas().get(i).toString());
		}
		builder.append("\n\n");
		return builder;
	}
	
	public StringBuilder executar(String json) throws FileNotFoundException, SQLException, ClassNotFoundException {
		
		Gson gson = new Gson(); // conversor
		Executador e = gson.fromJson(json, ExecutadorMysql.class);

		//Criação do DATABASE e das TABELAS
		Conexao c = new Conexao();
		Connection conexao = c.conecta(json);
		StringBuilder builder = new StringBuilder();
		
		if(conexao != null) {
			try {
				//Cria schrema
				String sql = e.getDb().toString();
				PreparedStatement smt = conexao.prepareStatement(sql);
				smt.execute();
				//builder.append(sql);
				
				//Cria tabelas
				for (int i = 0; i <e.getDb().getListTabelas().size(); i++) {
					sql = e.getDb().getListTabelas().get(i).toString();
					smt = conexao.prepareStatement(sql);
					smt.execute();
					//builder.append(sql);
				}
				builder.append("\n\nOperação realizada com sucesso!");
				
			}catch (SQLException excep) {
				builder.append("\nErro ao realizar a operação.\nSchrema ou banco de dados já existe!\n");
			}
		}else {
			builder.append("Sem conexão com o banco de dados!\n");
		}
		return builder;
	}
	
	
	
	
	

}
