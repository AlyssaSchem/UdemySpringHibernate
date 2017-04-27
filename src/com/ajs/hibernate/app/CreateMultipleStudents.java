package com.ajs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajs.hibernate.entity.Student;

public class CreateMultipleStudents {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml") 
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{ 
			
			System.out.println("Creating New Student Object");
			Student tempStudent = new Student("Paul", "Smith","paul@gmail.com");
			Student tempStudent2 = new Student("Sally", "Johnson","sally@gmail.com");
			Student tempStudent3 = new Student("Lary", "Marvin","lary@gmail.com");
			Student tempStudent4 = new Student("John", "Doe","john@gmail.com");
			session.beginTransaction();
			System.out.print("Saving The Student");
			session.save(tempStudent);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			
			session.getTransaction().commit();
			System.out.print("Done");
			
			
		}
		finally{
			factory.close();
		}

	}

	}

