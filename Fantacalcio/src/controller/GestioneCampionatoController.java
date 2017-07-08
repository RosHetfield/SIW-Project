package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Campionato;
import model.Invito;
import model.Partita;
import model.Squadra;
import model.Utente;
import persistence.DBManager;

/**
 * Servlet implementation class GestioneCampionatoController
 */
@WebServlet("/GestioneCampionatoController")
public class GestioneCampionatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneCampionatoController() {
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
		String campionato = (String) session.getAttribute("NomeCampionato");
		System.out.println(campionato);
		if (campionato != null) {
			
			Campionato camp=DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
			List<Utente> utenti = DBManager.getInstance().getCampionato().possibiliGiocatori(campionato);
			List<Invito> inviti = DBManager.getInstance().getInvito().findByCampionato(campionato);
			Partita partita = DBManager.getInstance().getPartita().getPartitaGiocabile(campionato);
			request.setAttribute("partita", partita);
			request.setAttribute("Campionato", camp);
			request.setAttribute("PossibiliPartecipanti", utenti);
			request.setAttribute("Inviti", inviti);
			System.out.println("addi cazz va");

			RequestDispatcher dispatcher = request.getRequestDispatcher("GestioneCampionato.jsp");
			dispatcher.forward(request, response);

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
		doGet(request, response);
	}

}
