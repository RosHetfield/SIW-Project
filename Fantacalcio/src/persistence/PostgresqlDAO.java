package persistence;

import persistence.dao.CampionatoDAO;
import persistence.dao.CampionatoDAOJdbc;
import persistence.dao.GiocatoreDAO;
import persistence.dao.GiocatoreDAOJdbc;
import persistence.dao.Giocatore_in_formazioneDAO;
import persistence.dao.Giocatore_in_formazioneDAOJdbc;
import persistence.dao.Giocatore_in_rosaDAO;
import persistence.dao.Giocatore_in_rosaDAOJdbc;
import persistence.dao.InvitoDAO;
import persistence.dao.InvitoDAOJdbc;
import persistence.dao.PartitaDAO;
import persistence.dao.PartitaDAOJdbc;
import persistence.dao.SquadraDAO;
import persistence.dao.SquadraDAOJdbc;
import persistence.dao.UtenteDAO;
import persistence.dao.UtenteDAOJdbc;
import persistence.dao.Voto_giornataDAO;
import persistence.dao.Voto_giornataDAOJdbc;

public class PostgresqlDAO {
	DataSource dataSource;

	public PostgresqlDAO(String host, String port, String databaseName, String user, String password) {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			// questi vanno messi in file di configurazione!!!
			dataSource = new DataSource("jdbc:postgresql://" + host + ":" + port + "/" + databaseName, user, password);
		} catch (Exception e) {
			System.err.println("PostgresDAO.class: failed to load Postgres JDBC driver\n" + e);
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

	public UtenteDAO getUtenteDAO() {
		return new UtenteDAOJdbc(dataSource);
	}

	public Voto_giornataDAO getVoto_giornataDAO() {

		return new Voto_giornataDAOJdbc(dataSource);
	}

	public InvitoDAO getInvitoDAO() {
		return new InvitoDAOJdbc(dataSource);
	}

}
