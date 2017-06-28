package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class CaricaVotiController
 */
@WebServlet("/CaricaVotiController")
public class CaricaVotiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CaricaVotiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ARRIVO?");
		Part filePart = request.getPart("file");
		String fileName = String.valueOf("fileName");
		System.out.println(fileName);
		File file = new File(fileName);
		OutputStream outFile = new FileOutputStream(file);
		InputStream fileContent = filePart.getInputStream();
		
		int read = 0;
		byte[] bytes = new byte[1024];
		while((read = fileContent.read(bytes)) != -1) {
			outFile.write(bytes, 0, read);
		}
		outFile.close();
		response.setContentType("text/html");
		response.getWriter().print("File Caricato!");
	}

}
