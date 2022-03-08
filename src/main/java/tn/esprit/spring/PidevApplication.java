package tn.esprit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.Service.IComplaintsService;

@EnableSwagger2
@EnableAspectJAutoProxy
@EnableWebMvc
@EnableScheduling
@SpringBootApplication
public class PidevApplication {
	@Autowired
	IComplaintsService complaintService;
	
	public static void main(String[] args) {
		SpringApplication.run(PidevApplication.class, args);
	}
	/*@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		complaintService.sendMail();
	}*/
}
