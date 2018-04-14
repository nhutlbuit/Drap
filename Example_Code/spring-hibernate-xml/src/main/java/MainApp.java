import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.StudentDAO;
import model.Student;
import services.StudentService;
import services.StudentServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		StudentService stusv = (StudentService)context.getBean("studentService");
		stusv.avg();
		
	}

}
