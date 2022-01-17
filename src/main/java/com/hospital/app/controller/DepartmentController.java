package com.hospital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.model.Department;
import com.hospital.app.service.DepartmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;
	
	
	@PostMapping("/saveDepartment")
	public Department saveDepartment(@RequestBody Department department)
	{
		return service.saveDepartment(department);
	}
	
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments()
	{
		return service.getAllDepartments();
	}

}