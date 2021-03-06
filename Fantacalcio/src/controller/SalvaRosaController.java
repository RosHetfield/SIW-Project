package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.DBManager;

/**
 * Servlet implementation class SalvaRosaController
 */
@WebServlet("/SalvaRosaController")
public class SalvaRosaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvaRosaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String username = (String) request.getSession().getAttribute("Username");
		if (username != null) {

			String campionato = (String) request.getSession().getAttribute("campionato");
			String squadra = (String) request.getSession().getAttribute("squadra");

			if (campionato != null && squadra != null) {
				boolean completa = isCompleta(squadra);
				if (completa) {
					DBManager.getInstance().getGiocatore_in_rosa().updateAll(squadra, completa);
					response.getWriter().println(0);
				} else {
					response.getWriter().println(1);
				}
			}
		}
	}

	private boolean isCompleta(String squadra) {
		if ((DBManager.getInstance().getGiocatore_in_rosa().n_giocatoriRuolo(squadra, "P")) < 3) {
			return false;
		}
		if ((DBManager.getInstance().getGiocatore_in_rosa().n_giocatoriRuolo(squadra, "D")) < 8) {
			return false;
		}
		if ((DBManager.getInstance().getGiocatore_in_rosa().n_giocatoriRuolo(squadra, "C")) < 8) {
			return false;
		}
		if ((DBManager.getInstance().getGiocatore_in_rosa().n_giocatoriRuolo(squadra, "A")) < 6) {
			return false;
		}
		return true;
	}

}
