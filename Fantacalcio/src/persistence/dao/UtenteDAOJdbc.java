package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Utente;
import persistence.DataSource;

public class UtenteDAOJdbc implements UtenteDAO {
	private DataSource dataSource;

	public UtenteDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into utente(username, nome, cognome, email, password) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername() );
			statement.setString(2, utente.getNome());
			statement.setString(3, utente.getCognome());
			statement.setString(4, utente.getEmail());
			statement.setString(5, utente.getPassword());

			
			
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

	public Utente findByPrimaryKey(String id) {
		Utente utente = new Utente();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from utente where Username = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, id);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				utente.setUsername(result.getString("Username"));
				utente.setNome(result.getString("Nome"));
				utente.setCognome(result.getString("Cognome"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));

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

		return utente;	
		
	}

	public List<Utente> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Utente> utenti = new LinkedList<Utente>();
		try {
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				
				utente.setUsername(result.getString("Username"));
				utente.setNome(result.getString("Nome"));
				utente.setCognome(result.getString("Cognome"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));

				
				utenti.add(utente);
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
		return utenti;
	}

	public void update(Utente utente) {
	
	} 

	
	public void delete(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "delete from utente where username = ?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername() );

			
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
}
