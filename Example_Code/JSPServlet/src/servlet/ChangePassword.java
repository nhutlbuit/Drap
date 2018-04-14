package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Change Password</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
		
		HttpSession session = request.getSession(true);
		String userName = (String) session.getAttribute("user-name");
		String password = (String) session.getAttribute("password");
		
		String oldPass = request.getParameter("old_password");
		String newPass = request.getParameter("new_password");
		String againPass = request.getParameter("again_password");
		
		
		
		
		if (password.equals(oldPass) && newPass.equals(againPass)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fresher_training","root", "root");
				
				Statement s = con.createStatement();
				
				String sql = "UPDATE users " +
							 "SET password='" + newPass + "'" +
							 "WHERE username='" + userName + "'";
				s.executeUpdate(sql);
				out.print("<h4>Password was changed!</h4>");
				out.print("<br><br>");
				out.print("<a href=index.jsp>Go Home Page</a>");
			} catch(SQLException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Driver not found");
				e.printStackTrace();
			}
		}
		else {
			out.print("<h4>Fail! Try again.</h4>");
			out.print("<br><br>");
			out.print("<a href=change_password.jsp>Go back</a>");
			out.print("<br><br>");
			out.print("<a href=index.jsp>Go Home Page</a>");
		}
		
		
		
		
	}

}
