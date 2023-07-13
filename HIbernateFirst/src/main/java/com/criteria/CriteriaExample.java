package com.criteria;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tut.HIbernateFirst.Student;
import org.hibernate.criterion.Restrictions;

public class CriteriaExample {
	
	//faced some problem while doing this functionality
	
	
//	Session session=new Configuration().configure().buildSessionFactory().openSession();
//	
//	Criteria c=session.createCriteria(Student.class);
//	
//	//this is how we filter codes
//	//c.add(Restrictions.eq("certi.course","Java"));
//	
//	//c.add(Restriction.like("certi.course","Java%"));
//	
//	List<Student> students=c.list();
//	
//	for(Student st: students) {
//		System.out.println(st);
//	}
//	session.close();

}
