package com.firstomfys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationsApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationOfJdbc.class);
		JdbcTemplate jdbcTemp = context.getBean(JdbcTemplate.class);

		//Insert Operation
		String std_rollno="101";
		String std_name = "Charuli";
		float std_marks = 98.5f;

		String insert_query = "INSERT INTO Student VALUES (?,?,?)";
		int count = jdbcTemp.update(insert_query,std_rollno, std_name,std_marks);

		if(count>0) 
			System.out.println("Insertion Successfull..!");
		else
			System.out.println("Insertion failed..!!");

	}

}
