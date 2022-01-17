package com.hospital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.model.Patient;

import com.hospital.app.service.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/savePatient")
	public String savePatient(@RequestBody Patient patient) throws Exception {

		return patientService.savePatient(patient);
	}

	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@GetMapping("/getPatientById/{id}")
	public List<Patient> getPatientById(@PathVariable long id) throws Exception {
		return patientService.getPatientsById(id);
	}

}

/*
 * @PostMapping("/savePatient") public String savePatient(@RequestBody Patient
 * patient) throws Exception {
 * 
 * Doctor doctor = patient.getDoctor();
 * 
 * Long doc_id = doctor.getId(); Doctor doc =
 * doctorService.getDoctorById(doc_id); int att = doc.getPatientsAttended();
 * patient.setVisitedDoctor(doc.getName());
 * patient.getDoctor().setPatientsAttended(att); patient.setDoctor(doc);
 * patientService.savePatient(patient); doctorService.updatePatientsAttended(att
 * + 1, doc_id); return
 * "Hi "+patient.getName()+" Your registration was sucessful"; }
 */