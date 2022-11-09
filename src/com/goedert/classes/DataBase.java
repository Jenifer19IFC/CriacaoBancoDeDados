package com.goedert.classes;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe estrutural de Data Base
 * 
 * @author jenifergoedert10@gmail.com
 *
 */
public class DataBase {
	
	String nome;
	String collation = "utf8mb4_general_ci";
	String characterset = "utf8mb4";
	
	List<Tabela> listTabelas = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCollation() {
		return collation;
	}
	public void setCollation(String collation) {
		this.collation = collation;
	}
	public String getCharacterset() {
		return characterset;
	}
	public void setCharacterset(String characterset) {
		this.characterset = characterset;
	}
	
	public List<Tabela> getListTabelas() {
		return listTabelas;
	}
	public void setListTabelas(List<Tabela> listTabelas) {
		this.listTabelas = listTabelas;
	}
	
	/**
	 * Método que cria comando Sql do Data Base
	 * 
	 * @return StringBuilder
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CREATE SCHEMA ");
		builder.append(nome);
		builder.append(" ");
		builder.append("DEFAULT CHARACTER SET ");
		builder.append(characterset);
		builder.append(" COLLATE ");
		builder.append(collation);
		builder.append(";");
		
		//For para percorrer as listas de tabelas
		//for(int i = 0; i < listTabelas.size(); i++) {
		//	builder.append(listTabelas.get(i).toString());
		//}
		return builder.toString();
	}	
	

}
