package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.DataSource;

public class Giocatore_in_formazioneProxy extends Giocatore_in_formazione {

	private DataSource dataSource;
	private boolean firstLoad = false;

	public Giocatore_in_formazioneProxy(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Giocatore_in_rosa getGiocatoreInRosa() {
		if (!firstLoad) {
			Giocatore_in_rosa giocatore = null;
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select gir.* from giocatore_in_formazione as gif, giocatore_in_rosa as gir "
						+ "where gif.giocatore = gir.giocatore and gif.squadra = gir.squadra and gif.giornata = ? and gif.campionato = ? and gif.giocatore = ? and gif.squadra = ?";
				statement = connection.prepareStatement(query);

				statement.setInt(1, getGiornata());
				statement.setString(2, getCampionato());
				statement.setString(3, getNomeGiocatoreRosa());
				statement.setString(4, getSquadraGiocatoreRosa());

				ResultSet result = statement.executeQuery();
				if (result.next()) {
					giocatore = new Giocatore_in_rosaProxy(dataSource);
					giocatore.setSquadra(result.getString("squadra"));
					giocatore.setNomeGiocatore(result.getString("giocatore"));
				}
				this.setGiocatore(giocatore);
				firstLoad = true;
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
		return super.getGiocatoreInRosa();
	}
}
