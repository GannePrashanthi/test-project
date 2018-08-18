package com.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Hibernatedemo;

public class ReadStudentDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernatedemo.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	//use session object to save object
	//create hibernate demo object
	System.out.println("creating student(hibernatedemo)object");
	Hibernatedemo student=new Hibernatedemo("tanusha","Ganne","tanu08@gmail.com");
	
		//start the transaction
	session.beginTransaction();
	
	//save the (student )object
	System.out.println("saving the student object");
	System.out.println(student);
	session.save(student);
	
		//commit the transaction
	//session.getTransaction().commit();
	//my new code
	//find out the student's id:primary
	System.out.println("saved student.GenerateedId:"+student.getId());
	//now get a new session and start the transaction
	//session=factory.getCurrentSession();
	//session.beginTransaction();
	
	//retrieve student based on student's id 
	System.out.println("\ngetting student with Id"+student.getId());
	Hibernatedemo stuudnt=session.get(Hibernatedemo.class,student.getId());
	System.out.println("get complete"+stuudnt);
	
	//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
factory.close();
}

}
}
