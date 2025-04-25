package com.omfys.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Students_Details")
public class Student {
	
	@Id
	@Column(name = "Student_id")
	private int id;
	
	@Column(name = "Student_name")
	private String name;

	
	//getter setter
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//constructor
	public Student() {
		
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	

}
