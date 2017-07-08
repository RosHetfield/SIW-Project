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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String campionato = (String) session.getAttribute("NomeCampionato");
		if (campionato != null) {
			Campionato camp = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato);
			Partita giornata = DBManager.getInstance().getPartita().getUltimaCalcolata(campionato);
			List<Voto_giornata> voti = DBManager.getInstance().getVoto_giornata().findAll(giornata.getGiornata());
			Partita partita = DBManager.getInstance().getPartita().findByPrimaryKey(giornata.getGiornata(), campionato);

			int n_sostituzioni = 0;
			for (Giocatore_in_formazione g : partita.getGiocatoriInFormazione()) {
				boolean trovato = false;
				for (Voto_giornata voto_giornata : voti) {
					if (voto_giornata.getNomeGiocatore().equals(g.getNomeGiocatoreRosa())) {
						System.out.println(
								voto_giornata.getNomeGiocatore() + " " + g.getNomeGiocatoreRosa() + " trovato");
						trovato = true;
						break;
					}
				}
				if (!trovato && n_sostituzioni < 3) {
					System.out.println(g.getNomeGiocatoreRosa() + " non trovato");
					if (sostituzione(g, partita, voti))
						n_sostituzioni++;
				}
			}

			for (Squadra squadra : camp.getSquadre()) {
				int partite_giocate = DBManager.getInstance().getClassifica().getPartiteGiocate(squadra.getNome());
				double totale_giornata = 0;
				double totale = 0;
				RisultatoGiornata risultato_giornata = DBManager.getInstance().getClassifica()
						.getRisultatoGiornata(giornata.getGiornata(), squadra.getNome());
				if (risultato_giornata != null) {
					totale_giornata = risultato_giornata.getTotale();
				}
				Classifica ultimo_risultato = DBManager.getInstance().getClassifica()
						.getUltimoRisultatoClassifica(squadra.getNome());
				if (ultimo_risultato != null) {
					totale = ultimo_risultato.getTotale();
				}
				double somma_risultati = totale_giornata + totale;
				Classifica classifica = new Classifica(squadra.getNome(), giornata.getGiornata(), partite_giocate,
						campionato, somma_risultati);
				DBManager.getInstance().getClassifica().save(classifica);
			}
			response.setContentType("text/html");
			response.getWriter().print(0);
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

	private boolean sostituzione(Giocatore_in_formazione g, Partita partita, List<Voto_giornata> voti) {
		boolean primo = true;
		int n_formazione = 0;
		Giocatore_in_formazione gif = null;
		for (Giocatore_in_formazione giocatore : partita.getGiocatoriInFormazione()) {
			if (!giocatore.isTitolare() && g.getGiocatoreInRosa().getGiocatore().getRuolo()
					.equals(giocatore.getGiocatoreInRosa().getGiocatore().getRuolo()) && !giocatore.isEntrato()) {
				for (Voto_giornata voto : voti) {
					if (giocatore.getNomeGiocatoreRosa().equals(voto.getNomeGiocatore())) {
						if (primo) {
							n_formazione = giocatore.getN_formazione();
							System.out.println("primo " + giocatore.getNomeGiocatoreRosa() + " "
									+ giocatore.getN_formazione() + " " + n_formazione);
							gif = giocatore;
							primo = false;
						}
						if (giocatore.getN_formazione() < n_formazione) {
							n_formazione = giocatore.getN_formazione();
							System.out.println("minimo " + giocatore.getNomeGiocatoreRosa() + " "
									+ giocatore.getN_formazione() + " " + n_formazione);
							gif = giocatore;
						}
					}
				}
			}
		}
		if (g.isTitolare() && gif != null) {
			g.setUscito(true);
			gif.setEntrato(true);
			DBManager.getInstance().getGiocatore_in_formazione().update(g);
			DBManager.getInstance().getGiocatore_in_formazione().update(gif);
			return true;
		}
		return false;
	}

}
