package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into voto_giornata(giocatore, giornata, voto, fantavoto, goalFatto, goalSubito, goalSuRigore, rigoreParato, rigoreSbagliato, autorete, assist, ammonito, espulso, uscito, entrato, goalVittoria, goalPareggio) values (?,?,?,?,?)";
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
