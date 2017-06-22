package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Partita;
import model.PartitaProxy;
import model.Squadra;
import model.SquadraProxy;
import persistence.DataSource;

public class PartitaDAOJdbc implements PartitaDAO {
	private DataSource dataSource;

	public PartitaDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Partita partita) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into partita(giornata, campionato, \"aggiungiFormazione\") values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, partita.getGiornata());		
			statement.setString(2, partita.getCampionato());		
			statement.setBoolean(3, partita.isAggiungiFormazione());

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
	public Partita findByPrimaryKey(int giornata, String Campionato) {
		Partita partita = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from partita where giornata = ? and campionato = ?";
			statement = connection.prepareStatement(query);

			statement.setInt(1, giornata);
			statement.setString(2, Campionato);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				partita = new PartitaProxy(dataSource);
				partita.setGiornata(result.getInt("giornata"));
				partita.setAggiungiFormazione(result.getBoolean("aggiungiFormazione"));
//////////////////////////////////////////
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

		return partita;	
	}

	@Override
	public void update(Partita partita) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update partita set giornata = ?, campionato = ?, \"aggiungiFormazione\" = ? where giornata = ? "
					+ "and campionato = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, partita.getGiornata());
			statement.setString(2, partita.getCampionato());
			statement.setBoolean(3, partita.isAggiungiFormazione());			
			statement.setInt(4, partita.getGiornata());
			statement.setString(5, partita.getCampionato());
			

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
	public void delete(Partita partita) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Partita> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partita getPartitaGiocabile(String campionato) {
		Connection connection = this.dataSource.getConnection();
		Partita partita=null;
		try {
			PreparedStatement statement;
			String query = "select * from partita where \"aggiungiFormazione\"=true and campionato = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, campionato);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				partita=new Partita();
				partita.setAggiungiFormazione(result.getBoolean("aggiungiFormazione"));
				partita.setGiornata(result.getInt("giornata"));
				//////////////////
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

		return partita;	
	}

}
