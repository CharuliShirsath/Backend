package com.developement1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Document {
	@Id
	private int doc_id;
	private String type;
	private String number;
	public int getDoc_id() {
		return doc_id;
	}
	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Document() {}
	public Document(int doc_id, String type, String number) {
		this.doc_id = doc_id;
		this.type = type;
		this.number = number;
	}
	
	

}
