package com.hospital.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.app.model.Disease;
import com.hospital.app.service.DiseaseService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DiseaseController {
	
	@Autowired
	private DiseaseService service;
	
	@PostMapping("/saveDisease")
	public Disease saveDisease(@RequestBody Disease disease)
	{
		return service.saveDisease(disease);
	}
	
	
	@GetMapping("/getAllDiseases")
	public List<Disease> getAllDiseases()
	{
		return service.getAllDiseases();
	}
}