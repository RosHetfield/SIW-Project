package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import persistence.DBManager;
import persistence.DataSource;

public class CampionatoProxy extends Campionato {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6322010376829951188L;
	 private DataSource dataSource;
	 
	 
	 public CampionatoProxy(DataSource dataSource) {
		 this.dataSource=dataSource;
	}
	 
	 public Set<Squadra> getSquadre(){
		 
		 Set<Squadra> s= new HashSet<Squadra>();
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select * from squadra where campionato = ?";
				statement = connection.prepareStatement(query);

				statement.setString(1, getNome());

				ResultSet result = statement.executeQuery();
				while (result.next()) {
					Squadra squadra= new SquadraProxy(this.dataSource);
					squadra.setNome(result.getString("Nome"));
					Utente utente = squadra.getUtente();
					System.out.println("UTENDIIII " + utente.username + " " + utente.nome + " "+ utente.cognome);
					squadra.setUtente(utente);
					squadra.setCrediti(result.getInt("Crediti"));

					s.add(squadra);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
			this.setSquadre(s);
			return super.getSquadre();
		 
	 }
	 
	 
}
