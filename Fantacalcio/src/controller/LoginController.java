package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
			System.out.println(jsString + " parametro");
			if (jsString != null) {
				ObjectMapper mapper = new ObjectMapper();

				Utente utente = (Utente) mapper.readValue(jsString, Utente.class);
				response.setContentType("text/html");
				Utente result = DBManager.getInstance().getUtente().findByPrimaryKey(utente.getUsername());
				System.out.println(result.getUsername() + " utende " + result.getPassword() + " passuord");
				if (result.getUsername() != null) {
					if (result.getPassword().equals(utente.getPassword())) {
						HttpSession session = request.getSession();
						session.setAttribute("Username", utente.getUsername());
//						response.sendRedirect("Home");
						response.getWriter().print(0);
					}
					else 
						response.getWriter().print(1); 
				} else {
					response.getWriter().print(2);
				}
				
			}
		}
	}
}
