package com.hospital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.dao.DepartmentRepository;
import com.hospital.app.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repo;
	
	public Department saveDepartment(Department department)
	{
		department.setNoOfDoctors(0);
		return repo.save(department);
	}
	
	public List<Department> getAllDepartments()
	{
		return repo.findAll();
	}
	
	public Department getDepartmentByName(String name)
	{
		return repo.findByName(name);
	}
	
	public void updateNoOfDoctors(int count,long id)
	{
		repo.updateNoOfDoctors(count, id);
	}
	
	
	

}
