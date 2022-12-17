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

/**
 * Classe estrutural de Executador Mysql que extende classe Executador
 * 
 * @author jenifergoedert10@gmail.com
 */
public class ExecutadorMysql extends Executador{
	
	/**
	 * DriverJdbc de conexão do Sgbd Mysql
	 * 
	 * @return String 
	 */
	public String driverJdbc() {
		return "com.mysql.cj.jdbc.Driver";
	}
	
	/**
	 * UrlJdbc  de conexão do Sgbd Mysql
	 * 
	 * @return String 
	 */
	public String urlJdbc() {
		return "jdbc:mysql";
	}
	
	/**
	 * Mostrar comandos Sql de criação de Data Base e tabelas
	 * 
	 * @param caminho
	 * @return StringBuilder -
	 */
	public StringBuilder mostrarSql(String caminho) throws FileNotFoundException {
		
		FabricaDeExecutador fabrica = new FabricaDeExecutadorMysql();
		Executador e = fabrica.criaExecutador(caminho);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append(e.getDb().toString());
		for (int i = 0; i < e.getDb().getListTabelas().size(); i++) {
			builder.append(e.getDb().getListTabelas().get(i).toString());
		}
		builder.append("\n\n");
		return builder;
	}
	
	/**
	 * Execução dos comandos Sql
	 * 
	 * @param caminho
	 * @return  StringBuilder 
	 */
	public StringBuilder executar(String caminho) throws FileNotFoundException, SQLException, ClassNotFoundException {
		
		FabricaDeExecutador fabrica = new FabricaDeExecutadorMysql();
		Executador e = fabrica.criaExecutador(caminho);
		
		//Criação do DATABASE e das TABELAS
		Conexao c = new Conexao();
		Connection conexao = c.conecta(caminho);
		StringBuilder builder = new StringBuilder();
		
		if(conexao != null) {
			try {
				//Cria schrema
				String sql = e.getDb().toString();
				PreparedStatement smt = conexao.prepareStatement(sql);
				smt.execute();
				//builder.append(sql);
				
				//Seleciona o banco criado
				PreparedStatement use = conexao.prepareStatement("USE " + e.getDb().nome + ";");
				use.execute();
				
				//Cria tabelas
				for (int i = 0; i <e.getDb().getListTabelas().size(); i++) {
					sql = e.getDb().getListTabelas().get(i).toString();
					smt = conexao.prepareStatement(sql);
					smt.execute();
					//builder.append(sql);
				}
				builder.append("\n\nOperação realizada com sucesso!");
				
			}catch (SQLException excep) {
				System.out.println(excep);
				builder.append("\nErro ao realizar a operação.\nSchrema ou banco de dados já existe!\n");
			}
		}else {
			builder.append("Sem conexão com o banco de dados!\n");
		}
		return builder;
	}
	
	
	
	
	

}
