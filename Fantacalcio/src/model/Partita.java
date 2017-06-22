package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Partita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5625289563782535476L;

	private int giornata;
	private boolean aggiungiFormazione;
	
	//riferimenti
	private Campionato campionato;
	private Set<Giocatore_in_formazione> giocatori;
	
	public Partita() {
		super();
	}

	public Partita(int giornata,boolean aggiungiFormazione) {
		super();
		this.giornata = giornata;
		this.aggiungiFormazione=aggiungiFormazione;
	}

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public Campionato getCampionato() {
		return campionato;
	}

	public void setCampionato(Campionato campionato) {
		this.campionato = campionato;
	}

	public Set<Giocatore_in_formazione> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(Set<Giocatore_in_formazione> giocatori) {
		this.giocatori = giocatori;
	}
	
	public void addGiocatore(Giocatore_in_formazione giocatore) {
		this.getGiocatori().add(giocatore);
	}
	
	public void removeGiocatore(Giocatore_in_formazione giocatore) {
		this.getGiocatori().add(giocatore);
	}

	public boolean isAggiungiFormazione() {
		return aggiungiFormazione;
	}

	public void setAggiungiFormazione(boolean aggiungiFormazione) {
		this.aggiungiFormazione = aggiungiFormazione;
	}

}
