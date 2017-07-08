package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Utente;
import persistence.DBManager;

/**
 * Servlet implementation class RegistrazioneController
 */
@WebServlet("/RegistrazioneController")
public class RegistrazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegistrazioneController() {
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

			String jsString = request.getParameter("utenteRegistrazione");
			if (jsString != null) {

				ObjectMapper mapper = new ObjectMapper();

				Utente utente = (Utente) mapper.readValue(jsString, Utente.class);

				Utente checkUtente = DBManager.getInstance().getUtente().findByPrimaryKey(utente.getUsername());
				response.setContentType("text/html");

				if (checkUtente.getUsername() != null) {
					response.getWriter().print(1);

				} else {
					DBManager.getInstance().getUtente().save(utente);
					HttpSession session = request.getSession();
					session.setAttribute("Username", utente.getUsername());
					response.getWriter().print(0);
				}

			}

		}
	}

}
