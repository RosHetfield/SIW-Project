package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Campionato;
import model.Partita;
import persistence.DBManager;

/**
 * Servlet implementation class AperturaMercatoController
 */
@WebServlet("/AperturaMercatoController")
public class AperturaMercatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AperturaMercatoController() {
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

			HttpSession session = request.getSession();
			String campionato = (String) session.getAttribute("NomeCampionato");
			if (campionato != null) {
				String jsString = request.getParameter("risposta");

				if (jsString != null) {
					ObjectMapper mapper = new ObjectMapper();

					String apertura = (String) mapper.readValue(jsString, String.class);
					response.setContentType("text/html");
					Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
					if (apertura.equals("t")) {
						Partita giornata = DBManager.getInstance().getPartita().getUltimaGiornataGiocabile(campionato);
						if (giornata == null) {
							camp.setMercato(true);
							DBManager.getInstance().getCampionato().update(camp);
							response.getWriter().println(0);
						} else if (giornata.getData().getTime() < System.currentTimeMillis()) {
							camp.setMercato(true);
							DBManager.getInstance().getCampionato().update(camp);
							response.getWriter().println(0);
						} else {
							response.getWriter().println(2);
						}
					} else if (apertura.equals("f")) {
						camp.setMercato(false);
						DBManager.getInstance().getCampionato().update(camp);
						response.getWriter().println(1);
					}
				}
			}
		}
	}

}
