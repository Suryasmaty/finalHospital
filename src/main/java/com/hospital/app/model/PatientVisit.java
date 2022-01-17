package com.hospital.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PatientVisit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int visitId;

	private String date1;
	
	private String time1;

	private String disease;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	@JsonBackReference
	@Embedded
	private Patient patient;

	private String prescription;

	public PatientVisit() {
		super();
	}

	public PatientVisit(int visitId, String date1, String time1, String disease, Patient patient, String prescription) {
		super();
		this.visitId = visitId;
		this.date1 = date1;
		this.time1 = time1;
		this.disease = disease;
		this.patient = patient;
		this.prescription = prescription;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "PatientVisit [visitId=" + visitId + ", date1=" + date1 + ", time1=" + time1 + ", disease=" + disease
				+ ", patient=" + patient + ", prescription=" + prescription + "]";
	}

	

}