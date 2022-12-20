package com.goedert.classes;
import java.util.Iterator;
import com.goedert.classes.Tabela; 

/**
 * Classe estrutural de Campo
 *
 * @author jenifergoedert10@gmail.com
 */


public class Campo {
	
	String tipo;  
	String nome;
	boolean pk;
	boolean nn;
	boolean uq;
	boolean b;
	boolean un;
	boolean zf;
	boolean ai;//id
	boolean g;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isPk() {
		return pk;
	}

	public void setPk(boolean pk) {
		this.pk = pk;
	}

	public boolean isNn() {
		return nn;
	}

	public void setNn(boolean nn) {
		this.nn = nn;
	}

	public boolean isUq() {
		return uq;
	}

	public void setUq(boolean uq) {
		this.uq = uq;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public boolean isUn() {
		return un;
	}

	public void setUn(boolean un) {
		this.un = un;
	}

	public boolean isZf() {
		return zf;
	}

	public void setZf(boolean zf) {
		this.zf = zf;
	}

	public boolean isAi() {
		return ai;
	}

	public void setAi(boolean ai) {
		this.ai = ai;
	}

	public boolean isG() {
		return g;
	}

	public void setG(boolean g) {
		this.g = g;
	}

	/**
	 * Método que cria comandos Sql de acordo com a definição das chaves da tabela
	 * 
	 * @return String 
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		if(tipo.equals("int")) {
			if(pk == false && nn == false && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " INT NULL");
			}
			else if(pk && nn == false && uq == false && b == false && un == false && zf == false && ai == false && g == false){
				builder.append("\n "+ nome + " INT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk == false && nn && uq == false && b == false && un == false && zf == false && ai == false && g == false) {//aqui
				builder.append("\n " + nome + " INT NOT NULL");
			}else if(pk && nn && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " INT NOT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk == false && nn == false && uq && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " INT NULL,\r\n"
						+ " UNIQUE INDEX "+ nome + "_UNIQUE (" + nome + " ASC)");
			}else if(pk == false && nn && uq && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " INT NOT NULL,\r\n"
						+ " UNIQUE INDEX "+ nome + "_UNIQUE (" + nome + " ASC)");
			}else if(pk == false && nn == false && uq == false && b == false && un && zf == false && ai == false && g == false) {
				builder.append("\n  + " + nome + " INT UNSIGNED NULL");
			}else if(pk && nn == false && uq == false && b == false && un && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " INT UNSIGNED NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn  && uq == false && b == false && un && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " INT UNSIGNED NOT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk == false && nn == false && uq == false && b == false && un == false && zf && ai == false && g == false) {
				builder.append("\n " + nome + " INT ZEROFILL NULL");
			}else if(pk && nn == false && uq == false && b == false && un == false && zf && ai == false && g == false) {
				builder.append("\n " + nome + " INT ZEROFILL NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un == false && zf && ai == false && g == false) {
				builder.append("\n " + nome + " INT ZEROFILL NOT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un == false && zf && ai && g == false) {
				builder.append("\n " + nome + " INT ZEROFILL NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un && zf == false && ai && g == false) {
				builder.append("\n " + nome + " INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn == false && uq == false && b == false && un && zf == false && ai && g == false) {
				builder.append("\n " + nome + " INT UNSIGNED NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un && zf == false && ai && g == false) {
				builder.append("\n " + nome + " INT UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn == false && uq == false && b == false && un == false && zf == false && ai  && g == false) {
				builder.append("\n " + nome + " INT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn  && uq == false && b == false && un == false && zf == false && ai  && g == false) {
				builder.append("\n " + nome + " INT NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}
			else if(pk == false && nn == false && uq == false && b == false && un && zf && ai == false && g == false) {
				builder.append("\n " + nome + " INT UNSIGNED ZEROFILL NULL");
			}else {
				builder.append("\nErro no tipo 'int'!");
			}
		}//int
		else if(tipo.equals("decimal(5,3)")) {
			if(pk == false && nn == false && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) NULL");
			}
			else if(pk && nn == false && uq == false && b == false && un == false && zf == false && ai == false && g == false){
				builder.append("\n "+ nome + " DECIMAL(5,3) NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk == false && nn && uq == false && b == false && un == false && zf == false && ai == false && g == false) {//aqui
				builder.append("\n " + nome + " DECIMAL(5,3) NOT NULL");
			}else if(pk && nn && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) NOT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk == false && nn == false && uq && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) NULL,\r\n"
						+ " UNIQUE INDEX "+ nome + "_UNIQUE (" + nome + " ASC)");
			}else if(pk == false && nn && uq && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) NOT NULL,\r\n"
						+ " UNIQUE INDEX "+ nome + "_UNIQUE (" + nome + " ASC)");
			}else if(pk == false && nn == false && uq == false && b == false && un && zf == false && ai == false && g == false) {
				builder.append("\n  + " + nome + " DECIMAL(5,3) UNSIGNED NULL");
			}else if(pk && nn == false && uq == false && b == false && un && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) UNSIGNED NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn  && uq == false && b == false && un && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) UNSIGNED NOT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk == false && nn == false && uq == false && b == false && un == false && zf && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) ZEROFILL NULL");
			}else if(pk && nn == false && uq == false && b == false && un == false && zf && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) ZEROFILL NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un == false && zf && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) ZEROFILL NOT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un == false && zf && ai && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) ZEROFILL NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un && zf == false && ai && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn == false && uq == false && b == false && un && zf == false && ai && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) UNSIGNED NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un && zf == false && ai && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) UNSIGNED NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn == false && uq == false && b == false && un == false && zf == false && ai  && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn  && uq == false && b == false && un == false && zf == false && ai  && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) NOT NULL AUTO_INCREMENT,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}
			else if(pk == false && nn == false && uq == false && b == false && un && zf && ai == false && g == false) {
				builder.append("\n " + nome + " DECIMAL(5,3) UNSIGNED ZEROFILL NULL");
			}else {
				builder.append("\nErro no tipo 'decimal(5,3)'!");
			}
		}
		else if(tipo.equals("varchar(45)")) {
			if(pk == false && nn == false && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n " + nome + " VARCHAR(45) NULL");
			}
			else if(pk && nn == false && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n "+ nome + " VARCHAR(45) NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk && nn && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n "+ nome + " VARCHAR(45) NOT NULL,\r\n"
						+ " PRIMARY KEY (" + nome + ")");
			}else if(pk == false && nn == false && uq == false && b && un == false && zf == false && ai == false && g == false) {
				builder.append("\n "+ nome + " VARCHAR(45) BINARY NULL");
			}else if(pk && nn && uq == false && b && un == false && zf == false && ai == false && g == false) {
				builder.append("\n "+ nome + " VARCHAR(45) BINARY NOT NULL,\r\n"
						+ " PRIMARY KEY ("+ nome + ")");
			}else if(pk == false && nn && uq == false && b && un == false && zf == false && ai == false && g == false){
				builder.append("\n "+ nome + " VARCHAR(45) BINARY NOT NULL");
			}else if(pk == false && nn && uq == false && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n "+ nome + " VARCHAR(45) NOT NULL");
			}
			//pk == false && nn == false && uq == false && b == false && un == false && zf == false && ai == false && g == false
			else if(pk == false && nn == false && uq && b == false && un == false && zf == false && ai == false && g == false) {
				builder.append("\n "+ nome + " VARCHAR(45) NULL,\r\n"
						+ " UNIQUE INDEX "+ nome + "_UNIQUE ("+ nome + " ASC)");
			}else {
				builder.append("\nErro no tipo 'varchar(45)'!");
			}
		}else {
			builder.append("\nTipo de dado não aceito!");
		}
		return builder.toString();
	}
	

	
	
	
}
