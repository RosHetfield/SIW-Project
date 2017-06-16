package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Campionato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2476245844517669726L;
	
	String nome;
	String password;
	// riferimenti
	
	private Set<Squadra> squadre;
	private Set<Partita> partite;
	
	public Campionato(String nome, String password) {
		super();
		this.nome = nome;
		this.password = password;
		this.squadre = new HashSet<Squadra>();
		this.partite = new HashSet<Partita>();
	}

	public Campionato() {
		super();
		//this.squadre = new HashSet<Squadra>();
		//this.partite = new HashSet<Partita>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Squadra> getSquadre() {
		return squadre;
	}

	public void setSquadre(Set<Squadra> squadre) {
		this.squadre = squadre;
	}

	public Set<Partita> getPartite() {
		return partite;
	}

	public void setPartite(Set<Partita> partite) {
		this.partite = partite;
	}
	
	public void addSquadra(Squadra squadra) {
		this.getSquadre().add(squadra);
	}
	
	public void removeSquadra(Squadra squadra) {
		this.getSquadre().remove(squadra);
	}
	
	public void removePartita(Partita partita) {
		this.getPartite().remove(partita);
	}
	
	public void addPartita(Partita partita) {
		this.getPartite().add(partita);
	}

}
