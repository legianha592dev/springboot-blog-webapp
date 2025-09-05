package blog.webapp.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringbootBlogWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogWebappApplication.class, args);
	}

}
