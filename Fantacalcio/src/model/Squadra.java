package model;

import java.io.Serializable;

public class Squadra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3350928853887919277L;

	String nome;
	int crediti;

	// riferimenti
	String utente;
	String campionato;

	public Squadra() {
		super();
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCrediti() {
		return crediti;
	}

	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}

}
