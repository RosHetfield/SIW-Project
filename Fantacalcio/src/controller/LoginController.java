package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Utente;
import persistence.DBManager;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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

			String jsString = request.getParameter("credenzialiUtente");
			System.out.println(jsString);
			if (jsString != null) {
				ObjectMapper mapper = new ObjectMapper();

				Utente utente = (Utente) mapper.readValue(jsString, Utente.class);
				response.setContentType("text/html");
				if (utente.getUsername() != null) {
					Utente result = DBManager.getInstance().getUtente().findByPrimaryKey(utente.getUsername());
					if (result != null) {
						if (result.getPassword().equals(utente.getPassword())) {

							response.getWriter().print(0);
						} else {

							response.getWriter().print(1);
						}

					} else {

						response.getWriter().print(2);
					}

				} else
					response.getWriter().print(2);
				System.out.println(utente.getUsername());
				System.out.println(utente.getPassword()); 

			}

		}
	}
}
