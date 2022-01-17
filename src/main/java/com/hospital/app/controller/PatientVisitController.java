package com.hospital.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.model.PatientVisit;
import com.hospital.app.service.PatientVisitService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientVisitController {

	@Autowired
	private PatientVisitService patientVisitService;

	@PostMapping(value = "/saveVisit/{id}")
	public String savePatientVisit(@RequestBody PatientVisit patientVisit, @PathVariable long id) throws Exception {

		return patientVisitService.savePatientVisit(id,patientVisit);
	}

	@GetMapping("/allPatientVisits")
	public List<PatientVisit> getAll() {
		return patientVisitService.getAllPatientVisits();
	}
	
	@GetMapping("/allVisitsByPatientId/{id}")
	public List<PatientVisit> getByPatientId(@PathVariable long id)
	{
		return patientVisitService.getByPatientId(id);
	}
	
	@PutMapping("/update/{id}") 
	public ResponseEntity<PatientVisit> updateVisit(@PathVariable int id, @RequestBody PatientVisit patientVisit) throws Exception{
		return patientVisitService.cancelRegistration(id, patientVisit);
	}
	
	@GetMapping("/getVisitById/{id}")
	public ResponseEntity<PatientVisit> getVisitById(@PathVariable int id) throws Exception
	{
		return patientVisitService.getVisitById(id);
	}
	
	@GetMapping("/getPatientIdFromVisit/{id}")
	public long getIdOfPatient(@PathVariable int id)
	{
		return patientVisitService.getIdOfPatient(id);
	}
}

/*
 * @PostMapping(value="/saveVisit") public PatientVisit
 * savePatientVisit(@RequestBody PatientVisit patientVisit) throws Exception {
 * Long x=patientVisit.getPatient().getId(); Patient patient1 =
 * service.getPatientById(x); Doctor doctor=patient1.getDoctor(); Patient
 * p=patientVisit.getPatient(); p.setDoctor(doctor);
 * 
 * return repo.save(patientVisit); }
 */