package com.hospital.app.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hospital.app.model.PatientVisit;

public interface PatientVisitRepository extends JpaRepository<PatientVisit, Integer> {

	@Modifying
	@Transactional
	@Query(value = "update patientVisit set prescription=?1 where id=?2", nativeQuery = true)
	void updateDiseasePrescription(String prescription, int id);

	
	@Query(value = "select e from PatientVisit e JOIN e.patient p where p.id=?1")
	List<PatientVisit> getVisitByPatientId(long id);
	
	@Query(value="select v.patient.id from PatientVisit v where v.visitId=?1")
	long sendPatientIdFromVisit(int id);
	
	

}
//"select visit_id,date1,disease,prescription from patient_visit where patient_id=?1"