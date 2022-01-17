package com.hospital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.hospital.app.dao.PatientRepository;
import com.hospital.app.model.Doctor;
import com.hospital.app.model.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repo;
	
	@Autowired
	private DoctorService doctorService;
	
	private Patient emptyPatient=new Patient();


	public String savePatient(Patient patient) throws Exception {
		
		Long pId=patient.getId();
		String name=patient.getName();
		String docName=patient.getDoctor().getName();
		
		if (pId == null || name.equals("") == true || docName.equals("") == true) {
			return "red";
		}

		Patient existingPatient = getPatientByIdForForm(pId);

		if (existingPatient == emptyPatient) {
			Doctor doctor = patient.getDoctor();
			String docname=doctor.getName();
			Doctor doc = doctorService.getDoctorByName(docname);
			Long doc_id=doc.getId();
			int att = doc.getPatientsAttended();//1
			patient.setVisitedDoctor(docname);
			patient.getDoctor().setPatientsAttended(att);
			patient.setDoctor(doc);
			repo.save(patient);
			doctorService.updatePatientsAttended(att + 1, doc_id);
			return "green";
		} else {
			return "yellow";
		}
	}
	
	public Patient getPatientByIdForForm(Long id) {
		return repo.findById(id).orElse(emptyPatient);
	}

	public Patient getPatientById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("not Found"));
	}
	
	public List<Patient> getPatientsById(long id)
	{
		return repo.getAllPatientsById(id);
	}
	
	
	public List<Patient> getAllPatients()
	{
		return repo.findAll();
	}

}
