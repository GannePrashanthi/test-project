package com.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc.Hibernatedemo;

public class CreateStudentDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernatedemo.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	//use session object to save object
	//create hibernate demo object
	System.out.println("creating student(hibernatedemo)object");
	Hibernatedemo student=new Hibernatedemo("Prashanthi","Ganne","prashanthichowdary@gmail.com");
	
		//start the transaction
	session.beginTransaction();
	
	//save the (student )object
	System.out.println("saving the student object");
	session.save(student);
	
		//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
factory.close();
}

}
}
