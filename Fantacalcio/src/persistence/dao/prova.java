package persistence.dao;

import model.Utente;
import persistence.DBManager;
import persistence.DataSource;
import persistence.MySQLDAO;

public class prova {

	public static void main(String[] args) {
		MySQLDAO sqlDAO = new MySQLDAO("horton.elephantsql.com", "xrfgprnz", "5432", "xrfgprnz", "ztrokF2S22uj8fpPDP6tj3nOFzt5dmr4");

		String a=sqlDAO.getUtenteDAO().findByPrimaryKey("FC Peroni").getNome();
		System.out.println("################"+ a+"##################");
	}

}
