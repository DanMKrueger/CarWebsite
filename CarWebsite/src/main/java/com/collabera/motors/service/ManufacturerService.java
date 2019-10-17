package com.collabera.motors.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.motors.model.Manufacturer;
import com.collabera.motors.repository.ManufacturerRepository;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository manRepo;

	public ArrayList<Manufacturer> getAllManufacturers() {
		
		return (ArrayList<Manufacturer>) manRepo.findAll();
		
	}
	
}
