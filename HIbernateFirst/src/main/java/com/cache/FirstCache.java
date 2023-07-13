package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.HIbernateFirst.Student;

public class FirstCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Student student=session.get(Student.class, 1);
		System.out.println(student);
		
		System.out.println("It Works");
		
		Student student1=session.get(Student.class, 1);
		System.out.println(student1);
		
		
		//it checks if there is already an object here or not
		System.out.println(session.contains(student1));
		
		session.close();
	}

}
