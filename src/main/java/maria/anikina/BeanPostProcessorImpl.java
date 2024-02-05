package maria.anikina;

import maria.anikina.model.Student;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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
