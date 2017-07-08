package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Giocatore;
import model.Giocatore_in_rosa;
import model.Squadra;
import persistence.DBManager;

/**
 * Servlet implementation class GestioneMercato
 */
@WebServlet("/GestioneMercatoController")
public class GestioneMercatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestioneMercatoController() {
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

				if (campionato != null && squadra != null) {

					Squadra s = DBManager.getInstance().getSquadra().findByPrimaryKey(squadra);
					String jsGiocatore = request.getParameter("giocatore");
					String jsRisposta = request.getParameter("risposta");
					// if jsRisposta & jsGiocatore != null??
					ObjectMapper mapper = new ObjectMapper();
					String giocatore = (String) mapper.readValue(jsGiocatore, String.class);
					String risposta = (String) mapper.readValue(jsRisposta, String.class);
					Giocatore g = DBManager.getInstance().getGiocatore().findByPrimaryKey(giocatore);
					JSONObject jsRes = new JSONObject();
					try {
						if (risposta.equals("t")) {
							int res = inserisciInRosa(s, g);
							jsRes.put("status", res);
							jsRes.put("crediti", s.getCrediti());
							response.getWriter().print(jsRes);
						} else if (risposta.equals("f")) {
							jsRes.put("status", rimuoviDaRosa(s, g));
							jsRes.put("crediti", s.getCrediti());
							response.getWriter().print(jsRes);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
					
				}else{
					RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
					dispatcher.forward(request, response);
				}

			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	private int inserisciInRosa(Squadra squadra, Giocatore giocatore) {
		if ((squadra.getCrediti() - giocatore.getValore()) < 0) {
			return 1;
		}
		int cont_ruolo = DBManager.getInstance().getGiocatore_in_rosa().n_giocatoriRuolo(squadra.getNome(),
				giocatore.getRuolo());
		switch (giocatore.getRuolo()) {
		case "P": {
			if (cont_ruolo == 3)
				return 2;
			break;
		}
		case "D": {
			if (cont_ruolo == 8)
				return 3;
			break;
		}
		case "C": {
			if (cont_ruolo == 8)
				return 4;
			break;
		}
		case "A": {
			if (cont_ruolo == 6)
				return 5;
			break;
		}
		}
		// inserire contrololo??????
		Giocatore_in_rosa gir = new Giocatore_in_rosa();
		gir.setNomeGiocatore(giocatore.getNome());
		gir.setSquadra(squadra.getNome());
		squadra.setCrediti(squadra.getCrediti() - giocatore.getValore());
		if (DBManager.getInstance().getGiocatore_in_rosa().findByPrimaryKey(giocatore.getNome(),
				squadra.getNome()) != null) {
			gir.setRimosso(false);
			DBManager.getInstance().getGiocatore_in_rosa().update(gir);
		} else {
			DBManager.getInstance().getGiocatore_in_rosa().save(gir);
		}
		DBManager.getInstance().getSquadra().update(squadra);
		return 0;
	}

	private int rimuoviDaRosa(Squadra squadra, Giocatore giocatore) {
		Giocatore_in_rosa gir = new Giocatore_in_rosa();
		gir.setNomeGiocatore(giocatore.getNome());
		gir.setSquadra(squadra.getNome());
		squadra.setCrediti(squadra.getCrediti() + giocatore.getValore());
		gir.setRimosso(true);
		DBManager.getInstance().getGiocatore_in_rosa().update(gir);
		DBManager.getInstance().getSquadra().update(squadra);
		DBManager.getInstance().getGiocatore_in_rosa().updateAll(squadra.getNome(), false);
		return 6;
	}

}
