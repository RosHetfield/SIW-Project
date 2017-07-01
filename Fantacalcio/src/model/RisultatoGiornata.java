package model;

public class RisultatoGiornata {
	
	private int giornata;
	private String squadra;
	private String campionato;
	private double totale;
	
	public RisultatoGiornata() { }
	
	public RisultatoGiornata(int giornata, String squadra, String campionato, double totale) {
		this.giornata = giornata;
		this.squadra = squadra;
		this.campionato = campionato;
		this.totale = totale;
	}

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public String getCampionato() {
		return campionato;
	}

	public void setCampionato(String campionato) {
		this.campionato = campionato;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
	
	
}
