package dao;

import dao.impl.StudentDaoImpl;

public class DAOFactory {

	public static StudentDao getStudentDao(){
		return new StudentDaoImpl();
	}
}
