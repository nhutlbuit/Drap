package services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StudentDAO;
import dao.StudentDaoImpl;
import model.Score;
import model.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public void avg() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

		StudentDAO studentDao = new StudentDaoImpl();//(StudentDAO) context.getBean("studentDao");

		List<Student> students = studentDao.listStudents();
		for (Student s : students) {
			System.out.println(s.getFirstName() + " " + s.getLastName() + " co diem trung binh la: " + getAvg(s));
		}

	}

	public int getAvg(Student student) {
		int sum = 0;
		for (Score i : student.getScore()) {
			sum += i.getScore();
		}
		return sum / (student.getScore().size());
	}
}
