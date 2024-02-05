package maria.anikina;

import maria.anikina.model.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Student) {
			Student student = (Student) bean;
			if (student.getFullName().equals("Jil")) {
				for (String subject : student.getAssessments().keySet()) {
					student.getAssessments().put(subject, 5);
				}
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
