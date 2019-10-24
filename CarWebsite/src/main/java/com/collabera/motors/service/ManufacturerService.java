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
		// get all the manufacturers and return that in an array list form.
		return (ArrayList<Manufacturer>) manRepo.findAll();
		
	}

	public ArrayList<Car> getCars(String name) {
		// The passed in string called name is the manufacturer name, like dodge, nissan, etc.
		// Create an array list, and get every car from our data base.
		ArrayList<Car> allCars = (ArrayList<Car>) carRepo.findAll();
		ArrayList<Car> requestedCars = new ArrayList<>();
		
		// Now that we have all our cars, we can loop through our cars and check the make of all of them.
		// If the make is equal to the make they requested (name), then we know that is one of the cars they want
		// to see, so we add that car to our empty array list named requestedCars. At the end, we return that array list
		// with all the cars with the requested make.
		for(int i = 0; i < allCars.size(); i++) {
			if(allCars.get(i).getMake().equals(name)) {
				requestedCars.add(allCars.get(i));
			}
		}
		
		return requestedCars;
	}
	
}
