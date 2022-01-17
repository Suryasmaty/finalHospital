package com.hospital.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.app.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Integer> {

}