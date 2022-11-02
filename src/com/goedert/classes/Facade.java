package com.goedert.classes;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Facade {
	
	public StringBuilder showSql(String caminho) throws FileNotFoundException {
		
		Executador e = Construtor.constroiObjetoExecutador(caminho);
		
		if(e.getSgbd().getNome().equals("mysql")) {
			FabricaDeExecutador fabrica = new FabricaDeExecutadorMysql();
			Executador ex = fabrica.criaExecutador(caminho);
			return ex.mostrarSql(caminho);
		}
		
		return null;
		
	}
	
	public StringBuilder start(String caminho) throws FileNotFoundException, ClassNotFoundException, SQLException {
		Executador e = Construtor.constroiObjetoExecutador(caminho);
		
		if(e.getSgbd().getNome().equals("mysql")) {
			FabricaDeExecutador fabrica = new FabricaDeExecutadorMysql();
			Executador ex = fabrica.criaExecutador(caminho);
			return ex.executar(caminho);
		}
		return null;
		
	}
	
	
}
