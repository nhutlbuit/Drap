package Bussiness;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//Student student= (Student) context.getBean("student");
		Manager obj = (Manager) context.getBean("managerBean");
		//System.out.println(obj.AvgScore(student));
		
		try {
			System.out.println("Diem Trung Binh La: "+obj.AvgScore());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
