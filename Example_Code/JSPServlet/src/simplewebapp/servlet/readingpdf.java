package simplewebapp.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class readingpdf
 */
@WebServlet("/readingpdf")
public class readingpdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public readingpdf() {
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
		File file = new File(getServletContext().getRealPath("test.pdf"));
		
		response.setHeader("Content-Type", getServletContext().getMimeType(file.getName()));
		
		response.setHeader("Content-Lenght", String.valueOf(file.length()));
		
		response.setHeader("Content-Disposition", "inline; filename=\"foo.pdf\"");

		Files.copy(file.toPath(), response.getOutputStream());
		// PrintWriter out = response.getWriter();
		// String filepath = "test.pdf";
		// response.setHeader("Content-Disposition", "inline; filename=" +
		// filepath + ";");
		// FileOutputStream fileOut = new FileOutputStream("test.pdf");
		// fileOut.close();
		// out.close();
		// System.out.println("gggggggggggg");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
