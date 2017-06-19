package persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import model.Utente;
import persistence.DataSource;
import persistence.IdBroker;

public class GiocatoreDAOJdbc implements GiocatoreDAO {
	private DataSource dataSource;

	public GiocatoreDAOJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Giocatore giocatore) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			giocatore.setId(id);
			String insert = "insert into giocatore(id, nome, ruolo, squadra, valore)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, giocatore.getId());
			statement.setString(2, giocatore.getNome());
			statement.setString(4, giocatore.getRuolo());
			statement.setString(5, giocatore.getSquadra());
			statement.setInt(6, giocatore.getValore());

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
	public Giocatore findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Giocatore giocatore) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Giocatore giocatore) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Giocatore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Giocatore> getGiocatoreRuolo(String squadra, String ruolo) {
		Connection connection = this.dataSource.getConnection();
		List<Giocatore> giocatori = new ArrayList<Giocatore>();
		try {
			Giocatore giocatore;
			PreparedStatement statement;
			String query = "select g.id, g.nome, g.ruolo, g.squadra,g.valore from giocatore as g  where g.ruolo= ? and not exists"
					+ " (select gio.giocatore from giocatore_in_rosa as gio"
					+ " where gio.squadra = ? and g.id=gio.giocatore ) ";

			statement = connection.prepareStatement(query);
			statement.setString(1, squadra);
			statement.setString(2, ruolo);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				giocatore = new Giocatore();

				giocatore.setId(result.getLong("Id"));
				giocatore.setNome(result.getString("Nome"));
				giocatore.setRuolo(result.getString("Ruolo"));
				giocatore.setSquadra(result.getString("Squadra"));
				giocatore.setValore(result.getInt("Valore"));

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
}
