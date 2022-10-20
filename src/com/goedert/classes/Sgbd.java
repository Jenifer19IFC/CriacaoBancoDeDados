package com.goedert.classes;

public class Sgbd {

	String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String capturaSgbd() {
		return "sgbd";
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
