package com.tut.HIbernateFirst;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "ProjectOne" );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        
        Student student=new Student();
        student.setCity("Dhaka");
        student.setId(3);
        student.setName("Dil");
        System.out.println(student);
        
        
        //Creating object of Address
        
        Address address=new Address();
        address.setAddedDate(new Date());;
        address.setAddressId(2);
        address.setCity("Tangail");
        address.setStreet("Road 3");
        address.setOpen(true);
        address.setX(343.234);
        
        FileInputStream fileInputStream=new FileInputStream("src/main/java/pic.jpeg");
        byte [] data= new byte[fileInputStream.available()];
        fileInputStream.read(data);
        address.setImage(data);
        
        
       Session session=factory.openSession();
       Transaction tx= session.beginTransaction();
       session.save(student);
       session.save(address);

       tx.commit();
       session.close();
       System.out.println("Done");
    }
}
