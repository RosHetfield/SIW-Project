package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Campionato;
import model.CampionatoProxy;
import model.Invito;
import model.Utente;
import persistence.DBManager;
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
		Campionato campionato = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from campionato where nome = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, id);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				
				campionato = new CampionatoProxy(this.dataSource);
				campionato.setNome(result.getString("nome"));
				campionato.setPassword(result.getString("password"));
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

		return campionato;	
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

	@Override
	public Campionato partecipantiCampionato(String nomeCampionato) {
		Campionato campionato = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from campionato where nome = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, nomeCampionato);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				
				campionato = new CampionatoProxy(this.dataSource);
				campionato.setNome(result.getString("nome"));
				campionato.setPassword(result.getString("password"));
				
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

		return campionato;	
	}
	
//	select utente.* from utente, squadra where squadra.campionato = 'a'  and not exists (select s.utente from squadra as s, utente as u where s.utente = utente.username)

	@Override
	public List<Utente> possibiliGiocatori(String nomeCampionato) {
		List<Utente> utenti = new ArrayList<Utente>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select u.* from utente as u except select utente.* from utente, squadra where squadra.campionato = ? and utente.username = squadra.utente";
			statement = connection.prepareStatement(query);

			statement.setString(1, nomeCampionato);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Utente utente = new Utente();
				utente.setUsername(result.getString("Username"));
				utente.setNome(result.getString("Nome"));
				utente.setCognome(result.getString("Cognome"));
				utente.setEmail(result.getString("Email"));
				Invito invito = DBManager.getInstance().getInvito().findByUtenteCampionato(utente.getUsername(),nomeCampionato);
				if(invito != null) {
					
					utente.setInvito(true);
				}
				else {
					utente.setInvito(false);
				}
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


}
