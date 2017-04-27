package com.ajs.hibernate.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ajs.hibernate.entity.Student;

public class QueryStudent {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

			System.out.print("\n\n Students with the Last Name Doe");
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName ='Sally'").getResultList();
			
			

			session.getTransaction().commit();
			System.out.print("Done");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}
