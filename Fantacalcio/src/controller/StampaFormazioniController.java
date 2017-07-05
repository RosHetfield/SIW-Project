package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Giocatore;
import model.Giocatore_in_formazione;
import model.Partita;
import model.Squadra;
import persistence.DBManager;

/**
 * Servlet implementation class StampaFormazioniController
 */
@WebServlet("/StampaFormazioniController")
public class StampaFormazioniController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StampaFormazioniController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String utente = (String) session.getAttribute("Username");
		if (utente != null) {
			response.setContentType("text/html");
			String campionato = (String) session.getAttribute("campionato");
			String squadra = (String) request.getSession().getAttribute("squadra");
			if (campionato != null && squadra != null) {

				// restituisco l'ultima giornata creata e nella quale possone
				// essere presenti formazioni
				Partita giornata = DBManager.getInstance().getPartita().getUltimaGiornataGiocabile(campionato);
				// Partita partita =
				// DBManager.getInstance().getPartita().findByPrimaryKey(giornata.getGiornata(),
				// campionato);
				Set<Squadra> squadreCampionato = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato)
						.getSquadre();
				request.setAttribute("ultimaGiornata", -1);
				List<Giocatore_in_formazione> giocatori = new ArrayList<Giocatore_in_formazione>();
				if (giornata != null) {

					giocatori = giornata.getGiocatoriInFormazione();
					giocatori.sort(new Comparator<Giocatore_in_formazione>() {

						@Override
						public int compare(Giocatore_in_formazione o1, Giocatore_in_formazione o2) {
							return o2.getGiocatoreInRosa().getGiocatore().getRuolo()
									.compareTo(o1.getGiocatoreInRosa().getGiocatore().getRuolo());
						}
					});
					
					request.setAttribute("ultimaGiornata", giornata.getGiornata());

				}

				request.setAttribute("giocatoriUltima", giocatori);
				request.setAttribute("squadreCampionato", squadreCampionato);

				RequestDispatcher dispatcher = request.getRequestDispatcher("stampaFormazioni.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
