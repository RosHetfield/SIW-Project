package model;

public class Invito {

	private String utente;
	private String campionato;

	public Invito() {
	}

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
