package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("ci minchia entriiiii???????");
		if (request.getSession().getAttribute("Username") != null) {
			System.out.println("sono in sessione");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
			//dispatcher.forward(request, response);
			response.sendRedirect("Home");

		} else {
			System.out.println("sono in brazza a maria");

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
