package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Giocatore_in_rosa;
import persistence.DataSource;

public class Giocatore_in_rosaDAOJdbc implements Giocatore_in_rosaDAO {
	private DataSource dataSource;

	public Giocatore_in_rosaDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Giocatore_in_rosa gir) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into giocatore_in_rosa (squadra, giocatore) values (?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, gir.getSquadra().getNome());
			statement.setLong(2, gir.getGiocatore().getId());
						
			
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
			
		}
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
