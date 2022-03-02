package tn.esprit.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableBatchProcessing
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class AzizPiApplication {
	@Autowired
    JobLauncher jobLauncher;
      
    @Autowired
    Job job;

	public static void main(String[] args) {
		SpringApplication.run(AzizPiApplication.class, args);
	}
	
	 @Scheduled(cron = "*/1 * * * * ?")
	    public void perform() throws Exception
	    {
	        JobParameters params = new JobParametersBuilder()
	                .addString("JobID", String.valueOf(System.currentTimeMillis()))
	                .toJobParameters();
	        System.out.println("**************");
	        jobLauncher.run(job, params);
	    }

}
