package persistence.dao;

import java.util.List;

import model.Squadra;
import persistence.DataSource;

public class SquadraDAOJdbc implements SquadraDAO {
	private DataSource dataSource;

	public SquadraDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Squadra squadra) {
		// TODO Auto-generated method stub

	}

	@Override
	public Squadra findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Squadra> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Squadra squadra) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Squadra squadra) {
		// TODO Auto-generated method stub

	}

}
