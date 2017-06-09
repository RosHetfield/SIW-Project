package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		Connection connection = this.dataSource.getConnection();
		try {
			
			String insert ="insert into squadra(nome, utente, campionato, crediti) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
		/*	statement.setString(1, voto_giornata);
			statement.setString(2, voto_giornata);
			statement.setString(3, voto_giornata);
			statement.setString(4, voto_giornata);
			statement.setString(5, voto_giornata);
			statement.setString(6, voto_giornata);
			statement.setString(7, voto_giornata);
			statement.setString(8, voto_giornata);
			statement.setString(9, voto_giornata);
			statement.setString(10, voto_giornata);*/

		
		
			
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
