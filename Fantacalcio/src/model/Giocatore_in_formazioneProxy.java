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
	
	public Giocatore_in_rosa getGiocatoreInRosa(DataSource dataSource) {
		if(!firstLoad) {
		 	Giocatore_in_rosa giocatore = null;
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select gir.squadra from giocatore_in_formazione as gif, giocatore_in_rosa as gir "
						+ "where gif.giocatore = gir.giocatore and gif.squadra = gir.squadra and gif.giornata = ? and gif.campionato = ?";
				statement = connection.prepareStatement(query);

				statement.setInt(1, getGiornata());
				statement.setString(2, getCampionato());

				ResultSet result = statement.executeQuery();
				if (result.next()) {
					giocatore = new Giocatore_in_rosaProxy(dataSource);
					giocatore.setSquadra(result.getString("squadra"));
					giocatore.getGiocatore();
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
			this.setGiocatore(giocatore);
			firstLoad = true;
		 }
		return super.getGiocatoreInRosa();
	}
}
