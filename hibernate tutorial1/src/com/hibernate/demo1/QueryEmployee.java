package com.hibernate.demo1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.jdbc1.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		
			//create session factory
			SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
			//create session
			Session session=factory.getCurrentSession();
	
	try {
		//begin transaction
		session.beginTransaction();
		//writing query
		List<Employee> employee= session.createQuery("from Employee").list();
		//display the rows
		for(Employee theemployee:employee) {
			System.out.println("display the employees"+theemployee);
		}
		
	}
	finally {
		factory.close();
	}
	
	}
	

}
