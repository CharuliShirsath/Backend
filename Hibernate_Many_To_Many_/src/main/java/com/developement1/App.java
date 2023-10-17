package com.developement1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration config = new Configuration().configure()
				 					.addAnnotatedClass(Student_1.class)
				 					.addAnnotatedClass(Batch.class);
	 SessionFactory sf= config.buildSessionFactory();
	 Session session = sf.openSession();

	 session.beginTransaction();
	 //--------------------------------------------------------
	 Student_1 s =new Student_1();
	 s.setRollno(11);
	 s.setName("Charu");
	 s.setAddress("Nashik");
	 
	 Student_1 s1 =new Student_1();
	 s1.setRollno(12);
	 s1.setName("Ganesh");
	 s1.setAddress("Pune");
	 
	 Batch b = new Batch();
	 b.setId(101);
	 b.setType("FullStack");
	 b.setName("Hawthorn");
	 
	 Batch b1 = new Batch();
	 b1.setId(101);
	 b1.setType("UI");
	 b1.setName("Carnition");
	 
	List<Batch>batches = Arrays.asList(b,b1);
	s.setBatches(batches);
	s1.setBatches(batches);
	
	session.save(s);
	session.save(s1);
	session.save(b);
	session.save(b1);
	 //--------------------------------------------------------
	 
	 session.getTransaction().commit();
	 session.close();
    }
}
