package com.hibernate.demo3;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.jdbc3.Course;
import com.hibernate.jdbc3.Instructor;
import com.hibernate.jdbc3.InstructorDetail;
import com.hibernate.jdbc3.Review;
import com.hibernate.jdbc3.Student;

public class CreateCourseAndStudentsDemo {
public static void main(String[] args) {
	//create session factory
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
	//create session
	Session session=factory.getCurrentSession();

try {
	
		//start the transaction
	session.beginTransaction();
	//add some course
	Course tempcourse=new Course("java by javaatpoint");
	//save the course
	session.save(tempcourse);
	//create the students
	Student tempstudent1=new Student("siri","lucky","siri@gmail.com");
	Student tempstudent2=new Student("monica","chowdary","monicachowdary@gmail.com");
	//add students to the course
	tempcourse.addstudent(tempstudent1);
	tempcourse.addstudent(tempstudent2);
	//save the course
	session.save(tempstudent1);
	session.save(tempstudent2);
	
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
