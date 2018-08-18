package com.hibernate.demo2;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc2.Instructor;
import com.hibernate.jdbc2.InstructorDetail;

public class DeleteDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	    
		//start the transaction
	session.beginTransaction();
	
	//get the Instructor by using primary key
	Instructor i=session.get(Instructor.class,1);
	
	//delete the Instructor
	session.delete(i);
	
		//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
factory.close();
}

}
}
