package persistence.dao;

import java.util.List;

import model.Campionato;
import model.Utente;

public interface CampionatoDAO {
	public void save(Campionato campionato);  // Create
	public Campionato findByPrimaryKey(String id);     // Retrieve
	public List<Campionato> findAll();       
	public void update(Campionato campionato); //Update
	public void delete(Campionato campionato); //Delete	
	public Campionato partecipantiCampionato(String nomeCampionato);
	public List<Utente> possibiliGiocatori(String nomeCampionato);

}
