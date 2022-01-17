package com.hospital.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.dao.DoctorRepository;
import com.hospital.app.model.Department;
import com.hospital.app.model.Doctor;
import com.hospital.app.service.DepartmentService;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository repo;
	
	@Autowired
	private DepartmentService departmentService;

	private Doctor emptyDoctor = new Doctor();

	public String saveDoctor(Doctor doctor) throws Exception {

		Long id = doctor.getId();
		String name = doctor.getName();
		int age = doctor.getAge();
		String gender = doctor.getGender();
		String specialization = doctor.getSpecialization();

		if (id == null || name.equals("") == true || gender.equals("") == true || specialization.equals("") == true
				|| age == 0) {
			return "red";
		}

		Doctor existingDoctor = getDoctorById(id);

		if (existingDoctor == emptyDoctor) {
			Department department=departmentService.getDepartmentByName(specialization);
			long departmentId=department.getId();
			int newCount=department.getNoOfDoctors()+1;
			departmentService.updateNoOfDoctors(newCount, departmentId);
			repo.save(doctor);
			
			return "green";
		} else {
			return "yellow";
		}

	}

	public List<Doctor> getAllDoctors() {
		return repo.findAll();
	}

	public Doctor getDoctorById(Long id) {
		return repo.findById(id).orElse(emptyDoctor);
	}
	
	public Optional<Doctor> getDoctorFromId(Long id)
	{
		return repo.findById(id);
	}

	public Doctor getDoctorByName(String name) {
		return repo.getDoctorByName(name);
	}

	public List<Doctor> getDoctorForSearch(String name) {
		return repo.getDoctorByNameForSearch(name);
	}

	public void updatePatientsAttended(int updated, Long id) {
		repo.updatePatientsAttended(updated, id);
	}

	public List<Doctor> deleteById(long id) {
		repo.deleteById(id);
		return getAllDoctors();
	}

}