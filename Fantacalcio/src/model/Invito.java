package model;

import java.io.Serializable;

public class Invito implements Serializable{

	private static final long serialVersionUID = 5228226867576739173L;

	private String utente;
	private String campionato;
	
	public Invito() { }
	
	public Invito(String utente, String campionato) {
		this.utente = utente;
		this.campionato = campionato;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public String getCampionato() {
		return campionato;
	}

	public void setCampionato(String campionato) {
		this.campionato = campionato;
	}
}
