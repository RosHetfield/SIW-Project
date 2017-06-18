package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Campionato;
import model.CampionatoProxy;
import model.Invito;
import model.Utente;
import persistence.DataSource;

public class InvitoDAOJdbc implements InvitoDAO {
	
	private DataSource dataSource;
	
	public InvitoDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Invito invito) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into invito(utente, campionato) values (?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, invito.getUtente());
			statement.setString(2, invito.getCampionato());			
			
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
	public Invito findByUtente(String utente) {
		Invito invito = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from invito where utente = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, utente);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				
				invito = new Invito();
				invito.setUtente(result.getString("utente"));
				invito.setCampionato(result.getString("campionato"));
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

		return invito;	
	}

	@Override
	public List<Invito> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Invito> inviti = new LinkedList<Invito>();
		try {
			Invito invito;
			PreparedStatement statement;
			String query = "select * from invito";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				invito = new Invito();
				
				invito.setUtente(result.getString("utente"));
				invito.setCampionato(result.getString("campionato"));
				
				inviti.add(invito);
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
		return inviti;
	}

	@Override
	public void delete(Invito invito) {
		Connection connection = this.dataSource.getConnection();
		try {
			
			String insert = "delete from invito where utente = ?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, invito.getUtente());
			
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
	public Invito findByCampionato(String campionato) {
		Invito invito = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from invito where campionato = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, campionato);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				
				invito = new Invito();
				invito.setUtente(result.getString("utente"));
				invito.setCampionato(result.getString("campionato"));
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

		return invito;	
	}

}