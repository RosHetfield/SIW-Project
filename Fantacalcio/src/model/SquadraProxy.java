package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import persistence.DataSource;

public class SquadraProxy extends Squadra {
	private DataSource dataSource;
	private boolean firstLoadUtente = false;
	private boolean firstLoadCampionato = false;
	 
	 
	 public SquadraProxy(DataSource dataSource) {
		 this.dataSource=dataSource;
	}
	 
	 public Utente getUtente() {
		 if(!firstLoadUtente) {
		 	Utente utente = null;
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select utente.* from utente, squadra where squadra.nome = ? and utente.username=squadra.utente";
				statement = connection.prepareStatement(query);

				statement.setString(1, getNome());

				ResultSet result = statement.executeQuery();
				if (result.next()) {
					utente = new Utente();
					utente.setUsername(result.getString("Username"));
					utente.setNome(result.getString("Nome"));
					utente.setCognome(result.getString("Cognome"));
					utente.setEmail(result.getString("Email"));
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
			this.setUtente(utente);
			firstLoadUtente = true;
		 }
		return super.getUtente();
	 }
	 
	 public Campionato getCampionato() {
		 if(!firstLoadCampionato) {
		 	Campionato campionato = null;
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select campionato.* from campionato, squadra where squadra.nome = ? and campionato.nome=squadra.campionato";
				statement = connection.prepareStatement(query);

				statement.setString(1, getNome());

				ResultSet result = statement.executeQuery();
				if (result.next()) {
					campionato = new Campionato();
					campionato.setNome(result.getString("Nome"));
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
			this.setCampionato(campionato);
			firstLoadCampionato = true;
		 }
		return super.getCampionato();
	 }
	 

}
