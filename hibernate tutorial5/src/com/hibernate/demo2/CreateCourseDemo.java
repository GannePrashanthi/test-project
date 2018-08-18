package com.hibernate.demo2;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc2.Course;
import com.hibernate.jdbc2.Instructor;
import com.hibernate.jdbc2.InstructorDetail;

public class CreateCourseDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	
		//start the transaction
	session.beginTransaction();
	
	    //get instructor id from db
	Instructor tempinstructor=session.get(Instructor.class, 1);
	
	    //create some courses for to save in db
	Course tempcourse1=new Course("Air guitar-The Ultimate Guide");
	Course tempcourse2=new Course("Pin Ball Master Class");
	
	    //add the courses to the instructor
	tempinstructor.add(tempcourse1);
	tempinstructor.add(tempcourse2);
	
	    //save the transaction
	session.save(tempcourse1);
	session.save(tempcourse2);
	
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
