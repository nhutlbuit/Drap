package dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BT.ConnectionDB;
import BT.Student;

public class StudentDaoImpl {
	public List<Student> getStudent() throws ClassNotFoundException, SQLException
	{
		ConnectionDB con = new ConnectionDB();
		String sql = "select * from students";
		Connection conn = con.Connect();
		Statement statement =  conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		List<Student> lst = new ArrayList();
		while(result.next())
		{
			Map<String,Integer> scores = new HashMap<String, Integer>();
			Student st= new Student();
			String id = result.getString("student_id");
			String name = result.getString("fullname");
			String score = result.getString("score");
			String score1 = result.getString("score1");
			String score2 = result.getString("score2");
			String score3 = result.getString("score3");
			
			System.out.println(id +" "+name+" "+score);
			st.setFname(name);
			st.setLname(name);
			scores.put("1", Integer.parseInt(score));
			scores.put("2", Integer.parseInt(score1));
			scores.put("3", Integer.parseInt(score2));
			scores.put("4", Integer.parseInt(score3));
			
			
			
			st.setScore(scores);
			lst.add(st);
		}
		
		result.close();
		statement.close();
		conn.close();
		return lst;
	}
}
