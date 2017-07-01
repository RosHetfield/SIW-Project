package model;

public class Classifica {

	private String squadra;
	private int giornata;
	private int partite_giocate;
	private String campionato;
	private double totale;
	
	public Classifica() { }
	
	public Classifica(String squadra, int giornata, int partite_giocate, String campionato, double totale) {
		this.squadra = squadra;
		this.giornata = giornata;
		this.partite_giocate = partite_giocate;
		this.campionato = campionato;
		this.totale = totale;
	}

	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public int getPartite_giocate() {
		return partite_giocate;
	}

	public void setPartite_giocate(int partite_giocate) {
		this.partite_giocate = partite_giocate;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public String getCampionato() {
		return campionato;
	}

	public void setCampionato(String campionato) {
		this.campionato = campionato;
	}
	
}
