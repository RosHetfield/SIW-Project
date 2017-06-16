package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Campionato;
import persistence.DBManager;

/**
 * Servlet implementation class CreaCampionatoController
 */
@WebServlet("/CreaCampionatoController")
public class CreaCampionatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaCampionatoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			 
			String jsString = request.getParameter("creazioneCampionato");
			System.out.println("simu ca.... "+jsString);
			if (jsString != null) {

				ObjectMapper mapper = new ObjectMapper();

				Campionato campionato = (Campionato) mapper.readValue(jsString, Campionato.class);
				
				Campionato checkCampionato = DBManager.getInstance().getCampionato().findByPrimaryKey(campionato.getNome());
				System.out.println("check "+checkCampionato.getNome());
				response.setContentType("text/html");
			
				if(checkCampionato.getNome() != null) {
					response.getWriter().print(1);		
				}
				else {
					DBManager.getInstance().getCampionato().save(campionato);
					response.setStatus(HttpServletResponse.SC_OK);
				}
				System.out.println(campionato.getNome());
				System.out.println(campionato.getPassword()); 

			}
			
		}
	}

}
