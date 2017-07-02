package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Campionato;
import model.Classifica;
import model.Giocatore_in_formazione;
import model.Partita;
import model.RisultatoGiornata;
import model.Squadra;
import model.Voto_giornata;
import persistence.DBManager;

/**
 * Servlet implementation class CalcolaGiornataController
 */
@WebServlet("/CalcolaGiornataController")
public class CalcolaGiornataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcolaGiornataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String campionato = (String) session.getAttribute("NomeCampionato");
		if (campionato != null) {
			Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
			int giornata = DBManager.getInstance().getPartita().getUltimaGiornata(campionato);
			List<Voto_giornata> voti = DBManager.getInstance().getVoto_giornata().findByGiornata(giornata, campionato);
			Partita partita = DBManager.getInstance().getPartita().findByPrimaryKey(giornata, campionato);
			
			for (Giocatore_in_formazione g : partita.getGiocatoriInFormazione()) {
				boolean trovato = false;
				for (Voto_giornata voto_giornata : voti) {
					if(voto_giornata.getNomeGiocatore().equals(g.getNomeGiocatoreRosa())){
						trovato = true;
						break;
					}	
				}
				if(!trovato) {
					sostituzione(g, partita);
				}
			}
			
			for (Squadra squadra : camp.getSquadre()) {
				int partite_giocate = DBManager.getInstance().getClassifica().getPartiteGiocate(squadra.getNome());
				double totale_giornata = 0;
				double totale = 0;
				RisultatoGiornata risultato_giornata = DBManager.getInstance().getClassifica().getRisultatoGiornata(giornata, squadra.getNome());
				if(risultato_giornata != null) {
					totale_giornata = risultato_giornata.getTotale();
				}
				Classifica ultimo_risultato = DBManager.getInstance().getClassifica().getUltimoRisultatoClassifica(squadra.getNome());
				if(ultimo_risultato != null) {
					totale = ultimo_risultato.getTotale();
				}
				double somma_risultati = totale_giornata + totale;
				Classifica classifica = new Classifica(squadra.getNome(), giornata, partite_giocate, campionato, somma_risultati);
				DBManager.getInstance().getClassifica().save(classifica);
			}
			response.setContentType("text/html");
			response.getWriter().print(0);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void sostituzione(Giocatore_in_formazione g, Partita partita) {
		g.setEntrato(false);
		g.setUscito(true);
		boolean primo = true;
		int n_formazione = 0;
		Giocatore_in_formazione gif = null;
		for (Giocatore_in_formazione giocatore : partita.getGiocatoriInFormazione()) {
			if(!giocatore.isTitolare() && g.getGiocatoreInRosa().getGiocatore().getRuolo().equals(giocatore.getGiocatoreInRosa().getGiocatore().getRuolo()) 
					&& !giocatore.isEntrato()) {
				if(primo) {
					n_formazione = giocatore.getN_formazione();
					gif = giocatore;
					primo = false;
				}
				if(giocatore.getN_formazione() < n_formazione) {
					n_formazione = giocatore.getN_formazione();		
					gif = giocatore;
				}
			}
		}
		gif.setEntrato(true);
		DBManager.getInstance().getGiocatore_in_formazione().update(g);
		DBManager.getInstance().getGiocatore_in_formazione().update(gif);
	}

}
