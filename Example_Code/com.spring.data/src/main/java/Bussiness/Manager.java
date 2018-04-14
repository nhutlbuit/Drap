package Bussiness;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;


public class Manager {
	private StudentService student;
	public Manager() {}
	public Manager(StudentService student) {
		this.student = student;
	}

	public StudentService getStudent() {
		return student;
	}

	//@Autowired
	public void setStudent(StudentService student) {
		this.student = student;
	}

	/*public int AvgScore(Student student) {
		int avgscore = 0;
		int sum = 0, count = 0;
		for (String key : student.getScore().keySet()) {
			sum += student.getScore().get(key);
			count++;
		}
		avgscore = sum / count;

		return avgscore;
	}*/

/*	public int AvgScore() {
		int avgscore = 0;
		int sum = 0, count = 0;
		for (String key : student.getScore().keySet()) {
			sum += student.getScore().get(key);
			count++;
		}
		avgscore = sum / count;

		return avgscore;
	}*/
	public int AvgScore() throws ClassNotFoundException, SQLException {
		
		return student.avgScore();
	}
}
