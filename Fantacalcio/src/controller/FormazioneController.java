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
import model.Partita;
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
					
					String s=(String) request.getSession().getAttribute("squadra");
					
					List<Giocatore> giocatoriInRosa = DBManager.getInstance().getGiocatore_in_rosa().getGiocatoriInRosa(s);
					request.setAttribute("giocatoriInRosa", giocatoriInRosa);
					
					int giornata= (int)request.getSession().getAttribute("giornata");
					request.getSession().removeAttribute("giornata");
					
					List<Giocatore> giocatoriInFormazione = DBManager.getInstance().getGiocatore().getGiocatoriInFormazione(giornata);
					request.setAttribute("giocatoriInFormazione", giocatoriInFormazione);
					


			
					response.setContentType("text/html");
					RequestDispatcher dispatcher = request.getRequestDispatcher("formazione.jsp");
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
		String username = (String) request.getSession().getAttribute("Username");
		System.out.println("sono in do post");

		if (username != null) {
			String campionato = (String) request.getSession().getAttribute("campionato");
			
			if(campionato != null) {
				Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
				Partita partita=DBManager.getInstance().getPartita().getPartitaGiocabile();
				int giornata=partita.getGiornata();
				request.getSession().setAttribute("giornata", giornata);

				if(!camp.isMercato()) {
					if(giornata !=-1){
					response.getWriter().print(2);
						System.out.println("caso 2");
					}
					else{
					response.getWriter().print(0);
					System.out.println("caso 0");

					}
				} else {
					response.getWriter().print(1);
					System.out.println("caso 1");

				}
			
			}

		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
			dispatcher.forward(request, response);
		}
	}

}
