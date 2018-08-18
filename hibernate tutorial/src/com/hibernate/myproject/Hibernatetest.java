package com.hibernate.myproject;

import java.sql.Connection;
import java.sql.DriverManager;



public class Hibernatetest {

	public static void main(String[] args) {
		String Jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try {
			System.out.println("connecting to database"+Jdbcurl);
			Connection con=DriverManager.getConnection(Jdbcurl,user,pass);
			System.out.println("connection successful!!!!!!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
