package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import model.Giocatore_in_rosa;
import model.Utente;
import persistence.DataSource;

public class Giocatore_in_rosaDAOJdbc implements Giocatore_in_rosaDAO {
	private DataSource dataSource;

	public Giocatore_in_rosaDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Giocatore_in_rosa gir) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into giocatore_in_rosa (squadra, giocatore, completo, rimosso) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, gir.getSquadra());
			statement.setString(2, gir.getNomeGiocatore());
			statement.setBoolean(3, gir.isCompleto());
			statement.setBoolean(4, gir.isRimosso());
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
	public Giocatore_in_rosa findByPrimaryKey(String giocatore, String squadra) {
		Giocatore_in_rosa g = null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from giocatore_in_rosa where giocatore = ? and squadra = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, giocatore);
			statement.setString(2, squadra);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				g = new Giocatore_in_rosa();
				g.setNomeGiocatore(result.getString("giocatore"));
				g.setSquadra(result.getString("squadra"));
				g.setCompleto(result.getBoolean("completo"));
				g.setRimosso(result.getBoolean("rimosso"));

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

		return g;	
	
	}

	@Override
	public void update(Giocatore_in_rosa gir) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update giocatore_in_rosa set squadra = ?, giocatore = ?, completo = ?, rimosso = ? "
					+ "where squadra = ? and giocatore = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, gir.getSquadra());
			statement.setString(2, gir.getNomeGiocatore());			
			statement.setBoolean(3, gir.isCompleto());
			statement.setBoolean(4, gir.isRimosso());
			statement.setString(5, gir.getSquadra());
			statement.setString(6, gir.getNomeGiocatore());
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
	public void delete(Giocatore_in_rosa gir) {
		Connection connection = this.dataSource.getConnection();
		try {
			
			String insert = "delete from giocatore_in_rosa where squadra = ? and giocatore = ?";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, gir.getSquadra());
			statement.setString(2, gir.getNomeGiocatore());
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
	public List<Giocatore_in_rosa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //TOLIERE
	public List<Giocatore> getGiocatoriInRosa(String squadra) {
		Connection connection = this.dataSource.getConnection();
		List<Giocatore> giocatori= new ArrayList<Giocatore>();
		try {
			Giocatore giocatore;
			String query = "select g.nome, g.ruolo, g.valore, g.squadra from giocatore as g,giocatore_in_rosa as gf"
					+ " where  gf.squadra = ? and g.nome = gf.giocatore order by g.ruolo desc";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, squadra);
			
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				giocatore = new Giocatore();
				
				giocatore.setNome(result.getString("nome"));
				giocatore.setRuolo(result.getString("ruolo"));
				giocatore.setSquadra(result.getString("squadra"));
				giocatore.setValore(result.getInt("valore"));
				
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
		return giocatori;
		
	}

	@Override
	public int n_giocatoriRuolo(String squadra, String ruolo) {
		int count = 0;
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "select count(*) from giocatore_in_rosa as g, giocatore, squadra "
					+ "where g.squadra = squadra.nome and g.giocatore = giocatore.nome "
					+ "and giocatore.ruolo = ? and squadra.nome = ? and g.rimosso=false";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, ruolo);
			statement.setString(2, squadra);
			System.out.println("CRISTO");
			ResultSet result = statement.executeQuery();
			System.out.println("CRISTO GESU");
			if (result.next()) {
				count = result.getInt("count");
				System.out.println("DIO");
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
		
		return count;
	}
	
	

	@Override
	public void updateAll(String squadra, boolean completo) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update giocatore_in_rosa set completo = ? where squadra = ? ";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setBoolean(1, completo);			
			statement.setString(2, squadra);
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
	public boolean isSquadraCompleta(String squadra) {
		boolean completa = false;
		Connection connection = this.dataSource.getConnection();
		try {
			String query = "select distinct completo from giocatore_in_rosa where squadra = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, squadra);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				completa = result.getBoolean("completo");
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
		return completa;
	}
	

}
