package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create a Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//create a session
		Session session= factory.getCurrentSession();
		
		 try {
			 //start the transaction
			 session.beginTransaction();
			 //get the instructor detail object
			 
			 int id=3;
					 
			InstructorDetail tempinstructorDetail=session.get(InstructorDetail.class, id);
			 //print the associated instructor detail
			
			System.out.println("tempInstructorDetail:"+tempinstructorDetail);
			 
			 //print the associated instructor
			 System.out.println("the associated instructor"+tempinstructorDetail.getInstructor());
			 
			 //remove the associated object reference
			 //break bi-directional link
			 tempinstructorDetail.getInstructor().setInstructorDetail(null);
			 
			 System.out.println("deleting tempinstructorDetail........");
			 session.delete(tempinstructorDetail);
			 
			 //commit the transaction
			 session.getTransaction().commit();
			 
			 System.out.println("Done!");
		 }
			 catch (Exception e) {
				 e.printStackTrace();
			}
			finally {
			session.close();
			factory.close();
			
		}
	}

}
