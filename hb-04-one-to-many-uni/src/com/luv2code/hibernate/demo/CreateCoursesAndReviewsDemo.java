package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		//create a Session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		//create a session
		Session session= factory.getCurrentSession();
		
		 try {
			 session.beginTransaction();
			 
			Course tempCourse = new Course("Pacmen -How To Score One Million Points");

			tempCourse.addReview(new Review("Great course..........i loved it"));
			tempCourse.addReview(new Review("Good..........i loved it"));
			tempCourse.addReview(new Review("bullshit dont buy...i loved it"));

			System.out.println("Saving the course....");
			session.save(tempCourse);
			System.out.println(tempCourse.getReviews());
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
			 
			
		} finally {
			session.close();
			factory.close();
			
		}
	}

}
