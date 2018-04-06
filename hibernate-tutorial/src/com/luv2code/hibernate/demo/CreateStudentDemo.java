package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			 
			 //create the student object
			 Student tempStudent=new Student("venkataswamy","budige","venkataswamy611@gmail.com");
			 
			 //start the transaction
			 session.beginTransaction();
			 
			 //save the student object
			 System.out.println("saving the student.......");
			 session.save(tempStudent);
			 
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
			 
			
		} finally {
			factory.close();
			
		}
	}

}
