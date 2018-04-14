package servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(true);
		out.println("<html>");
        out.println("<head>");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
      
		String userName = req.getParameter("user_name");
		String password = req.getParameter("password");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fresher_training","root", "root");
			
			Statement s = con.createStatement();
			
			String sql = "SELECT * FROM users"
					+ " WHERE username='" + userName +"'" +
					" AND password='" + password + "'";
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				session.setAttribute("user-name",userName);
				session.setAttribute("password", password);
				out.write("<h3>Login succeed!</h3>");
				out.write("<br><br>");
				out.write("<a href=index.jsp>Go Home Page</a>");
				rs.close();
				s.close();
				con.close();
			} else {
				out.write("<h3>Login failed! Check your username and password!</h3>");
				out.write("<br><br>");
				out.write("<a href=login.jsp>Go back</a>");
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		out.println("</center>");
		out.println("</body>");
        out.println("</html>");
		
	}
}
