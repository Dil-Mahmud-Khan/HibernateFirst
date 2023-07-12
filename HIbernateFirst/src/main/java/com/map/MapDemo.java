package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MapDemo {

	public static void main(String[] args) {
		Configuration cfgConfiguration=new Configuration();
		cfgConfiguration.configure("hibernate.cfg.xml");
		SessionFactory factory=cfgConfiguration.buildSessionFactory();
		
		Question question=new Question();
		question.setQuestionId(1);
		question.setQuestion("What is java");
		
		Answer answer=new Answer();
		answer.setAnswerId(2);
		answer.setAnswer("Is a programming languge");		
//		question.setAnswer(answer);
		answer.setQuestion(question);

		
		Answer answer1=new Answer();
		answer1.setAnswerId(22);
		answer1.setAnswer("For enteprise");		
//		question.setAnswer(answer);
		answer1.setQuestion(question);
		
		
		
		Answer answer2=new Answer();
		answer2.setAnswerId(222);
		answer2.setAnswer("For enteprise");		
//		question.setAnswer(answer);
		answer2.setQuestion(question);
		
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(answer2);
		list.add(answer);
		list.add(answer1);
		question.setAnswers(list);
		
		
		//for one to one
		
//		Question question1=new Question();
//		question1.setQuestionId(3);
//		question1.setQuestion("What is C");
//		
//		Answer answer1=new Answer();
//		answer1.setAnswerId(4);
//		answer1.setAnswer("Is a programming solving language");		
//		question1.setAnswer(answer1);
//		answer1.setQuestion(question1);


		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		//one to one
//		session.save(question);
//		session.save(question1);
//		session.save(answer);
//		session.save(answer1);
		
		
		//one to many
		session.save(question);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);
//		fetch one to one
//		Question qqQuestion=session.get(Question.class, 1);
//		System.out.println(qqQuestion.getQuestion());
//		System.out.println(qqQuestion.getAnswer().getAnswer());
//		
		
		//fetch one to many
		
//		Question question2=session.get(Question.class, 1);
//		System.out.println(question.getQuestion());
//		for(Answer a: question.getAnswers()) {
//			System.out.println(a.getAnswer());
//		}
		
		
		
		
		tx.commit();
		session.close();
		factory.close();
	}

}
