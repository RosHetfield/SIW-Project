package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import model.Campionato;
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
			
		
	
		String jsString= request.getParameter("campionato");

		String utente = (String) request.getSession().getAttribute("Username");

		ObjectMapper mapper = new ObjectMapper();
		String  campionato = (String) mapper.readValue(jsString,String.class);
	

			if (campionato != null && utente != null) {

				response.setContentType("text/html");
				
				request.getSession().setAttribute("campionato", campionato);
				
				Squadra squadra=DBManager.getInstance().getUtente().getSquadraCampionato(utente, campionato);
				request.setAttribute("squadra", squadra);
				
				
			//	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			//	String json = ow.writeValueAsString(squadra);				
				
				if(squadra != null)
				{		
					response.getWriter().print(0);
					response.setStatus(HttpServletResponse.SC_OK);
					request.getSession().setAttribute("squadra", squadra);
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
