package model;

import java.io.Serializable;

public class Utente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8687792190967732576L;
	String nome;
	String cognome;
	String email;
	String username;
	String password;

	// riferimenti
	
	

	public Utente(String nome, String cognome, String email, String username,String password) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.username = username;
		this.password=password;
	}

	public Utente() {
		super();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
