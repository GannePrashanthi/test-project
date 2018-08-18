package com.hibernate.jdbc2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructordetailid;
	@OneToMany(mappedBy="instructor",cascade= {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<Course> courses;
	
	

	public Instructor(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
			}
	
	public Instructor() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public InstructorDetail getInstructordetailid() {
		return instructordetailid;
	}

	public void setInstructordetailid(InstructorDetail instructordetailid) {
		this.instructordetailid = instructordetailid;
	}

	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", instructordetailid=" + instructordetailid + "]";
	}
	
	//add convience methods for bi directional relationship
	public void add(Course tempcourse) {
		if(courses==null) {
			courses=new ArrayList<>();
		}
		courses.add(tempcourse);
		tempcourse.setInstructor(this);
			
		
	}

}
