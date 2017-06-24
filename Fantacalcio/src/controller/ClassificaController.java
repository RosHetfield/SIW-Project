package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ClassificaController
 */
@WebServlet("/ClassificaController")
public class ClassificaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassificaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sono in classifica controller get");
	//	if (request.getParameterNames().hasMoreElements()) {

			response.setContentType("text/html");
			HttpSession session = request.getSession();
			String campionato = (String) session.getAttribute("campionato");
			String squadra= (String)request.getSession().getAttribute("squadra");
			
		
			if (campionato != null && squadra!=null) {
				
				System.out.println("sono in if");

				//vedere come contrassegnare una giornata calcolata
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("classifica.html");
				dispatcher.forward(request, response);

				
				
			}
			else{
				System.out.println("sono in if");

				RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
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
