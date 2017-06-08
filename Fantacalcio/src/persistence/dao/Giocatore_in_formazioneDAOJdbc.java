package persistence.dao;

import java.util.List;

import model.Giocatore_in_formazione;
import persistence.DataSource;

public class Giocatore_in_formazioneDAOJdbc implements Giocatore_in_formazioneDAO {
	private DataSource dataSource;

	public Giocatore_in_formazioneDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Giocatore_in_formazione gif) {
		// TODO Auto-generated method stub

	}

	@Override
	public Giocatore_in_formazione findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Giocatore_in_formazione> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Giocatore_in_formazione gif) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Giocatore_in_formazione gif) {
		// TODO Auto-generated method stub

	}

}
