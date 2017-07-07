package model;

public class Giocatore_in_formazione {

	private boolean titolare;
	private boolean entrato;
	private boolean uscito;
	private int n_formazione;

	// riferimenti

	private int giornata;
	private String campionato;
	private Giocatore_in_rosa giocatoreRosa;
	private String nomeGiocatoreRosa;
	private String squadraGiocatoreRosa;

	public Giocatore_in_formazione() {
		super();
	}

	public Giocatore_in_formazione(String nomeGiocatoreRosa, String squadraGiocatoreRosa, int giornata,
			String campionato, boolean titolare, boolean entrato, boolean uscito, int n_formazione) {
		super();
		this.giornata = giornata;
		this.campionato = campionato;
		this.titolare = titolare;
		this.entrato = entrato;
		this.uscito = uscito;
		this.n_formazione = n_formazione;
		this.nomeGiocatoreRosa = nomeGiocatoreRosa;
		this.squadraGiocatoreRosa = squadraGiocatoreRosa;
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

	public Giocatore_in_rosa getGiocatoreInRosa() {
		return giocatoreRosa;
	}

	public void setGiocatore(Giocatore_in_rosa giocatore) {
		this.giocatoreRosa = giocatore;
	}

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public String getCampionato() {
		return campionato;
	}

	public void setCampionato(String campionato) {
		this.campionato = campionato;
	}

	public String getNomeGiocatoreRosa() {
		return nomeGiocatoreRosa;
	}

	public void setNomeGiocatoreRosa(String nomeGiocatoreRosa) {
		this.nomeGiocatoreRosa = nomeGiocatoreRosa;
	}

	public String getSquadraGiocatoreRosa() {
		return squadraGiocatoreRosa;
	}

	public void setSquadraGiocatoreRosa(String squadraGiocatoreRosa) {
		this.squadraGiocatoreRosa = squadraGiocatoreRosa;
	}
}
