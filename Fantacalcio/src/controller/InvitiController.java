package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Campionato;
import model.Invito;
import model.Utente;
import persistence.DBManager;

/**
 * Servlet implementation class InvitiController
 */
@WebServlet("/InvitiController")
public class InvitiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvitiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (request.getParameterNames().hasMoreElements()) {
//			String jsInvito = (String) request.getParameter("invito");
//			String jsRisposta = (String) request.getParameter("risposta");
			response.setContentType("text/html");
//			if (jsRisposta != null && jsInvito != null) {
				
				String username = (String) request.getSession().getAttribute("Username");

				if (username != null) {
					System.out.println("MADONNA PUTTANA " + username);
//					ObjectMapper mapper = new ObjectMapper();
//					
//					Invito invito = (Invito) mapper.readValue(jsInvito, Invito.class);
//					if(jsRisposta.equals("r"))
//					{
//						DBManager.getInstance().getInvito().delete(invito);
//					}
//					else if(jsRisposta.equals("a")){}
//					
					List<Invito> result = DBManager.getInstance().getInvito().findByUtente(username);

					request.setAttribute("Inviti", result);
					request.setAttribute("CampionatiUtente",
							(List<String>) request.getSession().getAttribute("CampionatiUtente"));
					RequestDispatcher dispatcher = request.getRequestDispatcher("Inviti.jsp");
					dispatcher.forward(request, response);

				}

				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
					dispatcher.forward(request, response);
				}
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
		String jsInvito = (String) request.getParameter("invito");
		String jsRisposta = (String) request.getParameter("risposta");
		response.setContentType("text/html");
		if (jsRisposta != null && jsInvito != null) {
			
			String username = (String) request.getSession().getAttribute("Username");

			if (username != null) {
				System.out.println("MADONNA PUTTANA " + username);
				ObjectMapper mapper = new ObjectMapper();
				
				Invito invito = (Invito) mapper.readValue(jsInvito, Invito.class);
				String risposta = (String) mapper.readValue(jsRisposta, String.class);
				if(risposta.equals("r"))
				{
					DBManager.getInstance().getInvito().delete(invito);
				}
				else if(jsRisposta.equals("a")){}
				
				List<Invito> result = DBManager.getInstance().getInvito().findByUtente(username);

				request.setAttribute("Inviti", result);
				request.setAttribute("CampionatiUtente",
						(List<String>) request.getSession().getAttribute("CampionatiUtente"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("Inviti.jsp");
				dispatcher.forward(request, response);

			}

			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("errore.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
	}

}
