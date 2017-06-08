package model;

import java.io.Serializable;

public class Voto_giornata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5845907666812671831L;

	int giornata;
	double voto;
	double fantavoto;
	int goalFatto;
	int goalSubito;
	int goalSuRigore;
	int rigoreParato;
	int rigoreSbagliato;
	int autorete;
	int assist;
	boolean ammonito;
	boolean espulso;
	boolean uscito;
	boolean entrato;
	boolean goalVittoria;
	boolean goalPareggio;
	
	//riferimenti
	int giocatore;

	




	public Voto_giornata(int giornata, double voto,double fantavoto, int goalFatto, int goalSubito, int goalSuRigore, int rigoreParato,
			int rigoreSbagliato, int autorete, int assist, boolean ammonito, boolean espulso, boolean uscito,
			boolean entrato, boolean goalVittoria, boolean goalPareggio) {
		super();
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

	public boolean isAmmonito() {
		return ammonito;
	}

	public void setAmmonito(boolean ammonito) {
		this.ammonito = ammonito;
	}

	public boolean isEspulso() {
		return espulso;
	}

	public void setEspulso(boolean espulso) {
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

	public boolean isGoalVittoria() {
		return goalVittoria;
	}

	public void setGoalVittoria(boolean goalVittoria) {
		this.goalVittoria = goalVittoria;
	}

	public boolean isGoalPareggio() {
		return goalPareggio;
	}

	public void setGoalPareggio(boolean goalPareggio) {
		this.goalPareggio = goalPareggio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
