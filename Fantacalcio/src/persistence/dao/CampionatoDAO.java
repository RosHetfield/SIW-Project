package persistence.dao;

import java.util.List;

import model.Campionato;

public interface CampionatoDAO {
	public void save(Campionato campionato);  // Create
	public Campionato findByPrimaryKey(String id);     // Retrieve
	public List<Campionato> findAll();       
	public void update(Campionato campionato); //Update
	public void delete(Campionato campionato); //Delete	
	public List<String> partecipantiCampionato(String nomeCampionato);
	public List<String> possibiliGiocatoti(String nomeCampionato);

}
