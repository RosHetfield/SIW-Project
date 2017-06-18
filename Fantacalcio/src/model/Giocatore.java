package model;

import java.io.Serializable;

public class Giocatore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 438982547485614742L;

	private Long id;
	private String nome;
	private String squadra;
	private String ruolo;
	private int valore;
	
	////riferimenti

	public Giocatore() {
		super();
	}

	public Giocatore(String nome, String squadra, String ruolo, int valore) {
		super();
		this.nome = nome;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.valore = valore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSquadra() {
		return squadra;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getValore() {
		return valore;
	}

	public void setValore(int valore) {
		this.valore = valore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
