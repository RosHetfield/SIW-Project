package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Giocatore_in_formazione;
import persistence.DBManager;

/**
 * Servlet implementation class SalvaFormazioneController
 */
@WebServlet("/SalvaFormazioneController")
public class SalvaFormazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvaFormazioneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			response.setContentType("text/html");

			String username = (String) request.getSession().getAttribute("Username");

			if (username != null) {
				String campionato = (String) request.getSession().getAttribute("campionato");
				String squadra = (String) request.getSession().getAttribute("squadra");
				int giornata = (int) request.getSession().getAttribute("giornata");

				String jsFormazione = request.getParameter("formazioneJson");
				String jsPanchina = request.getParameter("panchinaJson");

				ObjectMapper mapper = new ObjectMapper();
				String[] formazione = (String[]) mapper.readValue(jsFormazione, String[].class);
				String[] panchina = (String[]) mapper.readValue(jsPanchina, String[].class);

				DBManager.getInstance().getGiocatore_in_formazione().deleteFormazione(giornata, campionato, squadra);

				creaFormazione(giornata, campionato, formazione, panchina, squadra);

			}
		}
	}

	private void creaFormazione(int giornata, String campionato, String[] formazione, String[] panchina,
			String squadra) {
		int n_formazione = 1;
		for (String giocatore : formazione) {
			Giocatore_in_formazione gif = new Giocatore_in_formazione();
			gif.setGiornata(giornata);
			gif.setCampionato(campionato);
			gif.setNomeGiocatoreRosa(giocatore);
			gif.setSquadraGiocatoreRosa(squadra);
			gif.setTitolare(true);
			gif.setN_formazione(n_formazione);
			n_formazione++;
			DBManager.getInstance().getGiocatore_in_formazione().save(gif);
		}
		for (String giocatore : panchina) {
			Giocatore_in_formazione gif = new Giocatore_in_formazione();
			gif.setGiornata(giornata);
			gif.setCampionato(campionato);
			gif.setNomeGiocatoreRosa(giocatore);
			gif.setSquadraGiocatoreRosa(squadra);
			gif.setTitolare(false);
			gif.setN_formazione(n_formazione);
			n_formazione++;
			DBManager.getInstance().getGiocatore_in_formazione().save(gif);
		}
	}

}
