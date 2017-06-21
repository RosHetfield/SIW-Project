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
import model.Squadra;
import persistence.DBManager;

/**
 * Servlet implementation class FormazioneController
 */
@WebServlet("/FormazioneController")
public class FormazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormazioneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String) request.getSession().getAttribute("Username");

		if (username != null) {
			System.out.println("Sessione Utente " + username);
			String campionato = (String) request.getSession().getAttribute("campionato");
			
			if(campionato != null) {
				System.out.println("Sessione Campionato " + campionato);
				Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
				if(camp.isMercato()) {
					
					Squadra s=(Squadra) request.getSession().getAttribute("squadra");
					//String s="albinoleffe";
					System.out.println(s.getNome()); 

					List<Giocatore> giocatoriInRosa = DBManager.getInstance().getGiocatore_in_rosa().getGiocatoriInRosa(s.getNome());
					List<Giocatore> giocatoriSvincolati=DBManager.getInstance().getGiocatore().getGiocatoriSvincolati(s.getNome());						
					request.setAttribute("giocatoriInRosa", giocatoriInRosa);
					request.setAttribute("giocatoriSvincolati", giocatoriSvincolati);
					response.setContentType("text/html");

					
					
					
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("mercato.jsp");
					dispatcher.forward(request, response);
					
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("404.html");
					dispatcher.forward(request, response);
				}
			
			}

		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
