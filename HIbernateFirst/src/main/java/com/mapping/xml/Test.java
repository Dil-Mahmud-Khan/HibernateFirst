package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class Test {
public static void main(String[] args) {
	SessionFactory sessionFactory=new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session=sessionFactory.openSession();
	
	Person person=new Person(12,"Dil","York","343243");
	Transaction tx=session.beginTransaction();
	session.save(person);
	
	tx.commit();
	session.close();
	sessionFactory.close();
}
}
