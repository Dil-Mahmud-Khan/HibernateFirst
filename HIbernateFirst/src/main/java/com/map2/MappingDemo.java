package com.map2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MappingDemo {
	public static void main(String[] args) {
		Configuration cfgConfiguration=new Configuration();
		cfgConfiguration.configure("hibernate.cfg.xml");
		SessionFactory factory=cfgConfiguration.buildSessionFactory();
		
		Emp e1=new Emp();
		e1.setEid(1);
		e1.setName("dil");
		
		Emp e2=new Emp();
		e2.setEid(2);
		e2.setName("Mahmud");
		
		Project p1=new Project();
		p1.setId(101);
		p1.setProjectName("Treasury");
		
		Project p2=new Project();
		p2.setId(102);
		p2.setProjectName("EKYC");
		
		
		//creating list 
		
		List<Emp> list1=new ArrayList<Emp>();
		List<Project>list2=new ArrayList<Project>();
		
		//assigning project
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		
		Session session=factory.openSession();
		Transaction txTransaction=session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		
		txTransaction.commit();
		session.close();
		factory.close();
	}
}
