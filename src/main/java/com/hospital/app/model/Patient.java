package com.hospital.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Embeddable
public class Patient {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String visitedDoctor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	//@Embedded
	private Doctor doctor;
	
	@OneToMany(mappedBy="patient")
	@JsonManagedReference
	private List<PatientVisit> patientVisit;

	public Patient() {
		super();
	}

	public Patient(long id, String name, String visitedDoctor, Doctor doctor, List<PatientVisit> patientVisit) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.doctor = doctor;
		this.patientVisit = patientVisit;
	}
	
	public Patient(long id, String name, String visitedDoctor, Doctor doctor) {
		super();
		this.id = id;
		this.name = name;
		this.visitedDoctor = visitedDoctor;
		this.doctor = doctor;
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

	public String getVisitedDoctor() {
		return visitedDoctor;
	}

	public void setVisitedDoctor(String visitedDoctor) {
		this.visitedDoctor = visitedDoctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<PatientVisit> getPatientVisit() {
		return patientVisit;
	}

	public void setPatientVisit(List<PatientVisit> patientVisit) {
		this.patientVisit = patientVisit;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", visitedDoctor=" + visitedDoctor + ", doctor=" + doctor
				+ ", patientVisit=" + patientVisit + "]";
	}

	

}