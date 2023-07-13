package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.HIbernateFirst.Student;

public class HqlPagination {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		
		Query query=session.createQuery("from Student");
		
		//implement pagination
		
		//before this there should be more than
		//5 data inserted into the database
		//in this db the data is not added so it won't be shown
		//this code is written to see it while necessary
		
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List<Student> list=query.list();
		
		for(Student st: list) {
			System.out.println(st.getId()+ " "+ st.getName());
		}
		
		session.close();
		factory.close();
		
	}
}
