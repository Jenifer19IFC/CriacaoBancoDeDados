package com.goedert.classes;

/**
 * Classe pai da F�brica de Executadores
 * 
 * @author jenifergoedert10@gmail.com 
 */
public interface FabricaDeExecutador {
	
	/**
	 * M�todo gen�rico de cria��o do objeto Executador
	 * 
	 * @param caminho
	 * @return Executador
	 */
	Executador criaExecutador(String caminho);

}
