package model;

import java.io.Serializable;

public class Campionato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2476245844517669726L;
	String nome;

	public Campionato(String nome) {
		this.nome = nome;
	}

	public Campionato() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
