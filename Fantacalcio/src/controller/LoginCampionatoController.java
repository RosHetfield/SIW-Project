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
import persistence.DBManager;

/**
 * Servlet implementation class LoginCampionatoController
 */
@WebServlet("/LoginCampionatoController")
public class LoginCampionatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCampionatoController() {
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
			String username = (String) request.getSession().getAttribute("Username");

			String jsString = request.getParameter("credenzialiAmministratore");
			if (jsString != null) {
				ObjectMapper mapper = new ObjectMapper();

				Campionato campionato = (Campionato) mapper.readValue(jsString, Campionato.class);
				response.setContentType("text/html");
				Campionato result = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato.getNome());
				if (result != null) {
					if (result.getPassword().equals(campionato.getPassword())) {
						HttpSession session = request.getSession();
						session.setAttribute("NomeCampionato", campionato.getNome());
						response.getWriter().print(0);
					} else
						response.getWriter().print(1);
				} else {
					response.getWriter().print(2);
				}
			}

		}
	}

}
