package persistence.dao;

import java.util.List;

import model.Voto_giornata;
import persistence.DataSource;

public class Voto_giornataDAOJdbc implements Voto_giornataDAO {
	private DataSource dataSource;

	public Voto_giornataDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Voto_giornata voto_giornata) {
		// TODO Auto-generated method stub

	}

	@Override
	public Voto_giornata findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto_giornata> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto_giornata voto_giornata) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Voto_giornata voto_giornata) {
		// TODO Auto-generated method stub

	}

}
