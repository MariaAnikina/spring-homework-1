package maria.anikina.model;

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

@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {


	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Student) {
			Student student = (Student) bean;
			if (student.getFullName().equals("Jil")) {
				student.setAssessments(new HashMap<>());
//				student.getAssessments().put("Математика", 5);
//				student.getAssessments().put("Русский язык", 5);
				student.getAssessments().put("Живопись", 5);
			}
		}
		return bean;
	}
}
