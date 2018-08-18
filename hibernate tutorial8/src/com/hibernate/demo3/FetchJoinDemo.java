package com.hibernate.demo3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.jdbc3.Course;
import com.hibernate.jdbc3.Instructor;
import com.hibernate.jdbc3.InstructorDetail;
import com.hibernate.jdbc3.Review;


public class FetchJoinDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	
		//start the transaction
	session.beginTransaction();
	    //option:2 Hibernate query with HQL
	Query<Instructor> query=session.createQuery("Select i from Instructor i "+"JOIN FETCH i.courses "+"Where i.id=:theInstructorId",
									                                Instructor.class);
	//set parameter on query
	query.setParameter("theInstructorId",10);
	//execute the query and get the instructor
	Instructor tempinstructor=query.getSingleResult();
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
