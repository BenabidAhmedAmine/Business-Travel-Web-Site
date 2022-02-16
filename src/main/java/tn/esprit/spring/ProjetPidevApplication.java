package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//@EnableSwagger2
@EnableAspectJAutoProxy
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
public class ProjetPidevApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetPidevApplication.class, args);
	}

}
