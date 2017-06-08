package persistence;

import persistence.dao.CampionatoDAO;
import persistence.dao.GiocatoreDAO;
import persistence.dao.Giocatore_in_formazioneDAO;
import persistence.dao.Giocatore_in_rosaDAO;
import persistence.dao.PartitaDAO;
import persistence.dao.SquadraDAO;
import persistence.dao.UtenteDAO;
import persistence.dao.Utente_campionatoDAO;
import persistence.dao.Voto_giornataDAO;

public class DBManager {
	// Host: www.freesqldatabase.com
	// Database name: sql11154576
	// Database user: sql11154576    ??????????????
	// Database password: PsnjrjRPHw
	// Port number: 3306
	private static DBManager instance = null;

	private CampionatoDAO campionato;
	private Giocatore_in_formazioneDAO giocatore_in_formazioneDAO;
	private Giocatore_in_rosaDAO giocatore_in_rosaDAO;
	private GiocatoreDAO giocatore;
	private PartitaDAO partita;
	private SquadraDAO squadra;
	private Utente_campionatoDAO utente_campionato;
	private UtenteDAO utente;
	private Voto_giornataDAO voto_giornata;

	public static DBManager getInstance() {

		if (instance == null) {

			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() {
		//////////////////////////////////cambiare i param????
		MySQLDAO sqlDAO = new MySQLDAO("sql11.freesqldatabase.com", "sql11154576", "3306", "sql11154576", "PsnjrjRPHw");

		campionato = sqlDAO.getCampionatoDAO();
		giocatore_in_formazioneDAO = sqlDAO.getGiocatore_in_formazioneDAO();
		giocatore_in_rosaDAO = sqlDAO.getGiocatore_in_rosaDAO();
		giocatore = sqlDAO.getGiocatoreDAO();
		partita = sqlDAO.getPartitaDAO();
		squadra = sqlDAO.getSquadraDAO();
		utente_campionato = sqlDAO.getUtente_campionatoDAO();
		utente = sqlDAO.getUtenteDAO();
		voto_giornata = sqlDAO.getVoto_giornataDAO();

	}

	public CampionatoDAO getCampionato() {
		return campionato;
	}

	public Giocatore_in_formazioneDAO getGiocatore_in_formazioneDAO() {
		return giocatore_in_formazioneDAO;
	}

	public Giocatore_in_rosaDAO getGiocatore_in_rosaDAO() {
		return giocatore_in_rosaDAO;
	}

	public GiocatoreDAO getGiocatore() {
		return giocatore;
	}

	public PartitaDAO getPartita() {
		return partita;
	}

	public SquadraDAO getSquadra() {
		return squadra;
	}

	public Utente_campionatoDAO getUtente_campionato() {
		return utente_campionato;
	}

	public UtenteDAO getUtente() {
		return utente;
	}

	public Voto_giornataDAO getVoto_giornata() {
		return voto_giornata;
	}

}
