package BT;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

public class Manager {
	private Student student;
	public Manager() {}
	public Manager(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	//@Autowired
	public void setStudent(Student student) {
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
		
		return student.AvgScore(student);
	}
}
