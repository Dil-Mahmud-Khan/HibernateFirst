package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.HIbernateFirst.Certificate;
import com.tut.HIbernateFirst.Student;


public class StateDemo {

	public static void main(String[] args) {
		//Transient
		//persistent
		//detached
		//removed
		
		System.out.println("Okkkk");
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student student=new Student();
		student.setId(2);
		student.setCity("Bogura");
		student.setName("Mahamud");
		student.setCertificate(new Certificate("Hibernate","2 Months"));
		//now it is in transient
		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(student);
		
		//now in persistent(session,database)
		student.setName("Tommy Shelby");
		tx.commit();
		session.close();
		//detached phase
		factory.close();
		
	}
}
