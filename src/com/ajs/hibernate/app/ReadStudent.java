package com.ajs.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajs.hibernate.entity.Student;

public class ReadStudent {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml") 
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{ 
			
			System.out.println("Creating New Student Object");
			Student tempStudent = new Student("Sami", "Salt","sami@gmail.com");
			session.beginTransaction();
			System.out.print("Saving The Student");
			session.save(tempStudent);		
			session.getTransaction().commit();
			System.out.print("Done");
			System.out.print("StudentId: " + tempStudent.getId());
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n Getting Student with Id: "+ tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.print("Student: " + myStudent);
			session.getTransaction().commit();
			
			
		}
		finally{
			factory.close();
		}

	}

}

