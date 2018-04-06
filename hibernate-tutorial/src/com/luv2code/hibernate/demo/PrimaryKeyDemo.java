package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create a Session factory
				SessionFactory factory=new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				//create a session
				Session session= factory.getCurrentSession();
				
				 try {
					 //use the session object to save the java object
					 System.out.println("creating a new student object");
					 
					 //create 3 student objects
					 Student tempStudent1=new Student("parashuram","jurru","parashuram@gmail.com");
					 Student tempStudent2=new Student("pavan","kumar","pavan@gmail.com");
					 Student tempStudent3=new Student("shashi","kumar","shashi@gmail.com");
					 
					 //start the transaction
					 session.beginTransaction();
					 
					 //save the student object
					 System.out.println("saving the student.......");
					 session.save(tempStudent1);
					 session.save(tempStudent2);
					 session.save(tempStudent3);
					 
					 //commit the transaction
					 session.getTransaction().commit();
					 
					 System.out.println("Done!");
					 
					
				} finally {
					factory.close();
					
				}

		
		
	}

}
