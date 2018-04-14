package Bussiness;

import java.sql.SQLException;

import Model.Student;
import dao.DAOFactory;
import dao.StudentDao;

public class StudentService {

	private StudentDao studentDao;

	public StudentService()
	{
		this.studentDao =DAOFactory.getStudentDao();
	}

	public int avgScore() throws ClassNotFoundException, SQLException {
		Student student = studentDao.getStudent().get(0);
		int avgscore = 0;
		int sum = 0, count = 0;
		for (String key : student.getScore().keySet()) {
			if (isNumeric(String.valueOf(student.getScore().get(key))) != 0) {
				sum += student.getScore().get(key);
				count++;
			}
		}
		avgscore = sum / count;

		return avgscore;
	}

	public static int isNumeric(String str) {
		int d;
		try {
			d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return 0;
		}
		return d;
	}
}
