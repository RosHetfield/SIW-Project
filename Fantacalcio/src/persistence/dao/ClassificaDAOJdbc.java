package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Campionato;
import model.CampionatoProxy;
import model.Classifica;
import model.RisultatoGiornata;
import persistence.DataSource;

public class ClassificaDAOJdbc implements ClassificaDAO {
	
	private DataSource dataSource;
	
	public ClassificaDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Classifica classifica) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into classifica(squadra, campionato, partite_giocate, giornate, totale) "
					+ "values (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, classifica.getSquadra());
			statement.setString(2, classifica.getCampionato());
			statement.setInt(3, classifica.getPartite_giocate());
			statement.setInt(4, classifica.getGiornata());
			statement.setDouble(5, classifica.getTotale());
			
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
	public Classifica findByPrimaryKey(int giornata, String squadra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Classifica getUltimoRisultatoClassifica(String squadra) {
		Classifica classifica = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from classifica "
					+ "where giornata = (select max(giornata) from classifica where squadra = ?)";
			statement = connection.prepareStatement(query);

			statement.setString(1, squadra);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				classifica = new Classifica();
				classifica.setSquadra(result.getString("squadra"));
				classifica.setCampionato(result.getString("campionato"));
				classifica.setGiornata(result.getInt("giornata"));
				classifica.setPartite_giocate(result.getInt("partite_giocate"));
				classifica.setTotale(result.getDouble("totale"));
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

		return classifica;	
	}

	@Override
	public List<Classifica> getClassificaGiornata(int giornata, String campionato) {
		List<Classifica> classifica = new ArrayList<Classifica>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from classifica where giornata = ? and campionato = ?";
			statement = connection.prepareStatement(query);

			statement.setInt(1, giornata);
			statement.setString(2, campionato);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				Classifica c = new Classifica();
				c.setSquadra(result.getString("squadra"));
				c.setCampionato(result.getString("campionato"));
				c.setGiornata(result.getInt("giornata"));
				c.setPartite_giocate(result.getInt("partite_giocate"));
				c.setTotale(result.getDouble("totale"));
				classifica.add(c);
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

		return classifica;	
	}

	@Override
	public RisultatoGiornata getRisultatoGiornata(int giornata, String squadra) {
		RisultatoGiornata risultato = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from giornata_squadra where giornata = ? and squadra = ?";
			statement = connection.prepareStatement(query);

			statement.setInt(1, giornata);
			statement.setString(2, squadra);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				risultato = new RisultatoGiornata();
				risultato.setCampionato(result.getString("campionato"));
				risultato.setGiornata(result.getInt("giornata"));
				risultato.setSquadra(result.getString("squadra"));
				risultato.setTotale(result.getDouble("totale"));
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

		return risultato;	
	}

	@Override
	public void update(Classifica campionato) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Classifica campionato) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPartiteGiocate(String squadra) {
		int partite_giocate = 0;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select count(*) as partite_giocate from giornata_squadra where squadra = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, squadra);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				partite_giocate = result.getInt("partite_giocate");
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

		return partite_giocate;	
	}

}
