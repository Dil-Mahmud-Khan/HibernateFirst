package com.cache;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.HIbernateFirst.Student;


public class SecondCache {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		Student student=session.get(Student.class, 1);
		System.out.println(student);
		
		session.close();
		
		
		
		Session session1=sessionFactory.openSession();
		Student student1=session1.get(Student.class, 1);
		System.out.println(student1);
		
		session.close();
		
	}
}
