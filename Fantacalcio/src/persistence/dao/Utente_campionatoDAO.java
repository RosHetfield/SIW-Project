package persistence.dao;

import java.util.List;

import model.Utente_campionato;


public interface Utente_campionatoDAO {
	public void save(Utente_campionato uc);  // Create
	public Utente_campionato findByPrimaryKey(String id);     // Retrieve
	public List<Utente_campionato> findAll();       
	public void update(Utente_campionato uc); //Update
	public void delete(Utente_campionato uc); //Delete	
}
