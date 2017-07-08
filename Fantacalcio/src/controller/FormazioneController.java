package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Campionato;
import model.Giocatore;
import model.Giocatore_in_formazione;
import model.Giocatore_in_rosa;
import model.Partita;
import model.Squadra;
import persistence.DBManager;

/**
 * Servlet implementation class FormazioneController
 */
@WebServlet("/FormazioneController")
public class FormazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormazioneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String) request.getSession().getAttribute("Username");

		if (username != null) {
			String campionato = (String) request.getSession().getAttribute("campionato");

			if (campionato != null) {

				String s = (String) request.getSession().getAttribute("squadra");
				Squadra squadra = DBManager.getInstance().getSquadra().findByPrimaryKey(s);
				Set<Giocatore_in_rosa> giocatori = squadra.getGiocatoriInRosa();
				List<Giocatore> giocatoriInRosa = new ArrayList<Giocatore>();

				for (Giocatore_in_rosa giocatore : giocatori) {
					if (!giocatore.isRimosso()) {
						giocatoriInRosa.add(giocatore.getGiocatore());
					}
				}
				giocatoriInRosa.sort(new Comparator<Giocatore>() {

					@Override
					public int compare(Giocatore o1, Giocatore o2) {
						return o2.getRuolo().compareTo(o1.getRuolo());
					}
				});

				Partita ultima = DBManager.getInstance().getPartita().getUltimaGiornataGiocabile(campionato);
				List<Giocatore> inFormazione = new ArrayList<Giocatore>();
				List<Giocatore> inPanchina = new ArrayList<Giocatore>();
				List<Giocatore> temp = new ArrayList<Giocatore>();
				for (Giocatore_in_formazione giocatore : ultima.getGiocatoriPerSquadra(s)) {
					if (giocatore.isTitolare()) {
						inFormazione.add(giocatore.getGiocatoreInRosa().getGiocatore());
					} else {
						inPanchina.add(giocatore.getGiocatoreInRosa().getGiocatore());
					}

					for (Giocatore g : giocatoriInRosa) {
						if (g.getNome().equals(giocatore.getGiocatoreInRosa().getGiocatore().getNome())) {
							temp.add(g);
						}
					}

				}
				for (Giocatore g : temp) {
					giocatoriInRosa.remove(g);
				}

				inFormazione.sort(new Comparator<Giocatore>() {

					@Override
					public int compare(Giocatore o1, Giocatore o2) {
						return o2.getRuolo().compareTo(o1.getRuolo());
					}
				});

				inPanchina.sort(new Comparator<Giocatore>() {

					@Override
					public int compare(Giocatore o1, Giocatore o2) {
						return o2.getRuolo().compareTo(o1.getRuolo());
					}
				});

				request.setAttribute("giocatoriInRosa", giocatoriInRosa);
				request.setAttribute("giocatoriInFormazione", inFormazione);
				request.setAttribute("giocatoriInPanchina", inPanchina);

				response.setContentType("text/html");
				RequestDispatcher dispatcher = request.getRequestDispatcher("formazione.jsp");
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("Username");
		response.setContentType("text/html");
		if (username != null) {
			String campionato = (String) request.getSession().getAttribute("campionato");
			String squadra = (String) request.getSession().getAttribute("squadra");
			if (campionato != null && squadra != null) {
				Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
				Partita giornata = DBManager.getInstance().getPartita().getUltimaGiornataGiocabile(campionato);

				if (!camp.isMercato()) {
					if (giornata != null && System.currentTimeMillis() < giornata.getData().getTime()) {
						request.getSession().setAttribute("giornata", giornata.getGiornata());
						if (DBManager.getInstance().getGiocatore_in_rosa().isSquadraCompleta(squadra)) {
							response.getWriter().print(0);
						} else {
							response.getWriter().print(3);
						}
					} else {
						response.getWriter().print(1);
					}
				} else {
					response.getWriter().print(2);
				}

			}

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
			dispatcher.forward(request, response);
		}
	}

}
