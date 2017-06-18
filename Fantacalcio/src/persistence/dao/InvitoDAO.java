package persistence.dao;

import java.util.List;

import model.Invito;

public interface InvitoDAO {
	
	public void save(Invito invito);  // Create
	public List<Invito> findByUtente(String utente);     // Retrieve
	public List<Invito> findByCampionato(String campionato);
	public List<Invito> findAll();       
	public void delete(Invito invito); //Delete	

}
