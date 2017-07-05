package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Partita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5625289563782535476L;

	private int giornata;
	private Date data;
	
	//riferimenti
	private String campionato;
	private List<Giocatore_in_formazione> giocatori;
	private Set<Giocatore_in_formazione> giocatoriSquadra;
	
	public Partita() {
		super();
	}

	public Partita(int giornata, String campionato, Date data) {
		super();
		this.giornata = giornata;
		this.campionato = campionato;
		this.data=data;
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

	public List<Giocatore_in_formazione> getGiocatoriInFormazione() {
		return giocatori;
	}

	public void setGiocatoriInFormazione(List<Giocatore_in_formazione> giocatori) {
		this.giocatori = giocatori;
	}
	
	public void addGiocatoreInFormazione(Giocatore_in_formazione giocatore) {
		this.getGiocatoriInFormazione().add(giocatore);
	}
	
	public void removeGiocatoreInFormazione(Giocatore_in_formazione giocatore) {
		this.getGiocatoriInFormazione().add(giocatore);
	}

	public Set<Giocatore_in_formazione> getGiocatoriPerSquadra(String squadra) {
		return giocatoriSquadra;
	}

	public void setGiocatoriPerSquadra(Set<Giocatore_in_formazione> giocatori) {
//		if(!giocatoriSquadra.isEmpty()) {
//			this.giocatoriSquadra.clear();			
//		}
		this.giocatoriSquadra = giocatori;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
