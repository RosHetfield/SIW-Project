package persistence.dao;

import java.util.List;

import model.Partita;

public interface PartitaDAO {
	public int save(Partita partita);  // Create
	public Partita findByPrimaryKey(Long id);     // Retrieve
	public void update(Partita partita); //Update
	public void delete(Partita partita); //Delete	
	public List<Partita> findAll(); 
}
