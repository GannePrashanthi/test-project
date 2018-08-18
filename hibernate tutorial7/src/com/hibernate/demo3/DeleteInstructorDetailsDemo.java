package com.hibernate.demo3;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc3.Instructor;
import com.hibernate.jdbc3.InstructorDetail;

public class DeleteInstructorDetailsDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	    
	int id=5;
		//start the transaction
	session.beginTransaction();
	    //get the instructor detail object
	InstructorDetail instructordetail=session.get(InstructorDetail.class,id);
	    //print the Instructor detail
	System.out.println("instructor detail is:"+instructordetail);
	    //print the associated Instructor
	System.out.println("associated details are:"+instructordetail.getInstructor());
	     //delete the instructor details
	System.out.println("deleting the instructor detials"+instructordetail);
	    //delete the associated object details
		//break the bidirectional link
	instructordetail.getInstructor().setInstructordetailid(null);
	session.delete(instructordetail);
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
