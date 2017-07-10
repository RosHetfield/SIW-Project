package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Classifica;
import model.Partita;
import persistence.DBManager;

/**
 * Servlet implementation class ClassificaController
 */
@WebServlet("/ClassificaController")
public class ClassificaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int giornataStorico = 0;
	private boolean primo = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassificaController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("sono in classifica controller get");
	//	if (request.getParameterNames().hasMoreElements()) {
		if(request.getSession().getAttribute("Username") != null) {
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			String campionato = (String) session.getAttribute("campionato");
			String squadra= (String)request.getSession().getAttribute("squadra");
			
		
			if (campionato != null && squadra!=null) {
				
				System.out.println("sono in if");
				
				Partita partita = DBManager.getInstance().getPartita().getUltimaCalcolata(campionato);
				if(!primo && partita != null) {
					giornataStorico = partita.getGiornata();
					primo = true;
				}
				
				String jsGiornata = (String) request.getParameter("giornata");
				if (jsGiornata != null) {
					System.out.println(jsGiornata);							
						ObjectMapper mapper = new ObjectMapper();
						giornataStorico = mapper.readValue(jsGiornata, int.class);
						System.out.println("ARRIVO " + giornataStorico);
					}
			
				System.out.println(giornataStorico + " GGG");
				List<Classifica> classifica = DBManager.getInstance().getClassifica().getClassificaGiornata(giornataStorico, campionato);
				System.out.println("CLASSIFICA " + classifica);
				if(classifica != null) {
					request.setAttribute("giornataStorico", giornataStorico);
					request.setAttribute("giornata", partita.getGiornata());
					request.setAttribute("classifica", classifica);					
				} else {
					request.setAttribute("classifica", null);
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("classifica.jsp");
				dispatcher.forward(request, response);

				
				
			}else {
				System.out.println("sono in else");
				RequestDispatcher dispatcher = request.getRequestDispatcher("404.jsp");
				dispatcher.forward(request, response);
			}
			
		} else {
			System.out.println("sono in else");
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
