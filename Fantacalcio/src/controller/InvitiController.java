package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Campionato;
import model.Invito;
import persistence.DBManager;

/**
 * Servlet implementation class InvitiController
 */
@WebServlet("/InvitiController")
public class InvitiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvitiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			String username = (String) request.getSession().getAttribute("Username");
			

			if (username != null) {

				response.setContentType("text/html");
				List<Invito> result = DBManager.getInstance().getInvito().findByUtente(username);

					request.setAttribute("Inviti", result);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Inviti.jsp");
					dispatcher.forward(request, response);
		
			}
			
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	

}
