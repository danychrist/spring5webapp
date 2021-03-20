package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Spring5webappApplication.class, args);
		SpringApplication application = new SpringApplication(Spring5webappApplication.class);
		application.setDefaultProperties(Collections.singletonMap("server.port", "8888"));
		application.run(args);
	}
}
