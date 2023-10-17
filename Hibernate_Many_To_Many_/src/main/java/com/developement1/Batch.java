package com.developement1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Batch {
	@Id
	private int id;
	private String type;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Batch() {}
	public Batch(int id, String type, String name, List<Student_1> std) {
		this.id = id;
		this.type = type;
		this.name = name;
	}	
}
