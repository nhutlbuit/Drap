package until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
	public ConnectionDB() {

	}

	public Connection Connect() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fresher_training", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return conn;

	}

	
}
