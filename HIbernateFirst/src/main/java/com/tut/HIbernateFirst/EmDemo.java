package com.tut.HIbernateFirst;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		
			Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory=cfg.buildSessionFactory();
	        
	        Student student1=new Student();
	        student1.setId(6);
	        student1.setName("Mahmud");
	        student1.setCity("Barishal");
	        

	        
	        Certificate certificate=new Certificate();
	        certificate.setCourse("OOP");
	        certificate.setDuration("2 Month");
	        student1.setCertificate(certificate);
	        
	        Student student2=new Student();
	        student2.setId(8);
	        student2.setName("Khan");
	        student2.setCity("Noakhali");
	        
	        Certificate certificate1=new Certificate();
	        certificate1.setCourse("AOP");
	        certificate1.setDuration("3 Month");
	        student2.setCertificate(certificate1);
	        
	        
	        Session session=factory.openSession();
	        Transaction tx=session.beginTransaction();
	        
	        
	        session.save(student1);
	        session.save(student2);
	        
	        tx.commit();
	        session.close();
	        factory.close();
	        
	        
	}
}
