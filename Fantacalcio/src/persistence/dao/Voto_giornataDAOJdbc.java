package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Voto_giornata;
import persistence.DataSource;

public class Voto_giornataDAOJdbc implements Voto_giornataDAO {
	private DataSource dataSource;

	public Voto_giornataDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Voto_giornata voto_giornata) {
		Connection connection = this.dataSource.getConnection();
		try {
			
			String insert ="insert into voto_giornata( giornata, giocatore, voto, fantavoto, gol_fatto, "
					+ "gol_rigore, gol_subito, rigore_parato, rigore_sbagliato, autorete, assist_totali, "
					+ "ammonito, espulso, entrato, uscito, gol_vittoria, gol_pareggio) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, voto_giornata.getGiornata());
			statement.setString(2, voto_giornata.getNomeGiocatore());
			statement.setDouble(3, voto_giornata.getVoto());
			statement.setDouble(4, voto_giornata.getFantavoto());
			statement.setInt(5, voto_giornata.getGoalFatto());
			statement.setInt(6, voto_giornata.getGoalSuRigore());
			statement.setInt(7, voto_giornata.getGoalSubito());
			statement.setInt(8, voto_giornata.getRigoreParato());
			statement.setInt(9, voto_giornata.getRigoreSbagliato());
			statement.setInt(10, voto_giornata.getAutorete());
			statement.setInt(11, voto_giornata.getAssist());
			statement.setInt(12, voto_giornata.getAmmonito());
			statement.setInt(13, voto_giornata.getEspulso());
			statement.setBoolean(14, voto_giornata.isEntrato());
			statement.setBoolean(15, voto_giornata.isUscito());
			statement.setInt(16, voto_giornata.getGoalVittoria());
			statement.setInt(17, voto_giornata.getGoalPareggio());
		
			
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
	public Voto_giornata findByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voto_giornata> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Voto_giornata voto_giornata) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Voto_giornata voto_giornata) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUltimaGiornata() {
		int giornata = -1;
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "select giornata from voto_giornata "
					+ "where giornata=(select max(giornata) from voto_giornata)";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				giornata = result.getInt("giornata");
			} else {
				giornata = 0;				
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
		
		return giornata;
	}

}
