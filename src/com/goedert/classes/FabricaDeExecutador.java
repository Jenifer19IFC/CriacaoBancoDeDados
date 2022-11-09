package com.goedert.classes;

/**
 * Classe pai da Fábrica de Executadores
 * 
 * @author jenifergoedert10@gmail.com
 * 
 */
public interface FabricaDeExecutador {
	
	/**
	 * Método genérico de criação do objeto Executador
	 * @param caminho
	 * @return objeto Executador
	 */
	Executador criaExecutador(String caminho);

}
