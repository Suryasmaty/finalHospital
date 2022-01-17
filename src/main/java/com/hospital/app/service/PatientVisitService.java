package com.hospital.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.hospital.app.dao.PatientVisitRepository;
import com.hospital.app.model.Patient;
import com.hospital.app.model.PatientVisit;

@Service
public class PatientVisitService {
	
	@Autowired
	private PatientVisitRepository repo;
	
	@Autowired
	private PatientService patientService;
	
	/*
	 * public PatientVisit savePatientVisit(PatientVisit patientVisit) { return
	 * repo.save(patientVisit); }
	 */
	
	public String savePatientVisit(long id,PatientVisit patientVisit) throws Exception
	{
		Patient p=patientService.getPatientById(id);
		patientVisit.setPatient(p);
		repo.save(patientVisit);
		return "visit added";
	}
	
	public List<PatientVisit> getAllPatientVisits()
	{
		return repo.findAll();
	}
	
	
	
	public void updatePrescription(String prescription, int id)
	{
		repo.updateDiseasePrescription(prescription,id);
	}
	
	public List<PatientVisit> getByPatientId(long id)
	{
		return repo.getVisitByPatientId(id);
	}
	
	public ResponseEntity<PatientVisit> cancelRegistration(int id,PatientVisit patientVisit) throws Exception
	{
		PatientVisit p=repo.findById(id).orElseThrow(()->new Exception("error"));
		p.setPrescription(patientVisit.getPrescription());
		PatientVisit updatedVisit=repo.save(p);
		return ResponseEntity.ok(updatedVisit);
	}
	
	public ResponseEntity<PatientVisit> getVisitById(int id) throws Exception
	{
		PatientVisit v=repo.findById(id).orElseThrow(()->new Exception("error"));
		return ResponseEntity.ok(v);
		
	}
	
	public long getIdOfPatient(int id)
	{
		long result=repo.sendPatientIdFromVisit(id);
		return result;
	}

}