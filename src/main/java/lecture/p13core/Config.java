package lecture.p13core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public Servlet servlet() {
		return new Servlet();
	}
	@Bean
	public Dao dao() {
		return new Dao();
	}
}
