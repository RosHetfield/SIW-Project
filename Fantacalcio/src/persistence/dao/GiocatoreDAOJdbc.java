package persistence.dao;

import java.util.List;

import model.Giocatore;
import persistence.DataSource;

public class GiocatoreDAOJdbc implements GiocatoreDAO {
	private DataSource dataSource;

	public GiocatoreDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int save(Giocatore giocatore) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Giocatore findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Giocatore giocatore) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Giocatore giocatore) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Giocatore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
