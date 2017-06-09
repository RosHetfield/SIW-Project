package persistence.dao;

import model.Giocatore;
import persistence.DBManager;
import persistence.PostgresqlDAO;

public class prova {

	public static void main(String[] args) {
		PostgresqlDAO sqlDAO = new PostgresqlDAO("horton.elephantsql.com", "xrfgprnz", "5432", "xrfgprnz", "ztrokF2S22uj8fpPDP6tj3nOFzt5dmr4");
		Giocatore giocatore = new Giocatore("mario", "fantoni", "messina", "a", 10);
		sqlDAO.getGiocatoreDAO().save(giocatore);
	}

}
