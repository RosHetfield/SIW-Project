package model;

import java.util.Set;

public class Squadra {

	private String nome;
	private int crediti;

	// riferimenti
	private Utente utente;
	private Campionato campionato;

	private Set<Giocatore_in_rosa> giocatori;	
	

	public Squadra() {
		super();
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Campionato getCampionato() {
		return campionato;
	}

	public void setCampionato(Campionato campionato) {
		this.campionato = campionato;
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

	public Set<Giocatore_in_rosa> getGiocatoriInRosa() {
		return giocatori;
	}

	public void setGiocatoriInRosa(Set<Giocatore_in_rosa> giocatori) {
		this.giocatori = giocatori;
	}

	public void addGiocatore(Giocatore_in_rosa giocatore) {
		this.getGiocatoriInRosa().add(giocatore);
	}

	public void removeGiocatore(Giocatore_in_rosa giocatore) {
		this.getGiocatoriInRosa().remove(giocatore);
	}

}
