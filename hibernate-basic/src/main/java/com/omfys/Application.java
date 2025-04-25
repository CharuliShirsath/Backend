package com.omfys;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.omfys.beans.Student;
import com.omfys.dao.StudentDao;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//		        try {
		            ApplicationContext ctx = ContextProvider.provideContext();
		            StudentDao studentDao = ctx.getBean("stDao", StudentDao.class);

//		            // Insert
//		            Student s = new Student(103, "Rajiv");
//		            studentDao.insert(s);
		            
		         // update 
//		            Student s=studentDao.getStudent(101); 
//		            s.setName("Priya"); 
//		            studentDao.update(s); 
		            
		            // get student
//		            Student s=studentDao.getStudent(101); 
//		            System.out.println("name of student is "+s); 
		            
		            //getAll
//		            studentDao.insert(new Student(104,"Danish")); 
//		            studentDao.insert(new Student(105,"Sneha")); 
		      
		            // getalluser
		            List<Student> students=studentDao.getAllStudents(); 
		            for(Student s:students) 
		            { 
		                System.out.println(s); 
		            } 
		            
		            // delete 
		            studentDao.delete(102);
		      
		            
//		        } catch (Exception e) {
//		            e.printStackTrace(); // Print stack trace for debugging
//		        }
		    }
		}
