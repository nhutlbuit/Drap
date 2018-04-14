package test.student.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(javax.servlet.ServletConfig servletConfig) {
		System.out.println("Init servlet.....");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		session.putValue("demosession", "this is session");
		String userName= request.getParameter("username");
		String password = request.getParameter("password");
		if("admin".equals(userName)&&"password".equals(password))
		{
			response.sendRedirect("loginsuccess.html");
		}
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Error Page</title>");
		
		out.print("</head>");
		out.print("<body>");
		out.print("<b> Username or Password is invalid!</b>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		doPost(request, response);
	}
}
