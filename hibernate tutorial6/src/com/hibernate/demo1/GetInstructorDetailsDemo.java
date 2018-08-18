package com.hibernate.demo1;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.hibernate.jdbc1.Instructor;
import com.hibernate.jdbc1.InstructorDetail;

public class GetInstructorDetailsDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	    
	int id=3;
		//start the transaction
	session.beginTransaction();
	    //get the instructor detail object
	InstructorDetail instructordetail=session.get(InstructorDetail.class,id);
	    //print the Instructor detail
	System.out.println("instructor detail is:"+instructordetail);
	    //print the assocaited Instructor
	System.out.println("associated details are:"+instructordetail.getInstructor());
	
		//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}
catch(Exception ex) {
	ex.printStackTrace();
}


finally {
session.close();
factory.close();
}

}
}
