package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Giocatore;
import model.Giocatore_in_formazione;
import model.Partita;
import model.Squadra;
import model.Voto_giornata;
import persistence.DBManager;

/**
 * Servlet implementation class RisultatiController
 */
@WebServlet("/RisultatiController")
public class RisultatiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RisultatiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String utente = (String) session.getAttribute("Username");
		if (utente != null) {
			response.setContentType("text/html");
			String campionato = (String) session.getAttribute("campionato");
			String squadra = (String) request.getSession().getAttribute("squadra");
			if (campionato != null && squadra != null) {

				// restituisco l'ultima giornata creata e nella quale possone
				// essere presenti formazioni
				Partita giornata = DBManager.getInstance().getPartita().getUltimaGiornataGiocabile(campionato);///////cangia
				Set<Squadra> squadreCampionato=DBManager.getInstance().getCampionato().findByPrimaryKey(campionato).getSquadre();
				
				
				
				
				List<Voto_giornata> giocatori=DBManager.getInstance().getVoto_giornata().findByGiornata(giornata.getGiornata(),campionato);
				Partita partitaFormazione=DBManager.getInstance().getPartita().findByPrimaryKey(giornata.getGiornata(), campionato);
				Set<Giocatore_in_formazione> inFormazione=partitaFormazione.getGiocatoriInFormazione();
				
				HashMap<String, Voto_giornata> mappaVoti=new HashMap<>();
				for (Giocatore_in_formazione gf : inFormazione) {
					for (Voto_giornata v : giocatori) {
						if(v.getNomeGiocatore().equals(gf.getNomeGiocatoreRosa()))
						mappaVoti.put(gf.getNomeGiocatoreRosa(), v );
					}
				}	
				
				for (String giocatore : mappaVoti.keySet()) {
					System.out.println(giocatore + " " + mappaVoti.get(giocatore).getFantavoto());
				}
				
				request.setAttribute("inFormazione", inFormazione);
				request.setAttribute("ultimaGiornata", giornata);
				//request.setAttribute("giocatoriVotiUltima", giocatori);
				request.setAttribute("mappaVoti", mappaVoti);

				request.setAttribute("squadreCampionato", squadreCampionato);////////////??
				
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("risultati.jsp");
				dispatcher.forward(request, response);
			}
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}

		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
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
