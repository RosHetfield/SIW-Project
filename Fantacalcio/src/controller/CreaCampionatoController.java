package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Campionato;
import persistence.DBManager;

/**
 * Servlet implementation class CreaCampionatoController
 */
@WebServlet("/CreaCampionatoController")
public class CreaCampionatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreaCampionatoController() {
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

		System.out.println("classe creacampionato doPost");
		if (request.getParameterNames().hasMoreElements()) {

			String jsString = request.getParameter("credenzialiAmministratore");
			if (jsString != null) {

				ObjectMapper mapper = new ObjectMapper();
				Campionato campionato = (Campionato) mapper.readValue(jsString, Campionato.class);

				Campionato checkCampionato = DBManager.getInstance().getCampionato()
						.findByPrimaryKey(campionato.getNome());
				response.setContentType("text/html");

				if (checkCampionato == null) {

					DBManager.getInstance().getCampionato().save(campionato);
					request.getSession().setAttribute("NomeCampionato", campionato.getNome());
					response.getWriter().print(0);

				} else {
					response.getWriter().print(1);

				}

			}

		}
	}

}
