package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((String) request.getSession().getAttribute("Username") != null) {
			HttpSession session = request.getSession();
			session.removeAttribute("Username");
			session.invalidate();
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP
																						// 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setDateHeader("Expires", 0);
			RequestDispatcher dispatcher = request.getRequestDispatcher("logout.html");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("404.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
