package com.hibernate.jdbc3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
private int id;
	
	@Column(name="title")
private String title;
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name="instructor_id")
private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
private List<Review> review;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
		      )
	
private List<Student> students;
	
public Course() {
	}



public Course(String title) {
	super();
	this.title = title;
}



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Instructor getInstructor() {
	return instructor;
}

public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}


public List<Review> getReview() {
	return review;
}

public void setReview(List<Review> review) {
	this.review = review;
}


public List<Student> getStudents() {
	return students;
}



public void setStudents(List<Student> students) {
	this.students = students;
}


//add a convenience method
public void addreview(Review thereview) {
	if(review==null) {
		review=new ArrayList<>();
	}
	review.add(thereview);
}

//add a convenience method
public void addstudent(Student thestudents) {
	if(students==null) {
		students=new ArrayList<>();
	}
	students.add(thestudents);
}

@Override
public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
}



}
