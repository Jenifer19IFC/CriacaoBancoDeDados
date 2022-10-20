package com.goedert.conn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.goedert.classes.Construtor;
import com.goedert.classes.DataBase;
import com.goedert.classes.Executador;
import com.goedert.classes.ExecutadorMysql;
import com.google.gson.Gson;

public class Conexao {

	String usuario;
	String senha;
	String porta;
	String host;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}


	public Connection conecta(String caminho) throws SQLException, ClassNotFoundException, FileNotFoundException {

		Executador e = Construtor.constroiObjetoExecutador(caminho);
		
		String urlConn = "";
		
		if(e.getSgbd().getNome().equals("mysql")) {
			
			Executador ex = Construtor.constroiObjetoExecutadorMysql(caminho);
			
			urlConn = ex.urlJdbc() + "://" + ex.getConn().host + ":" +  ex.getConn().getPorta()+ "/";
			Class.forName(ex.driverJdbc());
		}else {
			System.out.println("Perdido!");
		}
		return DriverManager.getConnection(urlConn, e.getConn().getUsuario(),e.getConn().getSenha());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Conexao [usuario=");
		builder.append(usuario);
		builder.append(", senha=");
		builder.append(senha);
		builder.append(", porta=");
		builder.append(porta);
		builder.append(", host=");
		builder.append(host);
		builder.append("]");
		return builder.toString();
	}
	
	
}
	

