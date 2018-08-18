package com.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.hibernate.jdbc1.Employee;

public class DeleteEmployee {
	public static void main( String[] args) {
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();

		try {
			//start session
            session=factory.getCurrentSession();			
			//begin transaction
			session.beginTransaction();
			//get employee object with primary key
			Employee emp=session.get(Employee.class,1);
			//delete employee query
			session.delete(emp);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("done");
			
			
		}
		
		finally {
			factory.close();
		}
	}

}
