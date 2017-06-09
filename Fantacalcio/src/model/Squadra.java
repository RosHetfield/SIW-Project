package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Squadra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3350928853887919277L;

	String nome;
	int crediti;

	// riferimenti
	Utente utente;
	Campionato campionato;
	private Set<Giocatore_in_rosa> giocatori;

	public Squadra() {
		super();
		this.utente = new Utente();
		this.campionato = new Campionato();
		this.setGiocatori(new HashSet<Giocatore_in_rosa>());
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

	public Set<Giocatore_in_rosa> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(Set<Giocatore_in_rosa> giocatori) {
		this.giocatori = giocatori;
	}

	public void addGiocatore(Giocatore_in_rosa giocatore) {
		this.getGiocatori().add(giocatore);
	}
	
	public void removeGiocatore(Giocatore_in_rosa giocatore) {
		this.getGiocatori().remove(giocatore);
	}
}
