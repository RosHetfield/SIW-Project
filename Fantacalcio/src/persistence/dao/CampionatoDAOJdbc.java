package persistence.dao;

import java.util.List;

import model.Campionato;
import persistence.DataSource;

public class CampionatoDAOJdbc implements CampionatoDAO {
	private DataSource dataSource;

	public CampionatoDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Campionato campionato) {
		// TODO Auto-generated method stub

	}

	@Override
	public Campionato findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campionato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Campionato campionato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Campionato campionato) {
		// TODO Auto-generated method stub

	}

}
