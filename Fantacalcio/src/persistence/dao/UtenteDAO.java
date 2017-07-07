package persistence.dao;

import java.util.List;

import model.Utente;

public interface UtenteDAO {
	public void save(Utente utente);  
	public Utente findByPrimaryKey(String id);    
	public List<Utente> findAll();       
	public void update(Utente utente); 
	public void delete(Utente utente);
	public List<String> getCampionati(String username);
	public String getSquadraCampionato(String utente,String campionato); 
}
