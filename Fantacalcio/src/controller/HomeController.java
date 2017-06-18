package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.DBManager;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameterNames().hasMoreElements()) {
			
			String username = (String) request.getSession().getAttribute("Username");
			
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			response.setDateHeader("Expires", 0);
			
			List<String> campionatiUtente=DBManager.getInstance().getUtente().getCampionati(username);
			
			if(username != null) {
				request.setAttribute("CampionatiUtente", campionatiUtente);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {

			String s = request.getParameter("Username");
			HttpSession session = request.getSession();
			session.setAttribute("Username", s);
			
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
			response.setHeader("Pragma", "no-cache"); 
			response.setDateHeader("Expires", 0);
			
			List<String> campionatiUtente=DBManager.getInstance().getUtente().getCampionati(s);
			
			request.setAttribute("CampionatiUtente", campionatiUtente);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
			dispatcher.forward(request, response);
		}
		
	

	}
	

}
