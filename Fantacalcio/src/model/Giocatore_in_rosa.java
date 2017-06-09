package model;

import java.io.Serializable;

public class Giocatore_in_rosa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3407932458575761624L;

	//riferimenti
	private Giocatore giocatore;
	private Squadra squadra;
	
	public Giocatore_in_rosa() {
		super();
		this.giocatore = new Giocatore();
		this.squadra = new Squadra();
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
}
