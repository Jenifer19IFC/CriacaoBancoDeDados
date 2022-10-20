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

public class Executador {

	Conexao conn;
	DataBase db;
	//String sgbd;
	Sgbd sgbd;
	
	public Conexao getConn() {
		return conn;
	}

	public void setConn(Conexao conn) {
		this.conn = conn;
	}

	public DataBase getDb() {
		return db;
	}

	public void setDb(DataBase db) {
		this.db = db;
	}
	
	public String driverJdbc() {
		return null;
	}
	
	
	public Sgbd getSgbd() {
		return sgbd;
	}
	
	public void setSgbd(Sgbd sgbd) {
		this.sgbd = sgbd;
	}

	
	
	public String urlJdbc() {
		return null;
	}
	
	public StringBuilder mostrarSql(String caminho) throws FileNotFoundException {
		StringBuilder builder = new StringBuilder();
		return builder;
	}
	
	public StringBuilder executar(String caminho) throws FileNotFoundException, SQLException, ClassNotFoundException {
		StringBuilder builder = new StringBuilder();
		return builder;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Executador [conn=");
		builder.append(conn);
		builder.append(", db=");
		builder.append(db);
		builder.append(", sgbd=");
		builder.append(sgbd);
		builder.append("]");
		return builder.toString();
	}

	

	

	

	

	
	

}
