package com.hospital.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@Embeddable
public class Doctor {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private int age;

	private String gender;

	private String specialization;
	
	private int patientsAttended;

	@OneToMany(mappedBy="doctor")
	@JsonManagedReference
	private List<Patient> patient;

	public Doctor() {
		super();
	}

	public Doctor(Long id, String name, int age, String gender, String specialization, int patientsAttended,
			List<Patient> patient) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialization = specialization;
		this.patientsAttended = patientsAttended;
		this.patient = patient;
	}
	
	public Doctor(Long id, String name, int age, String gender, String specialization, int patientsAttended
			) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.specialization = specialization;
		this.patientsAttended = patientsAttended;
		
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getPatientsAttended() {
		return patientsAttended;
	}

	public void setPatientsAttended(int patientsAttended) {
		this.patientsAttended = patientsAttended;
	}

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", specialization="
				+ specialization + ", patientsAttended=" + patientsAttended + "]";
	}

	

	
	

}