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
					 .addAnnotatedClass(User.class)
					 .addAnnotatedClass(Document.class);
    	 SessionFactory sf= config.buildSessionFactory();
    	 Session session = sf.openSession();

    	 session.beginTransaction();
    	 //--------------------------------------------------------
    	 	User u=new User();
    	 	u.setId(101);
    	 	u.setName("Atish");
    	 	u.setAddress("Mumbai");
    	
    	 //---------------------------------------	
    	 	
    	 	
    	 	Document d = new Document();
    	 	d.setDoc_id(1);
    	 	d.setType("PANCARD");
    	 	d.setNumber("KD3344323");
    	 	session.save(d);
    	 	
    	 	Document d1 = new Document();
    	 	d1.setDoc_id(2);
    	 	d1.setType("ADHARCARD");
    	 	d1.setNumber("803423");
    	 	session.save(d1);
    	 	
    	 	List<Document> docs =new ArrayList();
    	 	docs.add(d);
    	 	docs.add(d1);
    	 	u.setDocument(docs);
    		session.save(u);
    		
    	 //--------------------------------------------------------
    	 session.getTransaction().commit();
    	 session.close();
    }
}
