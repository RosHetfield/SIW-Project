package persistence.dao;

import java.util.List;

import model.Giocatore;

public interface GiocatoreDAO {
	public int save(Giocatore giocatore);  // Create
	public Giocatore findByPrimaryKey(Long id);     // Retrieve
	public void update(Giocatore giocatore); //Update
	public void delete(Giocatore giocatore); //Delete	
	public List<Giocatore> findAll(); 
}
