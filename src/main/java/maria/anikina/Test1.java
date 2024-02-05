package maria.anikina;

import maria.anikina.config.ConfigFile;
import maria.anikina.model.Student;
import maria.anikina.model.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext contextXml = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext contextJava = new AnnotationConfigApplicationContext(ConfigFile.class);

		Teacher teacher1 = contextXml.getBean("teacherBean", Teacher.class);
		getStudents(teacher1);
		Teacher teacher2 = contextJava.getBean("teacherBean", Teacher.class);
		getStudents(teacher2);

		contextXml.close();
		contextJava.close();
	}

	private static void getStudents(Teacher teacher) {
		System.out.println("Преподаватель: " + teacher.getFullName());

		System.out.println("Список студентов: ");
		for (Student student : teacher.getStudents()) {
			System.out.println(student);
		}
	}
}
