package persistence.dao;


import java.util.List;

import model.Classifica;
import model.RisultatoGiornata;

public interface ClassificaDAO {
	
	public void save(Classifica classifica); 
	public Classifica findByPrimaryKey(int giornata, String squadra);
	public Classifica getUltimoRisultatoClassifica(int giornata, String squadra);
	public List<Classifica> getClassificaGiornata(int giornata, String campionato);   
	public RisultatoGiornata getRisultatoGiornata(int giornata, String squadra);
	public int getPartiteGiocate(String squadra);
	public void update(Classifica campionato); 
	public void delete(Classifica campionato);
	public List<RisultatoGiornata> getRisultatiSquadreGiornata(int giornata, String campionato); 	

}
