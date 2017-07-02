package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Giocatore_in_formazione;
import model.Utente;
import persistence.DataSource;

public class Giocatore_in_formazioneDAOJdbc implements Giocatore_in_formazioneDAO {
	private DataSource dataSource;

	public Giocatore_in_formazioneDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Giocatore_in_formazione gif) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "INSERT INTO giocatore_in_formazione(giornata, campionato, squadra, giocatore, "
					+ "titolare, entrato, uscito, n_formazione) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, gif.getGiornata());
			statement.setString(2, gif.getCampionato());
			statement.setString(3, gif.getSquadraGiocatoreRosa());
			statement.setString(4, gif.getNomeGiocatoreRosa());
			statement.setBoolean(5, gif.isTitolare());
			statement.setBoolean(6, gif.isEntrato());
			statement.setBoolean(7, gif.isUscito());
			statement.setInt(8, gif.getN_formazione());

			
			
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
	public Giocatore_in_formazione findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Giocatore_in_formazione> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Giocatore_in_formazione gif) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update giocatore_in_formazione set giornata = ?, campionato = ?, giocatore = ?, squadra = ?, "
					+ "titolare = ?, entrato = ?, uscito = ?, n_formazione = ? where giornata = ? and campionato = ? and "
					+ " squadra = ? and giocatore=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, gif.getGiornata());
			statement.setString(2, gif.getCampionato());			
			statement.setString(3, gif.getNomeGiocatoreRosa());
			statement.setString(4, gif.getSquadraGiocatoreRosa());
			statement.setBoolean(5, gif.isTitolare());
			statement.setBoolean(6, gif.isEntrato());
			statement.setBoolean(7, gif.isUscito());
			statement.setInt(8, gif.getN_formazione());
			statement.setInt(9, gif.getGiornata());
			statement.setString(10, gif.getCampionato());			
			statement.setString(11, gif.getSquadraGiocatoreRosa());
			statement.setString(12, gif.getNomeGiocatoreRosa());
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
	public void deleteFormazione(int giornata, String campionato, String squadra) {
		Connection connection = this.dataSource.getConnection();
		try {
			
			String delete = "delete from giocatore_in_formazione where giornata = ? and campionato = ? and squadra = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, giornata);
			statement.setString(2, campionato);
			statement.setString(3, squadra);
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

	@Override//modificare??
	public Giocatore_in_formazione findByPrimaryKey(int giornata, String campionato, String giocatore, String squadra) {
		Giocatore_in_formazione gif = new Giocatore_in_formazione();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from giocatore_in_formazione where giornata = ? and campionato = ? and squadra = ? and giocatore = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, giornata);
			statement.setString(2, campionato);
			statement.setString(3, squadra);
			statement.setString(4, giocatore);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				gif.setGiornata(result.getInt("giornata"));
				gif.setCampionato(result.getString("campionato"));
				gif.setNomeGiocatoreRosa(result.getString("giocatore"));
				gif.setSquadraGiocatoreRosa(result.getString("squadra"));
				//aggiungere altri campi
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

		return gif;	

	}

}
