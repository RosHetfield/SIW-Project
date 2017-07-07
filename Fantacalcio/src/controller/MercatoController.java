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

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Campionato;
import model.Giocatore;
import model.Giocatore_in_rosa;
import model.Squadra;
import persistence.DBManager;

/**
 * Servlet implementation class MercatoController
 */
@WebServlet("/MercatoController")
public class MercatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String ruolo = "P";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MercatoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doPost(request, response);
		response.setContentType("text/html");

		String username = (String) request.getSession().getAttribute("Username");

		if (username != null) {
			String campionato = (String) request.getSession().getAttribute("campionato");

			if (campionato != null) {
				Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
				if (camp.isMercato()) {

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

					if (request.getParameterNames() != null) {
						String jsRuolo = (String) request.getParameter("ruolo");
						if (jsRuolo != null) {
							ObjectMapper mapper = new ObjectMapper();
							ruolo = mapper.readValue(jsRuolo, String.class);
						}
					}

					List<Giocatore> giocatoriSvincolati = DBManager.getInstance().getGiocatore()
							.getGiocatoriSvincolati(s, ruolo);
					request.setAttribute("giocatoriSvincolati", giocatoriSvincolati);
					request.setAttribute("giocatoriInRosa", giocatoriInRosa);
					request.setAttribute("crediti", squadra.getCrediti());

					RequestDispatcher dispatcher = request.getRequestDispatcher("mercato.jsp");
					dispatcher.forward(request, response);

				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("404.html");
					dispatcher.forward(request, response);
				}

			}

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
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

			if (campionato != null) {
				Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
				if (camp.isMercato()) {
					response.getWriter().print(0);

				} else {
					response.getWriter().print(1);
				}

			}

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
			dispatcher.forward(request, response);
		}
	}

}
