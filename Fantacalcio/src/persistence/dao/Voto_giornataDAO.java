package persistence.dao;

import java.util.List;

import model.Voto_giornata;

public interface Voto_giornataDAO {
	public void save(Voto_giornata voto_giornata);  // Create
	public Voto_giornata findByPrimaryKey(String id);     // Retrieve
	public List<Voto_giornata> findAll();       
	public void update(Voto_giornata voto_giornata); //Update
	public void delete(Voto_giornata voto_giornata); //Delete	
	public int getUltimaGiornata();
	public List<Voto_giornata> findByGiornata(int giornata, String campionato);
}
