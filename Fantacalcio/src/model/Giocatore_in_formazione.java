package model;

import java.io.Serializable;

public class Giocatore_in_formazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -694460871283042157L;
	
	//riferimenti//////////ci vanno gli objects??
	int giornata;
	String campionato;
	String squadra;
	Long giocatore;
	
	public Giocatore_in_formazione() {
		super();
	}
}
