package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Partita;
import persistence.DBManager;

/**
 * Servlet implementation class CalcolaRisultatiController
 */
@WebServlet("/CalcolaRisultatiController")
public class CalcolaRisultatiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcolaRisultatiController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String campionato = (String) request.getSession().getAttribute("NomeCampionato");
		System.out.println("ENFRO " + campionato);
		System.out.println(request.getSession().getAttribute("Username"));
		if(request.getSession().getAttribute("Username") != null &&  campionato != null) {
			System.out.println("mario");
			Partita p = DBManager.getInstance().getPartita().getPartitaGiocabile(campionato);
			if(p != null) {
				System.out.println("CCA");
				request.setAttribute("giornata", p.getGiornata());
				RequestDispatcher dispatcher = request.getRequestDispatcher("calcolaGiornata.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println("MOH");
				response.getWriter().print(1);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
