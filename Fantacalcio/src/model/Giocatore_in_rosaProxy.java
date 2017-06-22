package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.DataSource;

public class Giocatore_in_rosaProxy extends Giocatore_in_rosa {
	
	private DataSource dataSource;
	private boolean firstLoad = false;
	
	public Giocatore_in_rosaProxy(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Giocatore getGiocatore() {
		if(!firstLoad) {
		 	Giocatore giocatore = null;
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select giocatore.* from giocatore, giocatore_in_rosa as gir "
						+ "where gir.squadra = ? and gir.giocatore=giocatore.nome and gir.giocatore = ?";
				statement = connection.prepareStatement(query);

				statement.setString(1, getSquadra());
				statement.setString(2, getNomeGiocatore());

				ResultSet result = statement.executeQuery();
				if (result.next()) {
					giocatore = new Giocatore();
					giocatore.setNome(result.getString("nome"));
					giocatore.setSquadra(result.getString("squadra"));
					giocatore.setRuolo(result.getString("ruolo"));
					giocatore.setValore(result.getInt("valore"));
					System.out.println("GIOCATORE ROSA " + result.getString("nome") + " "+ result.getString("ruolo"));
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
		return super.getGiocatore();
	}
}
