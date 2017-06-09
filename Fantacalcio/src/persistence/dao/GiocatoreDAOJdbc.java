package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Giocatore;
import persistence.DataSource;
import persistence.IdBroker;

public class GiocatoreDAOJdbc implements GiocatoreDAO {
	private DataSource dataSource;

	public GiocatoreDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Giocatore giocatore){
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			giocatore.setId(id);
			String insert = "insert into giocatore(id, nome, cognome, ruolo, squadra, valore)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, giocatore.getId());
			statement.setString(2, giocatore.getNome());
			statement.setString(3, giocatore.getCognome());
			statement.setString(4,giocatore.getRuolo());
			statement.setString(5, giocatore.getSquadra());
			statement.setInt(6, giocatore.getValore());
			
			
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
