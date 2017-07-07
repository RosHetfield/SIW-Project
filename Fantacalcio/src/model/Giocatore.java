package model;

public class Giocatore {

	private String nome;
	private String squadra;
	private String ruolo;
	private int valore;

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

}
