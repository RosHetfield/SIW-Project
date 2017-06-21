package persistence.dao;

import java.util.List;

import model.Giocatore;

public interface GiocatoreDAO {
	public void save(Giocatore giocatore);  // Create
	public Giocatore findByPrimaryKey(String id);     // Retrieve
	public void update(Giocatore giocatore); //Update
	public void delete(Giocatore giocatore); //Delete	
	public List<Giocatore> findAll(); 
	public List<Giocatore> getGiocatoreRuolo(String Squadra,String ruolo);
	public List<Giocatore> getGiocatoriSvincolati(String squadra);
	
}
