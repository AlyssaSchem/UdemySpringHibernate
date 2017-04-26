package com.ajs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajs.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml") 
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{ 
			
			System.out.println("Creating New Student Object");
			Student tempStudent = new Student("Paul", "Smith","paul@gmail.com");
			session.beginTransaction();
			System.out.print("Saving The Student");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			System.out.print("Done");
			
			
		}
		finally{
			factory.close();
		}

	}

}
