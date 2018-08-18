package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Hibernatedemo;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernatedemo.class).buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();

	try {
		//use session object to save object
		//create  3 hibernate demo objects
		System.out.println("creating student(hibernatedemo)object");
		Hibernatedemo student1=new Hibernatedemo("nandhu","P","nandhup@gmail.com");
		Hibernatedemo student2=new Hibernatedemo("lakshmi","Ganne","lakshmi@gmail.com");
		Hibernatedemo student3=new Hibernatedemo("sree","Ganne","sree@gmail.com");
		
			//start the transaction
		session.beginTransaction();
		
		//save the (student )object
		System.out.println("saving the student object");
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
			//commit the transaction
		session.getTransaction().commit();
		System.out.println("done");
	}


	finally {
	factory.close();
	}

	}

}
