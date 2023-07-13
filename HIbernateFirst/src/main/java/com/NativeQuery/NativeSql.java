package com.NativeQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class NativeSql {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		//this code will work when data is already 
		//inserted into db
		
		String q="select * from Student";
		
		NativeQuery n=session.createSQLQuery(q);
		
		List<Object[]> list=n.list();
		for(Object[] student: list) {
			System.out.println(student[4]+":"+student[3]);
			
		}
	
		session.close();
		sessionFactory.close();
	}
}
