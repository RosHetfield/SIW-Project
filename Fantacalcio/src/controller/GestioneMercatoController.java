package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Campionato;
import model.Giocatore;
import model.Invito;
import persistence.DBManager;

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
			
			String squadra=(String) request.getSession().getAttribute("squadra");
			System.out.println(squadra); 
			
			if(campionato != null) {/////
				System.out.println("Sessione Campionato " + campionato);		
				RequestDispatcher dispatcher = request.getRequestDispatcher("mercato.html");
				
				
				List<Giocatore> giocatoriInRosa = DBManager.getInstance().getGiocatore_in_rosa().getGiocatoriInRosa(squadra);
				List<Giocatore> giocatoriSvincolati=DBManager.getInstance().getGiocatore().getGiocatoriSvincolati( squadra);
				request.setAttribute("giocatoriInRosa", giocatoriInRosa);
				request.setAttribute("giocatoriSvincolati", giocatoriSvincolati);

				
				dispatcher.forward(request, response);
					
				
			
			}

		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
			dispatcher.forward(request, response);
		}
	}

}
