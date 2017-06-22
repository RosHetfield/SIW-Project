package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import persistence.DataSource;

public class PartitaProxy extends Partita {
	
	private DataSource dataSource;
	private boolean firstLoad = false;
	
	public PartitaProxy(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Set<Giocatore_in_formazione> getGiocatoriInFormazione(){
		 if(!firstLoad) {
			Set<Giocatore_in_formazione> giocatori = new HashSet<Giocatore_in_formazione>();
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select p.giornata, p.campionato from partita as p, giocatore_in_formazione as gif "
						+ "where p.giornata = gif.giornata and p.campionato = gif.campionato and p.giornata = ? and p.campionato = ?";
				statement = connection.prepareStatement(query);

				statement.setInt(1, getGiornata());
				statement.setString(2, getCampionato());

				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					Giocatore_in_formazione giocatore = new Giocatore_in_formazioneProxy(dataSource);
					giocatore.setGiornata(result.getInt("giornata"));
					giocatore.setCampionato(result.getString("campionato"));
					giocatore.getGiocatoreInRosa();
					
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
			this.setGiocatoriInFormazione(giocatori);
			firstLoad = true;
		 }
		return super.getGiocatoriInFormazione();
		 
	 }
}
