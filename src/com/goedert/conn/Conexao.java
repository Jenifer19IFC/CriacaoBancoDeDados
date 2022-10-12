package com.goedert.conn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


	public Connection conecta() throws SQLException, ClassNotFoundException, FileNotFoundException {
		//BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\"+nomeArquivoJson+".json"));
		//Executador e = new Gson().fromJson(br, Executador.class);
		String json = "{\"conn\":{\"usuario\":\"root\",\"senha\":\"\",\"porta\":\"3306\",\"host\":\"localhost\"},\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[{\"nome\":\"cliente\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"proprietario\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"nome\",\"pk\":false,\"nn\":false,\"uq\":true,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"varchar(45)\",\"nome\":\"localizacao\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":true,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"int\",\"nome\":\"id\",\"pk\":true,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":true,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"bens\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}}]},\"sgbd\":\"mysql\"}";
		
		Gson gson = new Gson(); // conversor
		Executador e = gson.fromJson(json, Executador.class);
		String urlConn = "";
		
		if(e.getSgbd().equals("mysql")) {
			//BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Jenifer\\Documents\\Github\\POO II\\Trabalho1\\src\\"+nomeArquivoJson+".json"));
			//Executador ex = new Gson().fromJson(br2, ExecutadorMysql.class);
			
			String json2 = "{\"conn\":{\"usuario\":\"root\",\"senha\":\"\",\"porta\":\"3306\",\"host\":\"localhost\"},\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[{\"nome\":\"cliente\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"proprietario\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"nome\",\"pk\":false,\"nn\":false,\"uq\":true,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"varchar(45)\",\"nome\":\"localizacao\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":true,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false},{\"tipo\":\"int\",\"nome\":\"id\",\"pk\":true,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":true,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}},{\"nome\":\"bens\",\"listCampos\":[{\"tipo\":\"varchar(45)\",\"nome\":\"imovel\",\"pk\":false,\"nn\":true,\"uq\":false,\"b\":false,\"un\":false,\"zf\":false,\"ai\":false,\"g\":false}],\"db\":{\"nome\":\"mercearia\",\"collation\":\"utf8mb4_general_ci\",\"characterset\":\"utf8mb4\",\"listTabelas\":[]}}]},\"sgbd\":\"mysql\"}";
			Gson gson2 = new Gson(); // conversor
			Executador ex = gson.fromJson(json, ExecutadorMysql.class);
			
			urlConn = ex.urlJdbc() + "://" + ex.getConn().host + ":" +  ex.getConn().getPorta()+ "/";
			Class.forName(ex.driverJdbc());
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
	

