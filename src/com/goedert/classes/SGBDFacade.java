package com.goedert.classes;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * Classe estrutural que permite mostrar somente os métodos principais do projeto
 * 
 * @author jenifergoedert10@gmail.com
 *
 */
public class SGBDFacade {
	
	private String caminho;
	
	
	public SGBDFacade(String caminho) {
		setCaminho(caminho);
	}
	
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	/**
	 * @param caminho
	 * 
	 * @see Executador
	 * @see ExecutadorMysql
	 * @see FabricaDeExecutadorMysql
	 * @see Construtor
	 * 
	 * @return StringBuilder - método de mostrar Sql do Executador de acordo com o arquivo Json
	 * @throws FileNotFoundException
	 */
	public StringBuilder showSql() throws FileNotFoundException {
		
		Executador e = Construtor.constroiObjetoExecutador(caminho);
		
		if(e.getSgbd().getNome().equals("mysql")) {
			FabricaDeExecutador fabrica = new FabricaDeExecutadorMysql();
			Executador ex = fabrica.criaExecutador(caminho);
			return ex.mostrarSql(caminho);
		}
		
		return null;
		
	}
	
	/**
	 * 
	 * @see Executador
	 * @see ExecutadorMysql
	 * @see FabricaDeExecutadorMysql
	 * @see Construtor
	 * 
	 * @return método de resultado da execução de Sql do Executador de acordo com o arquivo Json
	 * @throws FileNotFoundException
	 */
	public StringBuilder start() throws FileNotFoundException, ClassNotFoundException, SQLException {
		Executador e = Construtor.constroiObjetoExecutador(caminho);
		
		if(e.getSgbd().getNome().equals("mysql")) {
			FabricaDeExecutador fabrica = new FabricaDeExecutadorMysql();
			Executador ex = fabrica.criaExecutador(caminho);
			return ex.executar(caminho);
		}
		return null;
		
	}
	
	
}
