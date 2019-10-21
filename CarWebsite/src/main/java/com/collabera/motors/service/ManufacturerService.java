package com.collabera.motors.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.motors.model.Car;
import com.collabera.motors.model.Manufacturer;
import com.collabera.motors.repository.CarRepository;
import com.collabera.motors.repository.ManufacturerRepository;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository manRepo;
	
	@Autowired
	private CarRepository carRepo;

	public ArrayList<Manufacturer> getAllManufacturers() {
		
		return (ArrayList<Manufacturer>) manRepo.findAll();
		
	}

	public ArrayList<Car> getCars(String name) {
		ArrayList<Car> allCars = (ArrayList<Car>) carRepo.findAll();
		ArrayList<Car> requestedCars = new ArrayList<>();
		
		for(int i = 0; i < allCars.size(); i++) {
			if(allCars.get(i).getMake().equals(name)) {
				requestedCars.add(allCars.get(i));
			}
		}
		
		return requestedCars;
	}
	
}
