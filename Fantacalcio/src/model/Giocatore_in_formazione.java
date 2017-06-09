package model;

import java.io.Serializable;

public class Giocatore_in_formazione implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -694460871283042157L;
	
	private boolean titolare;
	private boolean entrato;
	private boolean uscito;
	private int n_formazione;
	
	//riferimenti
	
	private Partita partita;
	private Giocatore_in_rosa giocatore;
	
	public Giocatore_in_formazione() {
		super();
		this.partita = new Partita();
		this.giocatore = new Giocatore_in_rosa();
	}

	public Giocatore_in_formazione(boolean titolare, boolean entrato, boolean uscito, int n_formazione) {
		super();
		this.titolare = titolare;
		this.entrato = entrato;
		this.uscito = uscito;
		this.n_formazione = n_formazione;
		this.partita = new Partita();
		this.giocatore = new Giocatore_in_rosa();
	}

	public boolean isTitolare() {
		return titolare;
	}

	public void setTitolare(boolean titolare) {
		this.titolare = titolare;
	}

	public boolean isEntrato() {
		return entrato;
	}

	public void setEntrato(boolean entrato) {
		this.entrato = entrato;
	}

	public boolean isUscito() {
		return uscito;
	}

	public void setUscito(boolean uscito) {
		this.uscito = uscito;
	}

	public int getN_formazione() {
		return n_formazione;
	}

	public void setN_formazione(int n_formazione) {
		this.n_formazione = n_formazione;
	}

	public Partita getPartita() {
		return partita;
	}

	public void setPartita(Partita partita) {
		this.partita = partita;
	}

	public Giocatore_in_rosa getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore_in_rosa giocatore) {
		this.giocatore = giocatore;
	}
}
