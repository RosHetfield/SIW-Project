package model;

import java.io.Serializable;

import util.MD5Util;

public class Utente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8687792190967732576L;
	
	String username;
	String nome;
	String cognome;
	String email;
	String password;

	// riferimenti
	
	

	public Utente(String username, String nome, String cognome, String email, String password) {
		super();
		this.username = username;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.password=password;
	}

	public Utente() {
		super();
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password =password;
	}
}
