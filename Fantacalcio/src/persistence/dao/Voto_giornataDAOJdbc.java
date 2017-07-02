package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Utente;
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

			String insert = "insert into voto_giornata( giornata, giocatore, voto, fantavoto, gol_fatto, "
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

	@Override
	public List<Voto_giornata> findByGiornata(int giornata, String campionato) {
		Connection connection = this.dataSource.getConnection();
		List<Voto_giornata> voti_giornata = new ArrayList<Voto_giornata>();
		try {
			Voto_giornata voto_giornata;
			PreparedStatement statement;
			String query = "select * from giocatore_in_formazione as gf LEFT OUTER JOIN voto_giornata as vg "
					+ "ON (gf.giocatore = vg.giocatore and vg.giornata=? and gf.campionato=? "
					+ "and gf.giornata=vg.giornata) ";
			statement = connection.prepareStatement(query);
			statement.setInt(1, giornata);
			statement.setString(2, campionato);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				voto_giornata = new Voto_giornata();

				voto_giornata.setGiornata(result.getInt("giornata"));
				voto_giornata.setNomeGiocatore(result.getString("giocatore"));			
				voto_giornata.setVoto(result.getDouble("voto"));
				voto_giornata.setFantavoto(result.getDouble("fantaVoto"));
				voto_giornata.setGoalFatto(result.getInt("gol_fatto"));
				voto_giornata.setGoalSuRigore(result.getInt("gol_rigore"));
				voto_giornata.setGoalSubito(result.getInt("gol_subito"));
				voto_giornata.setRigoreParato(result.getInt("rigore_parato"));
				voto_giornata.setRigoreSbagliato(result.getInt("rigore_sbagliato"));
				voto_giornata.setAutorete(result.getInt("autorete"));
				voto_giornata.setAssist(result.getInt("assist_totali"));
				voto_giornata.setAmmonito(result.getInt("ammonito"));
				voto_giornata.setEspulso(result.getInt("espulso"));
				voto_giornata.setGoalVittoria(result.getInt("gol_vittoria"));
				voto_giornata.setGoalPareggio(result.getInt("gol_pareggio"));

				
				voti_giornata.add(voto_giornata);
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
		return voti_giornata;
	}

}
