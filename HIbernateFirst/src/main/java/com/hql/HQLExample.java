package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.HIbernateFirst.Student;


public class HQLExample {
	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		 
		Session s=factory.openSession();
		
		String query="from Student";	//"from Student where city='Dhaka'";

	//	String query2="from Student as s where city=:x and s.name=:n";
		
		Query q = s.createQuery(query);
		
//		q.setParameter('x', "Dhaka");			//scanner kore
//		q.setParameter('n',"Dil");
		
		List<Student> list=q.list();
		for(Student student:list) {
			System.out.println(student.getName());
		}
		
		
		System.out.println("---------------------------");
		//delte query
		Query query2=s.createQuery("delete from Student s where s.city=:c");
		
		query2.setParameter("c", "Dhaka");
		
		int r=query2.executeUpdate();
		System.out.println("Deleted");
		System.out.println(r);
		
		//update query
		s.createQuery("update Student set city=:c where name=:n");
		query2.setParameter("c","Dhaka");
		query2.setParameter("n", "Tommy");
		
		int x=query2.executeUpdate();
		System.out.println(x+"Objects Updated");
		
		System.out.println("---------------------------");

		
		
		//Execute join query
		
		Query query3=s.createQuery("select q.question, q.questionId, a.answer form Question as q INNER JOIN q.answers as a");
		List<Object[]> list3=query3.getResultList();
		
		for(Object[] arr:list3) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		s.close();
		factory.close();
	}
}
