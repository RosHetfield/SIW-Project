package model;

import java.io.Serializable;

public class Giocatore_in_rosa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3407932458575761624L;

	//riferimenti
	private Giocatore giocatore;
	private String nomeGiocatore;
	private String squadra;
	private boolean completo = false;
	private boolean rimosso = false;
	
	public Giocatore_in_rosa(String squadra, String nomeGiocatore) {
		this.squadra = squadra;
		this.nomeGiocatore = nomeGiocatore;
	}
	
	public Giocatore_in_rosa() {
		super();
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
	}

	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

	public boolean isRimosso() {
		return rimosso;
	}

	public void setRimosso(boolean rimosso) {
		this.rimosso = rimosso;
	}
}
