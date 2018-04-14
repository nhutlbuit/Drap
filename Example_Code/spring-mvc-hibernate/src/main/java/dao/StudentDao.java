package dao;

import java.util.List;
import java.util.Map;

import model.Student;

public interface StudentDao {
	
	public void create(Student student);

	public Student getStudent(Integer id);

	public List<Student> listStudents();
	
	public List<Student> getStudentByName(String name);

	public void delete(Integer id);

	public void update(Student student);
	
	public List<Student> getStudentByUser(String user);
}
