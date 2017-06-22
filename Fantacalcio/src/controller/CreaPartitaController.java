package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import model.Campionato;
import model.Partita;
import persistence.DBManager;

/**
 * Servlet implementation class CreaPartitaController
 */
@WebServlet("/CreaPartitaController")
public class CreaPartitaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreaPartitaController() {
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
		if (!request.getParameterNames().hasMoreElements()) {
			HttpSession session = request.getSession();
			response.setContentType("text/html");
			String campionato = (String) session.getAttribute("NomeCampionato");
			if (campionato != null) {
				Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
				System.out.println("FFFFF " + camp.getNome());

				int ultima_giornata = DBManager.getInstance().getVoto_giornata().getUltimaGiornata();
				System.out.println("ULTIMA " + ultima_giornata);
				if (ultima_giornata != -1) {
					++ultima_giornata;
					JSONObject jsRes = new JSONObject();
					try {
						jsRes.put("giornata", ultima_giornata);
						if (DBManager.getInstance().getPartita().findByPrimaryKey(ultima_giornata, camp.getNome()) != null) {
							jsRes.put("status", 1);
							response.getWriter().print(jsRes);
						} else {
							Partita partita = new Partita(ultima_giornata,true);
							partita.setCampionato(camp);
							DBManager.getInstance().getPartita().save(partita);
							jsRes.put("status", 0);
							response.getWriter().print(jsRes);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
