package tn.esprit.spring.config;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import tn.esprit.spring.Service.ConsoleItemWriter;
import tn.esprit.spring.entity.User;
 

 
@Configuration
@EnableBatchProcessing
public class BatchConfig 
{
  @Autowired
  private JobBuilderFactory jobBuilderFactory;
   
  @Autowired
  private StepBuilderFactory stepBuilderFactory;
 
  @Bean
  public Job readCSVFilesJob() {
	    return jobBuilderFactory
	        .get("readCSVFilesJob")
	        .incrementer(new RunIdIncrementer())
	        .start(step1())
	        .build();
	  }
	 
	  @Bean
	  public Step step1() {
	    return stepBuilderFactory.get("step1").<User, User>chunk(5)
	        .reader(reader())
	        .writer(writer())
	        .build();
	  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Bean
  public FlatFileItemReader<User> reader() 
  {
    //Create reader instance
    FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
     
    //Set input file location
    reader.setResource(new FileSystemResource("input/inputData.csv"));
     
    //Set number of lines to skips. Use it if file has header rows.
    reader.setLinesToSkip(1);   
     
    //Configure how each line will be parsed and mapped to different values
    reader.setLineMapper(new DefaultLineMapper() {
      {
        //3 columns in each row
        setLineTokenizer(new DelimitedLineTokenizer() {
          {
            setNames(new String[] { "id", "firstName", "lastName" });
          }
        });
        //Set values in Employee class
        setFieldSetMapper(new BeanWrapperFieldSetMapper<User>() {
          {
            setTargetType(User.class);
          }
        });
      }
    });
    return reader;
  }
  
  @Bean
  public ConsoleItemWriter<User> writer() 
  {
    return new ConsoleItemWriter<User>();
  }

}
