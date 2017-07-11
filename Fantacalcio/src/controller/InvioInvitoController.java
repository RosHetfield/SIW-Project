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
import persistence.DBManager;

/**
 * Servlet implementation class InvioInvitoController
 */
@WebServlet("/InvioInvitoController")
public class InvioInvitoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InvioInvitoController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {

			String jsString = request.getParameter("invito");

			if (jsString != null) {
				ObjectMapper mapper = new ObjectMapper();

				Invito invito = (Invito) mapper.readValue(jsString, Invito.class);
				response.setContentType("text/html");

				List<Invito> checkInvito = DBManager.getInstance().getInvito().findByCampionato(invito.getCampionato());
				if (!checkInvito.contains(invito)) {

					DBManager.getInstance().getInvito().save(invito);
					response.setStatus(HttpServletResponse.SC_OK);
				} else {
					response.getWriter().print(1);
				}

			}
		}
	}

}
