package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Giocatore_in_formazione;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Giocatore_in_formazione gif) {
		// TODO Auto-generated method stub

	}

}
