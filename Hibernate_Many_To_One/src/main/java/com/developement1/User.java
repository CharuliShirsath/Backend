package com.developement1;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class User {
	@Id
	private int id;
	private String name;
	private String Address;
	//@JoinTable(name="u_d")
	@OneToMany
	private List<Document> document;
	
	
	
	public List<Document> getDocument() {
		return document;
	}
	public void setDocument(List<Document> document) {
		this.document = document;
	}
	public int getId() {
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
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	public User() {}
	public User(int id, String name, String address, List<Document> document) {
		this.id = id;
		this.name = name;
		Address = address;
		this.document = document;
	}
	
	
}
