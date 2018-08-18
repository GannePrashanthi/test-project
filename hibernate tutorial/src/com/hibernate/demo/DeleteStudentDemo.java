package com.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Hibernatedemo;

public class DeleteStudentDemo {
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
	
	
	System.out.println("\ngetting student with Id"+studentId);
	Hibernatedemo stuudnt=session.get(Hibernatedemo.class,studentId);
	 
	//delete the record
	System.out.println("deleting the record");
	session.delete(stuudnt);
	
	//deleting the records process2 id=2
	//System.out.println("deleting the record id=2");
	//session.createQuery("delete from Hibernatedemo  where id=3").executeUpdate();
	
	//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
factory.close();
}

}
}
