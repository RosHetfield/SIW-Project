package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

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
			HttpSession session = request.getSession();
			response.setContentType("text/html");
			String campionato = (String) session.getAttribute("NomeCampionato");
			if (campionato != null) {
				// Campionato camp =
				// DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
				System.out.println("FFFFF " + campionato);
				JSONObject jsRes = new JSONObject();
				Partita p = DBManager.getInstance().getPartita().getUltimaGiornataGiocabile(campionato);
				if (p != null) {
					try {
						jsRes.put("status", 2);
						jsRes.put("giornata", p.getGiornata());
						response.getWriter().print(jsRes);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				} else {
					int ultima_giornata = DBManager.getInstance().getVoto_giornata().getUltimaGiornata();
					System.out.println("ULTIMA " + ultima_giornata);
					if (ultima_giornata != -1) {
						++ultima_giornata;

						try {
							jsRes.put("giornata", ultima_giornata);

							if (DBManager.getInstance().getPartita().findByPrimaryKey(ultima_giornata,
									campionato) != null) {
								jsRes.put("status", 1);
								response.getWriter().print(jsRes);
							} else {
								String jsonData = request.getParameter("jsonData");
								ObjectMapper mapper = new ObjectMapper();
								Date data = (Date) mapper.readValue(jsonData, Date.class);

								Partita partita = new Partita(ultima_giornata, campionato, data);
								partita.setCampionato(campionato);
								Campionato c = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
								DBManager.getInstance().getPartita().save(partita);
								if (c.isMercato()) {
									c.setMercato(false);
									DBManager.getInstance().getCampionato().update(c);
								}
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

}
