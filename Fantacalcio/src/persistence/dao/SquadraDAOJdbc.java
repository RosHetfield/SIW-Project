package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Squadra;
import model.SquadraProxy;
import model.Utente;
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
			statement.setString(1, squadra.getNome());
			statement.setString(2, squadra.getUtente().getUsername());
			statement.setString(3, squadra.getCampionato().getNome());
			statement.setInt(4, squadra.getCrediti());		
		
			
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
		Squadra squadra = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from squadra where nome = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, id);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				squadra = new SquadraProxy(dataSource);
				squadra.setNome(result.getString("nome"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return squadra;	
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
