package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import persistence.DataSource;

public class CampionatoProxy extends Campionato {

	private DataSource dataSource;
	private boolean firstLoad = false;

	public CampionatoProxy(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Set<Squadra> getSquadre() {
		if (!firstLoad) {
			Set<Squadra> s = new HashSet<Squadra>();
			Connection connection = this.dataSource.getConnection();
			try {
				PreparedStatement statement;
				String query = "select * from squadra where campionato = ?";
				statement = connection.prepareStatement(query);

				statement.setString(1, getNome());

				ResultSet result = statement.executeQuery();
				while (result.next()) {
					Squadra squadra = new SquadraProxy(this.dataSource);
					squadra.setNome(result.getString("Nome"));
					// Utente utente = squadra.getUtente();//togliere
					// squadra.setUtente(utente);
					squadra.setCrediti(result.getInt("Crediti"));

					s.add(squadra);
				}
				this.setSquadre(s);
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
		return super.getSquadre();

	}

}
