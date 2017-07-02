package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Voto_giornata;
import persistence.DBManager;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String campionato = (String) session.getAttribute("NomeCampionato");
		System.out.println("ARRIVO?");
		if (campionato != null) {


			Part filePart = request.getPart("file");

			InputStream fileContent = filePart.getInputStream();

			XSSFWorkbook votazioni;
			votazioni = new XSSFWorkbook(fileContent);
			XSSFSheet sheet = votazioni.getSheetAt(0);

			Row row;
			for (int i = 4; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
					continue;
				}
				if (row.getCell(1).getStringCellValue().equalsIgnoreCase("ALL")) {
					continue;
				}
				Voto_giornata voto = new Voto_giornata();
				voto.setGiornata(1);// passare attr req
				voto.setNomeGiocatore(row.getCell(2).getStringCellValue());
				int votazione = 0;
				if (row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING) {
					String star = row.getCell(3).getStringCellValue();
					String[] s = star.split("\\*");
					votazione = Integer.valueOf(s[0]);

				} else if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					votazione = (int) row.getCell(3).getNumericCellValue();
				}

				int goalFatto = (int) row.getCell(4).getNumericCellValue();
				int goalSubito = (int) row.getCell(5).getNumericCellValue();
				int goalSuRigore = (int) row.getCell(8).getNumericCellValue();
				int rigoreParato = (int) row.getCell(6).getNumericCellValue();
				int rigoreSbagliato = (int) row.getCell(7).getNumericCellValue();
				int autorete = (int) row.getCell(9).getNumericCellValue();
				int assist_totali = (int) (row.getCell(12).getNumericCellValue()
						+ row.getCell(13).getNumericCellValue());
				int ammonito = (int) row.getCell(10).getNumericCellValue();
				int espulso = (int) row.getCell(11).getNumericCellValue();
				int goalVittoria = (int) row.getCell(14).getNumericCellValue();
				int goalPareggio = (int) row.getCell(15).getNumericCellValue();

				double fantavoto = votazione + (goalFatto * 3) - (goalSubito) + assist_totali - ammonito - (espulso * 3)
						- (autorete * 3) + (goalSuRigore * 2) + (rigoreParato * 3) - (rigoreSbagliato * 3)
						+ goalVittoria + goalPareggio;

				voto.setVoto(votazione);
				voto.setGoalFatto(goalFatto);
				voto.setGoalSubito(goalSubito);
				voto.setGoalSuRigore(goalSuRigore);
				voto.setRigoreParato(rigoreParato);
				voto.setRigoreSbagliato(rigoreSbagliato);
				voto.setAutorete(autorete);
				voto.setAssist(assist_totali);
				voto.setAmmonito(ammonito);
				voto.setEspulso(espulso);
				voto.setGoalVittoria(goalVittoria);
				voto.setGoalPareggio(goalPareggio);
				voto.setFantavoto(fantavoto);

				DBManager.getInstance().getVoto_giornata().save(voto);
			}

			votazioni.close();

			response.setContentType("text/html");
//			response.getWriter().print("File Caricato!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("CalcolaGiornata");
			dispatcher.forward(request, response);
		}
	}

}
