package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Giocatore;
import model.Giocatore_in_formazione;
import model.Partita;
import model.RisultatoGiornata;
import model.Squadra;
import model.Voto_giornata;
import persistence.DBManager;

/**
 * Servlet implementation class RisultatiController
 */
@WebServlet("/RisultatiController")
public class RisultatiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private int g = -1;
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

				Set<Squadra> squadreCampionato=DBManager.getInstance().getCampionato().findByPrimaryKey(campionato).getSquadre();									
				
				List<Voto_giornata> giocatori=new ArrayList<Voto_giornata>();
				List<Giocatore_in_formazione> inFormazione=new ArrayList<Giocatore_in_formazione>();
				HashMap<String, Voto_giornata> mappaVoti=new HashMap<String,Voto_giornata>();
				List<RisultatoGiornata> risultatiGiornata=new ArrayList<RisultatoGiornata>();
				Partita partita = null;
				
				if (request.getParameterNames().hasMoreElements()) {
					String jsGiornata = (String) request.getParameter("giornata");
					System.out.println(jsGiornata);
					if(jsGiornata != null) {							
						ObjectMapper mapper = new ObjectMapper();
						g = mapper.readValue(jsGiornata, int.class);
						System.out.println("ARRIVO " + g);
						partita = DBManager.getInstance().getPartita().findByPrimaryKey(g, campionato);
					}
				}
				else  {	
					partita = DBManager.getInstance().getPartita().getUltimaCalcolata(campionato);
					if(partita != null)
						g = partita.getGiornata();
				}

				if (partita != null) {
				giocatori=DBManager.getInstance().getVoto_giornata().findByGiornata(g,campionato);
				inFormazione=partita.getGiocatoriInFormazione();
				inFormazione.sort(new Comparator<Giocatore_in_formazione>() {

					@Override
					public int compare(Giocatore_in_formazione o1, Giocatore_in_formazione o2) {
						return o2.getGiocatoreInRosa().getGiocatore().getRuolo()
								.compareTo(o1.getGiocatoreInRosa().getGiocatore().getRuolo());
					}
				});
				
				for (Giocatore_in_formazione gf : inFormazione) {
					for (Voto_giornata v : giocatori) {
						if(v.getNomeGiocatore().equals(gf.getNomeGiocatoreRosa()))
						mappaVoti.put(gf.getNomeGiocatoreRosa(), v );
					}
				}
				
				
				risultatiGiornata=DBManager.getInstance().getClassifica().getRisultatiSquadreGiornata(g, campionato);
				
				request.setAttribute("inFormazione", inFormazione);
				request.setAttribute("mappaVoti", mappaVoti);
				request.setAttribute("squadreCampionato", squadreCampionato);
				request.setAttribute("risultatiGiornata", risultatiGiornata);
				

				}
				request.setAttribute("ultimaGiornata", g);
				
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
