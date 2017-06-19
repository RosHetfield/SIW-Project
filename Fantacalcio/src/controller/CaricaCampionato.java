package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Invito;
import model.Squadra;
import persistence.DBManager;

/**
 * Servlet implementation class CaricaCampionato
 */
@WebServlet("/CaricaCampionato")
public class CaricaCampionato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaricaCampionato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (request.getParameterNames().hasMoreElements()) {
			
			String campionato = (String) request.getAttribute("campionato");
			String utente=(String) request.getSession().getAttribute("Username");
			
			if (campionato != null && utente != null) {

				response.setContentType("text/html");
				
				request.setAttribute("campionato", campionato);
				
				Squadra squadra=DBManager.getInstance().getUtente().getSquadraCampionato(utente, campionato);
				request.setAttribute("squadra", squadra);
				
				if(squadra != null)
				{
					response.setStatus(HttpServletResponse.SC_OK);
				}
				else
				{
					response.getWriter().print(1);
				}
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
