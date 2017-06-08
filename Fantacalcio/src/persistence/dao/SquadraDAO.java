package persistence.dao;

import java.util.List;

import model.Squadra;

public interface SquadraDAO {
	public void save(Squadra squadra);  // Create
	public Squadra findByPrimaryKey(String id);     // Retrieve
	public List<Squadra> findAll();       
	public void update(Squadra squadra); //Update
	public void delete(Squadra squadra); //Delete	
}
