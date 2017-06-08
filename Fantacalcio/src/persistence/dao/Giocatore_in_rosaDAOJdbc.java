package persistence.dao;

import java.util.List;

import model.Giocatore_in_rosa;
import persistence.DataSource;

public class Giocatore_in_rosaDAOJdbc implements Giocatore_in_rosaDAO {
	private DataSource dataSource;

	public Giocatore_in_rosaDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int save(Giocatore_in_rosa gir) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Giocatore_in_rosa findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Giocatore_in_rosa gir) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Giocatore_in_rosa gir) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Giocatore_in_rosa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
