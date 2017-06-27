package persistence.dao;

import java.util.List;

import model.Giocatore_in_formazione;

public interface Giocatore_in_formazioneDAO {
	public void save(Giocatore_in_formazione gif);  // Create
	public Giocatore_in_formazione findByPrimaryKey(String id);     // Retrieve
	public Giocatore_in_formazione findByPrimaryKey(int giornata, String campionato, String squadra); 
	public List<Giocatore_in_formazione> findAll();       
	public void update(Giocatore_in_formazione gif); //Update
	public void delete(Giocatore_in_formazione gif); //Delete	
}

