package persistence;

import persistence.dao.CampionatoDAO;
import persistence.dao.GiocatoreDAO;
import persistence.dao.Giocatore_in_formazioneDAO;
import persistence.dao.Giocatore_in_rosaDAO;
import persistence.dao.InvitoDAO;
import persistence.dao.PartitaDAO;
import persistence.dao.SquadraDAO;
import persistence.dao.UtenteDAO;
import persistence.dao.Voto_giornataDAO;

public class DBManager {
	// Host: horton.elephantsql.com
	// Database name: xrfgprnz
	// Database user: xrfgprnz    
	// Database password: ztrokF2S22uj8fpPDP6tj3nOFzt5dmr4
	// Port number: 5432
	private static DBManager instance = null;

	private CampionatoDAO campionato;
	private Giocatore_in_formazioneDAO giocatore_in_formazioneDAO;
	private Giocatore_in_rosaDAO giocatore_in_rosaDAO;
	private GiocatoreDAO giocatore;
	private PartitaDAO partita;
	private SquadraDAO squadra;
	private UtenteDAO utente;
	private Voto_giornataDAO voto_giornata;
	private InvitoDAO invito;

	public static DBManager getInstance() {

		if (instance == null) {

			instance = new DBManager();
		}
		return instance;
	}

	private DBManager() {
	
		PostgresqlDAO sqlDAO = new PostgresqlDAO("horton.elephantsql.com",  "5432", "xrfgprnz","xrfgprnz", "ztrokF2S22uj8fpPDP6tj3nOFzt5dmr4");
//		PostgresqlDAO sqlDAO = new PostgresqlDAO("localhost", "5432","fantacalcio",  "postgres", "admin");
		campionato = sqlDAO.getCampionatoDAO();
		giocatore_in_formazioneDAO = sqlDAO.getGiocatore_in_formazioneDAO();
		giocatore_in_rosaDAO = sqlDAO.getGiocatore_in_rosaDAO();
		giocatore = sqlDAO.getGiocatoreDAO();
		partita = sqlDAO.getPartitaDAO();
		squadra = sqlDAO.getSquadraDAO();
		utente = sqlDAO.getUtenteDAO();
		voto_giornata = sqlDAO.getVoto_giornataDAO();
		invito=sqlDAO.getInvitoDAO();

	}

	public CampionatoDAO getCampionato() {
		return campionato;
	}

	public Giocatore_in_formazioneDAO getGiocatore_in_formazione() {
		return giocatore_in_formazioneDAO;
	}

	public Giocatore_in_rosaDAO getGiocatore_in_rosa() {
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

	public UtenteDAO getUtente() {
		return utente;
	}

	public Voto_giornataDAO getVoto_giornata() {
		return voto_giornata;
	}

	public InvitoDAO getInvito() {
		return invito;
	}

}
