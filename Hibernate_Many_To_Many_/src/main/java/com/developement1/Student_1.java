package com.developement1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Student_1 {
	@Id
	private int rollno;
	private String name;
	private String address;
	@ManyToOne
	private List<Batch> batches;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
	public Student_1() {}
	public Student_1(int rollno, String name, String address, List<Batch> batches) {
		this.rollno = rollno;
		this.name = name;
		this.address = address;
		this.batches = batches;
	}	
}
