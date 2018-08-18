package com.hibernate.demo1;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.hibernate.jdbc1.Instructor;
import com.hibernate.jdbc1.InstructorDetail;

public class CreateDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	    //create objects
	//Instructor tempinstructor=new Instructor("tanu","g","gannetanusha@gmail.com");
	//InstructorDetail tempinstructordetail=new InstructorDetail("http://www.luv2code.com/youTube","luv2code");
	
	Instructor tempinstructor=new Instructor("rupa","g","rupa@gmail.com");
	InstructorDetail tempinstructordetail=new InstructorDetail("http://www.w3schools.com/youTube","w3schools");
	
	
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
factory.close();
}

}
}
