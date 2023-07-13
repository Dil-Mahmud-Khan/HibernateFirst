package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascaseExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		
		Question q1=new Question();
		
		q1.setQuestionId(4);
		q1.setQuestion("What is java?");
		
		Answer a1=new Answer(12,"This is core java language");
		Answer a2=new Answer(13,"This has some frameworks");
		Answer a3=new Answer(14,"Springboot is mostly used framework");
		
		List<Answer> answers=new ArrayList<Answer>();
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);

		q1.setAnswers(answers);
		
		
		Transaction tx=session.beginTransaction();
		session.save(q1);
		
		
		tx.commit();
		session.close();
		sessionFactory.close();
	}
}
