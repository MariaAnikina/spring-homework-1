package maria.anikina.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component("teacherBean")
public class Teacher {
	@Value("Pirogov Pavel Ivanovich")
	private String fullName;
	private List<Student> students;

	public Teacher(List<Student> students) {
		this.students = students;
	}
}
