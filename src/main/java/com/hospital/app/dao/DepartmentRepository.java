package com.hospital.app.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hospital.app.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query(value="select * from department where name=?1",nativeQuery=true)
	Department findByName(String name);
	
	@Modifying
	@Transactional
	@Query(value="update department set no_of_doctors=?1 where id=?2",nativeQuery=true)
	void updateNoOfDoctors(int updated, Long id);

}