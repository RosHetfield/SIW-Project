package model;

import java.io.Serializable;

public class Giocatore_in_rosa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3407932458575761624L;

	//riferimenti
	private String giocatore;
	private String squadra;
	
	public Giocatore_in_rosa(String giocatore, String squadra) {
		this.giocatore = giocatore;
		this.squadra = squadra;
	}
	
	public Giocatore_in_rosa() {
		super();
	}

	public String getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(String giocatore) {
		this.giocatore = giocatore;
	}

	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}
}
