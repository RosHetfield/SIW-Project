package model;

import java.io.Serializable;

public class Voto_giornata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5845907666812671831L;

	private int giornata;
	private double voto;
	private double fantavoto;
	private int goalFatto;
	private int goalSubito;
	private int goalSuRigore;
	private int rigoreParato;
	private int rigoreSbagliato;
	private int autorete;
	private int assist;
	private int ammonito;
	private int espulso;
	private boolean uscito;
	private boolean entrato;
	private int goalVittoria;
	private int goalPareggio;
	private String nomeGiocatore;
	
	//riferimenti
	private Giocatore giocatore;

	public Voto_giornata(String nomeGiocatore, int giornata, double voto,double fantavoto, int goalFatto, int goalSubito, int goalSuRigore, int rigoreParato,
			int rigoreSbagliato, int autorete, int assist, int ammonito, int espulso, boolean uscito,
			boolean entrato, int goalVittoria, int goalPareggio) {
		super();
		this.nomeGiocatore = nomeGiocatore;
		this.giornata = giornata;
		this.voto = voto;
		this.fantavoto = fantavoto;
		this.goalFatto = goalFatto;
		this.goalSubito = goalSubito;
		this.goalSuRigore = goalSuRigore;
		this.rigoreParato = rigoreParato;
		this.rigoreSbagliato = rigoreSbagliato;
		this.autorete = autorete;
		this.assist = assist;
		this.ammonito = ammonito;
		this.espulso = espulso;
		this.uscito = uscito;
		this.entrato = entrato;
		this.goalVittoria = goalVittoria;
		this.goalPareggio = goalPareggio;
	}

	public Voto_giornata() {
		super();
		this.giocatore = new Giocatore();
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public int getGiornata() {
		return giornata;
	}

	public void setGiornata(int giornata) {
		this.giornata = giornata;
	}

	public double getVoto() {
		return voto;
	}

	public void setVoto(double voto) {
		this.voto = voto;
	}

	public double getFantavoto() {
		return fantavoto;
	}

	public void setFantavoto(double fantavoto) {
		this.fantavoto = fantavoto;
	}
	
	public int getGoalFatto() {
		return goalFatto;
	}

	public void setGoalFatto(int goalFatto) {
		this.goalFatto = goalFatto;
	}

	public int getGoalSubito() {
		return goalSubito;
	}

	public void setGoalSubito(int goalSubito) {
		this.goalSubito = goalSubito;
	}

	public int getGoalSuRigore() {
		return goalSuRigore;
	}

	public void setGoalSuRigore(int goalSuRigore) {
		this.goalSuRigore = goalSuRigore;
	}

	public int getRigoreParato() {
		return rigoreParato;
	}

	public void setRigoreParato(int rigoreParato) {
		this.rigoreParato = rigoreParato;
	}

	public int getRigoreSbagliato() {
		return rigoreSbagliato;
	}

	public void setRigoreSbagliato(int rigoreSbagliato) {
		this.rigoreSbagliato = rigoreSbagliato;
	}

	public int getAutorete() {
		return autorete;
	}

	public void setAutorete(int autorete) {
		this.autorete = autorete;
	}

	public int getAssist() {
		return assist;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	public int getAmmonito() {
		return ammonito;
	}

	public void setAmmonito(int ammonito) {
		this.ammonito = ammonito;
	}

	public int getEspulso() {
		return espulso;
	}

	public void setEspulso(int espulso) {
		this.espulso = espulso;
	}

	public boolean isUscito() {
		return uscito;
	}

	public void setUscito(boolean uscito) {
		this.uscito = uscito;
	}

	public boolean isEntrato() {
		return entrato;
	}

	public void setEntrato(boolean entrato) {
		this.entrato = entrato;
	}

	public int getGoalVittoria() {
		return goalVittoria;
	}

	public void setGoalVittoria(int goalVittoria) {
		this.goalVittoria = goalVittoria;
	}

	public int getGoalPareggio() {
		return goalPareggio;
	}

	public void setGoalPareggio(int goalPareggio) {
		this.goalPareggio = goalPareggio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNomeGiocatore() {
		return nomeGiocatore;
	}

	public void setNomeGiocatore(String nomeGiocatore) {
		this.nomeGiocatore = nomeGiocatore;
	}

}
