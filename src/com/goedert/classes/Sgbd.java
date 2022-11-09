package com.goedert.classes;

/**
 * Classe estrutural do Sgdb
 * 
 * @author jenifergoedert10@gmail.com
 * 
 */
public class Sgbd {

	String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sgbd [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
