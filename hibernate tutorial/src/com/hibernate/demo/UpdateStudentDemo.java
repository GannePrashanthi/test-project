package com.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Hibernatedemo;

public class UpdateStudentDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernatedemo.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	int studentId=5;
	//find out the student's id:primary
	System.out.println("saved student.GenerateedId:"+studentId);
	//now get a new session and start the transaction
	session=factory.getCurrentSession();
	session.beginTransaction();
	
	//retrieve student based on student's id 
	System.out.println("\ngetting student with Id"+studentId);
	Hibernatedemo stuudnt=session.get(Hibernatedemo.class,studentId);
	System.out.println("updating the student");
	stuudnt.setFirstname("Shanti");
	
	//update all student emailids
	System.out.println("updating all students to nandhu@gmail.com");
	session.createQuery("update Hibernatedemo set email='nandhu@gmail.com'").executeUpdate();
	//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
factory.close();
}

}
}
