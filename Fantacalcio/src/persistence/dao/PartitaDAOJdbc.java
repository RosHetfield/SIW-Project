package persistence.dao;

import java.sql.Connection;
import java.sql.Date;
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
			String insert = "insert into partita(giornata, campionato, data) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, partita.getGiornata());		
			statement.setString(2, partita.getCampionato());
			long secs = partita.getData().getTime();
			statement.setDate(3, new Date(secs));

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
				partita.setCampionato(result.getString("campionato"));
				long secs = result.getDate("data").getTime();
				partita.setData(new java.util.Date(secs));
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
			String update = "update partita set giornata = ?, campionato = ?, data = ? where giornata = ? "
					+ "and campionato = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, partita.getGiornata());
			statement.setString(2, partita.getCampionato());
			
			long secs = partita.getData().getTime();
			statement.setDate(3, new Date(secs));

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
////		Connection connection = this.dataSource.getConnection();
		Partita partita=null;
//		try {
//			PreparedStatement statement;
//			String query = "select * from partita where \"aggiungiFormazione\"=true and campionato = ?";
//			statement = connection.prepareStatement(query);
//			statement.setString(1, campionato);
//
//			ResultSet result = statement.executeQuery();
//
//			if (result.next()) {
//				partita=new Partita();
//				partita.setAggiungiFormazione(result.getBoolean("aggiungiFormazione"));
//				partita.setGiornata(result.getInt("giornata"));
//				//////////////////
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e.getMessage());
//		} finally {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//
		return partita;	
	}

	@Override
	public Partita getUltimaGiornataGiocabile(String campionato) {
		Connection connection = this.dataSource.getConnection();
		Partita partita = null;
		try {
			PreparedStatement statement;
			String query = "select * from partita where campionato = ? and "
					+ "not exists(select * from voto_giornata as v where v.giornata = partita.giornata)";
			statement = connection.prepareStatement(query);
			statement.setString(1, campionato);

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				partita = new PartitaProxy(dataSource);
				partita.setCampionato(result.getString("campionato"));
				long secs = result.getDate("data").getTime();
				partita.setData(new java.util.Date(secs));
				partita.setGiornata(result.getInt("giornata"));
				System.out.println("la partita numero: "+partita.getGiornata());
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
	public Partita getUltimaCalcolata(String campionato) {
		Connection connection = this.dataSource.getConnection();
		Partita partita = null;
		try {
			PreparedStatement statement;
			String query = "select p.* from partita as p, voto_giornata as v where p.campionato = ? and  v.giornata = p.giornata and "
					+ "p.giornata = (select max(giornata) from voto_giornata)";
			statement = connection.prepareStatement(query);
			statement.setString(1, campionato);

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				partita = new PartitaProxy(dataSource);
				partita.setCampionato(result.getString("campionato"));
				long secs = result.getDate("data").getTime();
				partita.setData(new java.util.Date(secs));
				partita.setGiornata(result.getInt("giornata"));
				System.out.println("la partita numero: "+partita.getGiornata());
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
