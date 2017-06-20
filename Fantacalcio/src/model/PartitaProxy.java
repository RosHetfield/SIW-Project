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
	private boolean firstLoadGiocatori = false;
	private boolean firstLoadCampionato = false;
	
	public PartitaProxy(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Set<Giocatore_in_formazione> getGiocatori(){
		 if(!firstLoadGiocatori) {
		 Set<Giocatore_in_formazione> s = new HashSet<Giocatore_in_formazione>();
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select * from giocatore_in_formazione where partita = ?";
				statement = connection.prepareStatement(query);

				statement.setInt(1, getGiornata());

				ResultSet result = statement.executeQuery();
				
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			this.setGiocatori(s);
			firstLoadGiocatori = true;
		 }
		return super.getGiocatori();
		 
	 }
}
