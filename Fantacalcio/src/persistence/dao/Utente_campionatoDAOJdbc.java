package persistence.dao;

import java.util.List;

import model.Utente_campionato;
import persistence.DataSource;

public class Utente_campionatoDAOJdbc implements Utente_campionatoDAO {
	private DataSource dataSource;

	public Utente_campionatoDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Utente_campionato uc) {
		// TODO Auto-generated method stub

	}

	@Override
	public Utente_campionato findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utente_campionato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente_campionato uc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Utente_campionato uc) {
		// TODO Auto-generated method stub

	}

}
