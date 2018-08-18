package com.hibernate.demo3;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc3.Course;
import com.hibernate.jdbc3.Instructor;
import com.hibernate.jdbc3.InstructorDetail;

public class CreateInstructorDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	    //create objects
	Instructor tempinstructor=new Instructor("naveena","reddy","naveena@gmail.com");
	InstructorDetail tempinstructordetail=new InstructorDetail("http://www.youtube.com/youTube","sports");

	
	
	//associate the objects
	 tempinstructor.setInstructordetailid(tempinstructordetail);
	
		//start the transaction
	session.beginTransaction();
	
	//save the transaction
	System.out.println("saving the transaction");
	session.save(tempinstructor);
	
	
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
