package maria.anikina.model;

import lombok.*;

import javax.annotation.PostConstruct;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
	private String fullName;
	private Map<String, Integer> assessments;
	private boolean enrolled;

	@PostConstruct
	public void initIsEnrolled() {
		Integer sumMark = 0;
		Integer numberMarks = 0;
		for (Integer mark : assessments.values()) {
			sumMark += mark;
			numberMarks++;
		}
		setEnrolled(sumMark/numberMarks >= 3);
	}
}
