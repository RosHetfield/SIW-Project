package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			String insert = "insert into utente(username, nome, cognome, email, password, facebook_id) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername() );
			statement.setString(2, utente.getNome());
			statement.setString(3, utente.getCognome());
			statement.setString(4, utente.getEmail());
			statement.setString(5, utente.getPassword());
			statement.setInt(6, utente.getFacebook_id());
			
			
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
			String query = "select * from utente where username = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, id);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				utente.setUsername(result.getString("username"));
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
				utente.setFacebook_id(result.getInt("facebook_id"));
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
				
				utente.setUsername(result.getString("username"));
				utente.setNome(result.getString("nome"));
				utente.setCognome(result.getString("cognome"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
				utente.setFacebook_id(result.getInt("facebook_id"));
				
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

	@Override
	public List<String> getCampionati(String username) {
		List<String> campionati= new ArrayList<String>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select campionato from squadra where utente = ? ";
			statement = connection.prepareStatement(query);

			statement.setString(1, username);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String u=result.getString("Campionato");
			
				campionati.add(u);

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

		return campionati;	
	}

	@Override
	public String getSquadraCampionato(String utente, String campionato) {
		String squadra = new String();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select nome, crediti from squadra where utente= ? and campionato= ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, utente);
			statement.setString(2, campionato);


			ResultSet result = statement.executeQuery();

			if (result.next()) {				
				
				squadra=result.getString("nome");
	
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
}
