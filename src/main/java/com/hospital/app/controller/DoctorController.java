package com.hospital.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.hospital.app.model.Doctor;
import com.hospital.app.service.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@RequestBody Doctor doctor) throws Exception
	{
		return service.saveDoctor(doctor);
	}
	
	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctors()
	{
		return service.getAllDoctors();
	}
	
	@GetMapping("/getDoctorByName/{name}")
	public List<Doctor> getDoctorByName(@PathVariable String name)
	{
		return service.getDoctorForSearch(name);
	}
	
	@DeleteMapping("/deleteDoctor/{id}")
	public List<Doctor> deleteDoctor(@PathVariable int id)
	{
		service.deleteById(id);
		return service.getAllDoctors();
	}
	
	/*
	 * @GetMapping("/getDoctor/{id}") public Optional<Doctor>
	 * getDoctor(@PathVariable long id) throws Exception { return
	 * service.getDoctorById(id); }
	 */
}