package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import model.Address;
import model.Score;
import model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private SessionFactory sessionFactory;

	
	@Override
	public void create(Student student) {
		Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
	}

	@Override
	public Student getStudent(Integer id) {
		Session session = getSessionFactory().openSession();
		Student student = (Student) session.get(Student.class, id);
		session.close();
		return student;
	}

	@Override
	public List<Student> listStudents() {
		Session session = getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student").list();
        session.close();
        return list;
	}

	@Override
	public void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Address address = (Address) session.get(Address.class, id);
		Student student = (Student) session.get(Student.class, id);
		session.delete(address);
		session.delete(student);
		tx.commit();
		session.close();
	}

	@Override
	public void update(Student student) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(student);;
		tx.commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> getStudentByName(String name) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Student where firstname= :code or lastname= :code");
		query.setParameter("code", name);
        List<Student> list = query.list();
        session.close();
        return list;
	}

	@Override
	public List getStudentByUser(String user) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Student where username= :code ");
		query.setParameter("code", user);
        List<Student> list = query.list();
        return list;
	}
	
		
}
