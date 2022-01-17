package com.hospital.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	
	@Id
	long id;
	
	String name;
	
	int noOfDoctors;

	public Department() {
		super();
	}

	public Department(long id, String name, int noOfDoctors) {
		super();
		this.id = id;
		this.name = name;
		this.noOfDoctors = noOfDoctors;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfDoctors() {
		return noOfDoctors;
	}

	public void setNoOfDoctors(int noOfDoctors) {
		this.noOfDoctors = noOfDoctors;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", noOfDoctors=" + noOfDoctors + "]";
	}
	
	

}