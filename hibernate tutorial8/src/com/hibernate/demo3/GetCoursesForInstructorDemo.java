package com.hibernate.demo3;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc3.Course;
import com.hibernate.jdbc3.Instructor;
import com.hibernate.jdbc3.InstructorDetail;
import com.hibernate.jdbc3.Review;

public class GetCoursesForInstructorDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	    

		//start the transaction
	session.beginTransaction();
	//get instructor 
	Instructor tempinstructor=session.get(Instructor.class,3);
	//get the courses for the instructor
	System.out.println("courses are:"+tempinstructor.getCourses());
	
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
