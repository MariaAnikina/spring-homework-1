package maria.anikina.config;

import maria.anikina.BeanPostProcessorImpl;
import maria.anikina.model.Student;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("maria.anikina.model")
public class ConfigFile {
	@Bean
	public Student studentBean1() {
		Map<String, Integer> assessments = new HashMap<>();
		assessments.put("Математика", 5);
		assessments.put("Русский язык", 4);
		assessments.put("Физика", 3);
		return new Student("Pupkin Vasily Petrovich", assessments, false);
	}

	@Bean
	public Student studentBean2() {
		Map<String, Integer> assessments = new HashMap<>();
		assessments.put("Математика", 3);
		assessments.put("Русский язык", 3);
		assessments.put("Физика", 2);
		return new Student("Jil", assessments, false);
	}

	@Bean
	public Student studentBean3() {
		Map<String, Integer> assessments = new HashMap<>();
		assessments.put("Математика", 4);
		assessments.put("Русский язык", 4);
		assessments.put("Физика", 3);
		return new Student("Orlov Orel Evgenievich", assessments, false);
	}

	@Bean
	public static BeanPostProcessor beanPostProcessorBeanImpl() {
		return new BeanPostProcessorImpl();
	}
}
