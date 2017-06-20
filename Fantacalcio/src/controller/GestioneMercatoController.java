package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Campionato;

/**
 * Servlet implementation class GestioneMercato
 */
@WebServlet("/GestioneMercatoController")
public class GestioneMercatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneMercatoController() {
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
		response.setContentType("text/html");
		
		String username = (String) request.getSession().getAttribute("Username");

		if (username != null) {
			System.out.println("Sessione Utente " + username);
			String campionato = (String) request.getSession().getAttribute("campionato");
			
			if(campionato != null) {
				System.out.println("Sessione Campionato " + campionato);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("mercato.html");
				dispatcher.forward(request, response);
					
				
			
			}

		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
			dispatcher.forward(request, response);
		}
	}

}
