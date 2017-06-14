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
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
			 
			String jsString = request.getParameter("utenteRegistrazione");
			if (jsString != null) {

				ObjectMapper mapper = new ObjectMapper();

				Utente utente = (Utente) mapper.readValue(
						jsString, Utente.class);

				String user= DBManager.getInstance().getUtente().findByPrimaryKey(utente.getUsername()).getUsername();

				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("text/html"); 
				
				System.out.println(utente.getUsername());
				System.out.println(utente.getNome());
				System.out.println(utente.getCognome());
				System.out.println(utente.getEmail());
				System.out.println(utente.getPassword());

			}
			
		}
	}

}
