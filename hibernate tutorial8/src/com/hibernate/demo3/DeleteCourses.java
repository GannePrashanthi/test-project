package com.hibernate.demo3;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc3.Course;
import com.hibernate.jdbc3.Instructor;
import com.hibernate.jdbc3.InstructorDetail;

public class DeleteCourses {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	
		//start the transaction
	session.beginTransaction();
	
	    //get the course
	Course tempcourse=session.get(Course.class,10);
	
	    //Delete the course
	session.delete(tempcourse);
	
		//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
	//add cleanup code
	session.close();
factory.close();
}

}
}
