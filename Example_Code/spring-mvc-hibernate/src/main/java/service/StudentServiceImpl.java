package service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.StudentDao;
import model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	@Qualifier("studentDao")
	private StudentDao dao;

	@Override
	public Student findById(int id) {
		return dao.getStudent(id);
	}

	@Override
	public void saveStudent(Student student) {
		dao.create(student);
	}

	@Override
	public void updateStudent(Student student) {
		dao.update(student);
	}

	@Override
	public void deleteStudentById(int id) {
		dao.delete(id);
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.listStudents();
	}

	@Override
	public List<Student> findStudentByName(String name) {
		return dao.getStudentByName(name);
	}

	@Override
	public int checkPass(String user, String pass) {
		List<Student> students = dao.getStudentByUser(user);
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getPassword().equalsIgnoreCase(pass))
				return students.get(i).getId();
		}
		return -1;
	}

}
