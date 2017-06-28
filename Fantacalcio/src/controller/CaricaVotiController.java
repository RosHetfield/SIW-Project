package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		System.out.println("ARRIVO?");

		Part filePart = request.getPart("file");
		// String fileName = String.valueOf("fileName");
		// System.out.println(fileName);
		// File file = new File(fileName);
		// OutputStream outFile = new FileOutputStream(file);
		InputStream fileContent = null;

		fileContent = filePart.getInputStream();

		// int read = 0;
		// byte[] bytes = new byte[1024];
		// while((read = fileContent.read(bytes)) != -1) {
		// outFile.write(bytes, 0, read);
		// }
		// outFile.close();
		XSSFWorkbook votazioni;
		votazioni = new XSSFWorkbook(fileContent);
		XSSFSheet sheet = votazioni.getSheetAt(0);
		
//		Iterator<Row> itr = sheet.iterator();

		Row row;
        // Iterating over Excel file in Java
		System.out.println(sheet.getLastRowNum());
		for(int i=4; i<=sheet.getLastRowNum(); i++){
			row = sheet.getRow(i);
			if(row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING){
				continue;
			}
			if(row.getCell(1).getStringCellValue().equalsIgnoreCase("ALL")){
				continue;
			}
			Voto_giornata voto = new Voto_giornata();
			voto.setGiornata(1);//passare attr req
			voto.setNomeGiocatore(row.getCell(2).getStringCellValue());
			int votazione = 0;
			if(row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING) {
				String star = row.getCell(3).getStringCellValue();
				String [] s = star.split("\\*");
				votazione = Integer.valueOf(s[0]);	
				
			}
			else if(row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC)
			{
				votazione= (int)row.getCell(3).getNumericCellValue();
			}
			voto.setVoto(votazione);
			voto.setGoalFatto((int)row.getCell(4).getNumericCellValue());
			voto.setGoalSubito((int)row.getCell(5).getNumericCellValue());
			voto.setGoalSuRigore((int)row.getCell(8).getNumericCellValue());
			voto.setRigoreParato((int)row.getCell(6).getNumericCellValue());
			voto.setRigoreSbagliato((int)row.getCell(7).getNumericCellValue());
			voto.setAutorete((int)row.getCell(9).getNumericCellValue());
			
			int assist_totali = (int)(row.getCell(12).getNumericCellValue() + row.getCell(13).getNumericCellValue());
			voto.setAssist(assist_totali);
			
			boolean ammonito = false;
			if((int)row.getCell(10).getNumericCellValue() == 1) 
				ammonito = true;
			voto.setAmmonito(ammonito);
			boolean espulso = false;
			if((int)row.getCell(11).getNumericCellValue() == 1) 
				espulso = true;
			voto.setEspulso(espulso);
			
			boolean goal_vittoria = false;
			if((int)row.getCell(14).getNumericCellValue() == 1) 
				goal_vittoria = true;
			voto.setGoalVittoria(goal_vittoria);
			
			boolean goalPareggio = false;
				if((int)row.getCell(15).getNumericCellValue() == 1) 
					goalPareggio = true;
			voto.setGoalPareggio(goalPareggio);
			
			DBManager.getInstance().getVoto_giornata().save(voto);
		}
		
//        while (itr.hasNext()) {
//            Row row = itr.next();
//
//            // Iterating over each column of Excel file
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()) {
//
//                Cell cell = cellIterator.next();
//
//                switch (cell.getCellType()) {
//                case Cell.CELL_TYPE_STRING:
//                    System.out.print(cell.getStringCellValue() + "\t");
//                    break;
//                case Cell.CELL_TYPE_NUMERIC:
//                    System.out.print(cell.getNumericCellValue() + "\t");
//                    break;
//                case Cell.CELL_TYPE_BOOLEAN:
//                    System.out.print(cell.getBooleanCellValue() + "\t");
//                    break;
//                default:
//
//                }
//            }
//            System.out.println("");
//        }

		votazioni.close();

		response.setContentType("text/html");
		response.getWriter().print("File Caricato!");
	}

}
