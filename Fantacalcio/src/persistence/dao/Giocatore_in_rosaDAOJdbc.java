package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import model.Giocatore_in_rosa;
import model.Utente;
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
			statement.setString(1, gir.getSquadra());
			statement.setString(2, gir.getGiocatore().getNome());
						
			
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
		Connection connection = this.dataSource.getConnection();
		try {
			
			String insert = "delete from giocatore_in_rosa where squadra = ? and giocatore = ?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, gir.getSquadra());
			statement.setString(2, gir.getGiocatore().getNome());
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
	public List<Giocatore_in_rosa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Giocatore> getGiocatoriInRosa(String squadra) {
		Connection connection = this.dataSource.getConnection();
		List<Giocatore> giocatori= new ArrayList<Giocatore>();
		try {
			Giocatore giocatore;
			String query = "select g.nome, g.ruolo, g.valore, g.squadra from giocatore as g,giocatore_in_rosa as gf"
					+ " where  gf.squadra = ? and g.nome = gf.giocatore ";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, squadra);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				giocatore = new Giocatore();
				
				giocatore.setNome(result.getString("nome"));
				giocatore.setRuolo(result.getString("ruolo"));
				giocatore.setSquadra(result.getString("squadra"));
				giocatore.setValore(result.getInt("valore"));
				
				giocatori.add(giocatore);
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
		return giocatori;
		
	}

	@Override
	public int n_giocatoriRuolo(String squadra, String ruolo) {
		int count = 0;
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "select count(*) from giocatore_in_rosa as g, giocatore, squadra "
					+ "where g.squadra = squadra.nome and g.giocatore = giocatore.nome "
					+ "and giocatore.ruolo = ? and squadra.nome = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ruolo);
			statement.setString(2, squadra);
			System.out.println("CRISTO");
			ResultSet result = statement.executeQuery();
			System.out.println("CRISTO GESU");
			if (result.next()) {
				count = result.getInt("count");
				System.out.println("DIO");
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
		
		return count;
	}
	

}
