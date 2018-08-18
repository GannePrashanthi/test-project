package com.hibernate.demo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.hibernate.jdbc.Hibernatedemo;

public class QueryStudentDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hibernatedemo.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	
		//start the transaction
	session.beginTransaction();
	//query student
	 List<Hibernatedemo> theStudents =session.createQuery("from Hibernatedemo").list();
	
	 //display the students
	 showstudent(theStudents);
	 
	 
	 //create the students whose last name=p
	 theStudents=session.createQuery("from Hibernatedemo s where s.lastname='P'").list();
	 
	 //display the students
	 System.out.println("\n\nstudents whose last name is P");
	 showstudent(theStudents);
	 
	 //create the query from students whose last name ='p' or firstname=prashanthi
	 theStudents=session.createQuery("from Hibernatedemo s where s.lastname='P' or s.firstname='Prashanthi'").list();
	 
	 //display the students
	 System.out.println("\n\nstudents whose last name is P or firstname is prashanthi");
	 showstudent(theStudents);
	 
	 //create the query from students whose email like %08@gmail.com
	 theStudents=session.createQuery("from Hibernatedemo s where email LIKE'%08@gmail.com'").list();
		
	 //display the students
	 System.out.println("\n\nstudents whose last name is P or firstname is prashanthi");
	 showstudent(theStudents);
	 
	 
	 //commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
factory.close();
}

}

private static void showstudent(List<Hibernatedemo> theStudents) {
	for(Hibernatedemo student:theStudents) {
		 System.out.println(student);
	 }
}
}
