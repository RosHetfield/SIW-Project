package persistence;

import persistence.dao.CampionatoDAO;
import persistence.dao.CampionatoDAOJdbc;
import persistence.dao.GiocatoreDAO;
import persistence.dao.GiocatoreDAOJdbc;
import persistence.dao.Giocatore_in_formazioneDAO;
import persistence.dao.Giocatore_in_formazioneDAOJdbc;
import persistence.dao.Giocatore_in_rosaDAO;
import persistence.dao.Giocatore_in_rosaDAOJdbc;
import persistence.dao.PartitaDAO;
import persistence.dao.PartitaDAOJdbc;
import persistence.dao.SquadraDAO;
import persistence.dao.SquadraDAOJdbc;
import persistence.dao.UtenteDAO;
import persistence.dao.UtenteDAOJdbc;
import persistence.dao.Utente_campionatoDAO;
import persistence.dao.Utente_campionatoDAOJdbc;
import persistence.dao.Voto_giornataDAO;
import persistence.dao.Voto_giornataDAOJdbc;

public class MySQLDAO {
	DataSource dataSource;

	public MySQLDAO(String host, String databaseName, String port, String user, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// questi vanno messi in file di configurazione!!!
			dataSource = new DataSource("jdbc:mysql://" + host + ":" + port + "/" + databaseName, user, password);
		} catch (Exception e) {
			System.err.println("MYSQLDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}

	public CampionatoDAO getCampionatoDAO() {
		return new CampionatoDAOJdbc(dataSource);
	}

	public Giocatore_in_formazioneDAO getGiocatore_in_formazioneDAO() {//
		return new Giocatore_in_formazioneDAOJdbc(dataSource);
	}

	public Giocatore_in_rosaDAO getGiocatore_in_rosaDAO() {
		return new Giocatore_in_rosaDAOJdbc(dataSource);
	}

	public GiocatoreDAO getGiocatoreDAO() {
		return new GiocatoreDAOJdbc(dataSource);
	}

	public PartitaDAO getPartitaDAO() {
		return new PartitaDAOJdbc(dataSource);
	}

	public SquadraDAO getSquadraDAO() {
		return new SquadraDAOJdbc(dataSource);
	}

	public Utente_campionatoDAO getUtente_campionatoDAO() {
		return new Utente_campionatoDAOJdbc(dataSource);
	}

	public UtenteDAO getUtenteDAO() {
		return new UtenteDAOJdbc(dataSource);
	}

	public Voto_giornataDAO getVoto_giornataDAO() {

		return new Voto_giornataDAOJdbc(dataSource);
	}

}
