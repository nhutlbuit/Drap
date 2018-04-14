package Model;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.DAOFactory;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;

public class Student {

	private String Fname;
	private String Lname;
	Map<String,Integer> Score;
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public Map<String, Integer> getScore() {
		return Score;
	}
	public void setScore(Map<String, Integer> score) {
		Score = score;
	}
	
	
}
