package com.hospital.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.app.dao.DiseaseRepository;
import com.hospital.app.model.Disease;

@Service
public class DiseaseService {

	@Autowired
	private DiseaseRepository repo;

	public Disease saveDisease(Disease disease) {
		return repo.save(disease);
	}

	public List<Disease> getAllDiseases() {
		return repo.findAll();
	}

}
