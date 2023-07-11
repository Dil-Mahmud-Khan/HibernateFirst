package com.tut.HIbernateFirst;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        Student student= session.get(Student.class, 3);
        System.out.println(student);
        
        
        Address address=session.get(Address.class, 1);
        System.out.println(address);
        
        session.close();
        factory.close();
	}
}
