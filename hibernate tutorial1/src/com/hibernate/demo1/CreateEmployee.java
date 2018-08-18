package com.hibernate.demo1;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc1.Employee;

public class CreateEmployee {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	//use session object to save object
	//create employee class object
	System.out.println("creating Employee object");
	
	Employee employee5=new Employee("yash","T","Infosys");
	
		//start the transaction
	session.beginTransaction();
	
	//save the (student )object
	System.out.println("saving the employee object");
	session.save(employee5);
	
		//commit the transaction
	session.getTransaction().commit();
	System.out.println("done");
}


finally {
factory.close();
}

}
}
