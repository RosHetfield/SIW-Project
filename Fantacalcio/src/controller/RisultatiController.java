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
	
	private int giornataStorico = -1;
	private boolean primo = false;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RisultatiController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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
				
				Partita p = DBManager.getInstance().getPartita().getUltimaCalcolata(campionato);
				if(!primo && p != null) {
					giornataStorico = p.getGiornata();
					primo = true;
				}

				Set<Squadra> squadreCampionato = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato)
						.getSquadre();

				List<Voto_giornata> giocatori = new ArrayList<Voto_giornata>();
				List<Giocatore_in_formazione> inFormazione = new ArrayList<Giocatore_in_formazione>();
				HashMap<String, Voto_giornata> mappaVoti = new HashMap<String, Voto_giornata>();
				List<RisultatoGiornata> risultatiGiornata = new ArrayList<RisultatoGiornata>();

				String jsGiornata = (String) request.getParameter("giornata");
					if (jsGiornata != null) {
						ObjectMapper mapper = new ObjectMapper();
						giornataStorico = mapper.readValue(jsGiornata, int.class);
				}
					
				Partita partita = DBManager.getInstance().getPartita().findByPrimaryKey(giornataStorico, campionato);

				if (partita != null) {
					giocatori = DBManager.getInstance().getVoto_giornata().findByGiornata(giornataStorico, campionato);
					inFormazione = partita.getGiocatoriInFormazione();
					inFormazione.sort(new Comparator<Giocatore_in_formazione>() {

						@Override
						public int compare(Giocatore_in_formazione o1, Giocatore_in_formazione o2) {
							return o2.getGiocatoreInRosa().getGiocatore().getRuolo()
									.compareTo(o1.getGiocatoreInRosa().getGiocatore().getRuolo());
						}
					});

					for (Giocatore_in_formazione gf : inFormazione) {
						for (Voto_giornata v : giocatori) {
							if (v.getNomeGiocatore().equals(gf.getNomeGiocatoreRosa()))
								mappaVoti.put(gf.getNomeGiocatoreRosa(), v);
						}
					}

					risultatiGiornata = DBManager.getInstance().getClassifica().getRisultatiSquadreGiornata(giornataStorico,
							campionato);

					request.setAttribute("inFormazione", inFormazione);
					request.setAttribute("mappaVoti", mappaVoti);
					request.setAttribute("squadreCampionato", squadreCampionato);
					request.setAttribute("risultatiGiornata", risultatiGiornata);
					request.setAttribute("giornata", p.getGiornata());

				}
				request.setAttribute("ultimaGiornata", giornataStorico);

				RequestDispatcher dispatcher = request.getRequestDispatcher("risultati.jsp");
				dispatcher.forward(request, response);
			}
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
				dispatcher.forward(request, response);
			}

		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
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
