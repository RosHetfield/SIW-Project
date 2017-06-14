package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Utente;
import persistence.DBManager;

/**
 * Servlet implementation class RegistrazioneController
 */
@WebServlet("/RegistrazioneController")
public class RegistrazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrazioneController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsString = request.getParameter("credenzialiUtente");
		System.out.println("######################1");

		if (jsString != null) {
			ObjectMapper mapper = new ObjectMapper();

			Utente utente = (Utente) mapper.readValue(
					jsString, Utente.class);
		
			System.out.println("######################");
			System.out.println(utente.getUsername());
			System.out.println(utente.getPassword());

			if(utente.getUsername()!=null){
				
				Utente result = DBManager.getInstance().getUtente()
					.findByPrimaryKey(utente.getUsername());
			if(result!=null){
				if(result.getPassword().equals(utente.getPassword()))
				{
					
				response.getWriter().print(0);
				}
				else
				{
					
					response.getWriter().print(1);
				}
					
			}
			else
			{
				
				response.getWriter().print(2);
			}
				
				
		}
			else response.getWriter().print(2);
			
			
			
		}
		
		

	}

}
