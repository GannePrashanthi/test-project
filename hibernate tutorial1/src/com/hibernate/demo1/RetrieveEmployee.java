package com.hibernate.demo1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc1.Employee;


public class RetrieveEmployee {

	public static void main(String[] args) {
		
	
		//create session factory
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		//begin transaction
		session.beginTransaction();
			
        //retrieve
		Employee emp=session.get(Employee.class,1);
		System.out.println("get complete"+emp);
		
	   //commit transaction
		session.getTransaction().commit();
	

	}

}
