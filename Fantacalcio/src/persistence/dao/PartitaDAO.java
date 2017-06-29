package persistence.dao;

import java.util.List;

import model.Partita;

public interface PartitaDAO {
	public void save(Partita partita);  // Create
	public Partita findByPrimaryKey(int giornata, String campionato);     // Retrieve
	public void update(Partita partita); //Update
	public void delete(Partita partita); //Delete	
	public List<Partita> findAll();
	public Partita getPartitaGiocabile(String campionato);
	public int getUltimaGiornata(String campionato); 
}
