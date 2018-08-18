package com.hibernate.demo1;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc1.Course;
import com.hibernate.jdbc1.Instructor;
import com.hibernate.jdbc1.InstructorDetail;

public class GetInstructorCoursesDemo {
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
	System.out.println("instructoer details:"+tempinstructor);
	
	    //get courses details from instructor
	System.out.println("courses details are:"+tempinstructor.getCourses());
	
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
