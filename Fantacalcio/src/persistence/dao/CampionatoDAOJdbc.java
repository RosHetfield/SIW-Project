package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into campionato(nome, password) values (?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, campionato.getNome());
			statement.setString(2, campionato.getPassword());			
			
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
