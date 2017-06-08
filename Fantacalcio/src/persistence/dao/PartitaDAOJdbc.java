package persistence.dao;

import java.util.List;

import model.Partita;
import persistence.DataSource;

public class PartitaDAOJdbc implements PartitaDAO {
	private DataSource dataSource;

	public PartitaDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int save(Partita partita) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Partita findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Partita partita) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Partita partita) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Partita> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
