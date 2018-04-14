package BT;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
	
	public int AvgScore(Student student) throws ClassNotFoundException, SQLException {
	
		StudentDao stdao = new StudentDao();
		student = stdao.getStudent().get(0);
		int avgscore = 0;
		int sum = 0, count = 0;
		for (String key : student.getScore().keySet()) {
				if(isNumeric(String.valueOf(student.getScore().get(key)))!=0)
				{
					sum += student.getScore().get(key);
					count++;
				}
			}
		avgscore = sum / count;

		return avgscore;
	}
	
	public static int isNumeric(String str)  
	{ 
		int d;
	  try  
	  {  
		   d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
		  return 0;  
	  }  
	  return d;  
	}
}
