package com.hospital.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hospital.app.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	
	@Modifying
	@Transactional
	@Query(value="update doctor set patients_attended=?1 where id=?2",nativeQuery=true)
	void updatePatientsAttended(int updated, Long id);

	@Query(value="select * from doctor where name=?1",nativeQuery=true)
	Doctor getDoctorByName(String name);
	

	@Query(value="select * from doctor where name=?1",nativeQuery=true)
	List<Doctor> getDoctorByNameForSearch(String name);
	

}