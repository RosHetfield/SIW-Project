package persistence.dao;

import java.util.List;

import model.Giocatore;
import model.Giocatore_in_rosa;

public interface Giocatore_in_rosaDAO {
	public void save(Giocatore_in_rosa gir);  // Create
	public Giocatore_in_rosa findByPrimaryKey(String id);     // Retrieve
	public void update(Giocatore_in_rosa gir); //Update
	public void delete(Giocatore_in_rosa gir); //Delete	
	public List<Giocatore_in_rosa> findAll(); 
	public List<Giocatore> getGiocatoriInRosa(String squadra); //toliere
	public int n_giocatoriRuolo(String squadra, String ruolo);
	public void updateAll(String squadra, boolean completo);
	public boolean isSquadraCompleta(String squadra);
}
