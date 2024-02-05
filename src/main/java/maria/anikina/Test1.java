package maria.anikina;

import maria.anikina.model.Student;
import maria.anikina.model.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(Config.class);


		Teacher teacher1 = context.getBean("teacherBean", Teacher.class);
		getStudents(teacher1);
		Teacher teacher2 = context2.getBean("teacherBean", Teacher.class);
		getStudents(teacher2);

		Student student2 = context.getBean("student2", Student.class);
		System.out.println(student2);
		context.close();
		context2.close();
	}

	private static void getStudents(Teacher teacher) {
		System.out.println("Преподаватель: " + teacher.getFullName());

		System.out.println("Список студентов: ");
		for (Student student : teacher.getStudents()) {
			System.out.println(student);
		}
	}
}
