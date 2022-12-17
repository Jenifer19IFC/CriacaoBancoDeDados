package com.goedert.classes;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.Mysqlx.ClientMessages.Builder;

/**
 * Classse estrutural da Tabela
 * 
 * @author jenifergoedert10@gmail.com
 *
 */
public class Tabela {

	String nome;
	List<Campo> listCampos = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Campo> getListCampos() {
		return listCampos;
	}

	public void setListCampos(List<Campo> listCampos) {
		this.listCampos = listCampos;
	}

	/**
	 * Método que cria Sql da Tabela
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n\nCREATE table ");
		builder.append(nome + "(");
		//For para percorrer os campos das tabelas
		for(int i = 0; i < listCampos.size(); i++) {
			builder.append(listCampos.get(i).toString());
			if(!(i == listCampos.size()-1)){
				builder.append(",");
			}
		}
		builder.append(");");
		return builder.toString();
	}

	
	
	
	
}
 