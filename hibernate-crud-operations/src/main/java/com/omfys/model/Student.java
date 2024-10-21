package com.omfys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "student_sequence", allocationSize = 1)
	private Long id;

	private String name;
	private int age;
	private String enrolledcourse;
	
	
	public Student() {
		
	}
	public Student(Long id, String name, int age, String enrolledcourse) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.enrolledcourse = enrolledcourse;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEnrolledcourse() {
		return enrolledcourse;
	}
	public void setEnrolledcourse(String enrolledcourse) {
		this.enrolledcourse = enrolledcourse;
	}
	 

	
}
