package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Campionato;
import model.Invito;
import model.Squadra;
import model.Utente;
import persistence.DBManager;

/**
 * Servlet implementation class InvitiController
 */
@WebServlet("/InvitiController")
public class InvitiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvitiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// if (request.getParameterNames().hasMoreElements()) {
		// String jsInvito = (String) request.getParameter("invito");
		// String jsRisposta = (String) request.getParameter("risposta");
		response.setContentType("text/html");
		// if (jsRisposta != null && jsInvito != null) {

		String username = (String) request.getSession().getAttribute("Username");

		if (username != null) {
			List<Invito> result = DBManager.getInstance().getInvito().findByUtente(username);

			request.setAttribute("Inviti", result);
			request.setAttribute("CampionatiUtente",
					(List<String>) request.getSession().getAttribute("CampionatiUtente"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("Inviti.jsp");
			dispatcher.forward(request, response);

		}

		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
			dispatcher.forward(request, response);
		}
		// }
		// }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			String jsInvito = (String) request.getParameter("invito");
			String jsRisposta = (String) request.getParameter("risposta");
			response.setContentType("text/html");
			if (jsRisposta != null && jsInvito != null) {

				String username = (String) request.getSession().getAttribute("Username");

				if (username != null) {
					ObjectMapper mapper = new ObjectMapper();

					Invito invito = (Invito) mapper.readValue(jsInvito, Invito.class);
					String risposta = (String) mapper.readValue(jsRisposta, String.class);
					if (risposta.equals("r")) {
						DBManager.getInstance().getInvito().delete(invito);
					} else if (risposta.equals("a")) {
						String jsSquadra = (String) request.getParameter("squadra");
						String squadra = (String) mapper.readValue(jsSquadra, String.class);
						if (creaSquadra(invito, squadra)) {
							response.getWriter().print(0);
							DBManager.getInstance().getInvito().delete(invito);
						} else {
							response.getWriter().print(1);
						}
					}

					List<Invito> result = DBManager.getInstance().getInvito().findByUtente(username);

					request.setAttribute("Inviti", result);
					request.setAttribute("CampionatiUtente",
							(List<String>) request.getSession().getAttribute("CampionatiUtente"));

				}

				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
	}

	private boolean creaSquadra(Invito invito, String squadra) {
		if (DBManager.getInstance().getSquadra().findByPrimaryKey(squadra) != null) {
			return false;
		}
		Utente utente = DBManager.getInstance().getUtente().findByPrimaryKey(invito.getUtente());
		Campionato campionato = DBManager.getInstance().getCampionato().findByPrimaryKey(invito.getCampionato());
		Squadra s = new Squadra();
		s.setNome(squadra);
		s.setUtente(utente);
		s.setCampionato(campionato);
		s.setCrediti(300);
		DBManager.getInstance().getSquadra().save(s);
		return true;
	}

}
