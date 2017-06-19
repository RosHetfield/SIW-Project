package persistence.dao;

import java.util.List;

import model.Squadra;
import model.Utente;

public interface UtenteDAO {
	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(String id);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	
	public List<String> getCampionati(String username);
	public Squadra getSquadraCampionato(String utente,String campionato); 
}
