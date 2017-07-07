package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Partita;
import persistence.DBManager;

/**
 * Servlet implementation class AperturaFormazioneController
 */
@WebServlet("/AperturaFormazioneController")
public class AperturaFormazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AperturaFormazioneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {

			HttpSession session = request.getSession();
			String campionato = (String) session.getAttribute("NomeCampionato");
			if (campionato != null) {
				String jsString = request.getParameter("risposta");

				if (jsString != null) {
					ObjectMapper mapper = new ObjectMapper();

					String apertura = (String) mapper.readValue(jsString, String.class);
					response.setContentType("text/html");
					Partita part = DBManager.getInstance().getPartita().getUltimaGiornataGiocabile(campionato);
					if(part != null){
					if(apertura.equals("t")) {
//						part.setAggiungiFormazione(true);
						DBManager.getInstance().getPartita().update(part);
						response.getWriter().println(0);
					}
					else if(apertura.equals("f")) {
//						part.setAggiungiFormazione(false);
						DBManager.getInstance().getPartita().update(part);
						response.getWriter().println(1);
					}
					}
					else{
						System.out.println("non esiste nessuna partita");
						response.getWriter().println(2);
						
					}
				}
			}
		}
	}

}
