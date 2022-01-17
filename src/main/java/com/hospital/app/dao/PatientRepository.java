package com.hospital.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hospital.app.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	
	@Query(value="select * from patient where id=?1",nativeQuery=true)
	List<Patient> getAllPatientsById(long id);

}