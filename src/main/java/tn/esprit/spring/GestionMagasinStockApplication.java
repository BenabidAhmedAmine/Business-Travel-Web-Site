package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAspectJAutoProxy
@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class GestionMagasinStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionMagasinStockApplication.class, args);
	}
}
