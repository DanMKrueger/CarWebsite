package com.collabera.motors.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.motors.model.Car;
import com.collabera.motors.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired 
	private CarRepository carRepo;

	public ArrayList<Car> getAllCars() {
		System.out.println((ArrayList<Car>) carRepo.findAll());
		return (ArrayList<Car>) carRepo.findAll();
	}

	public String adminUpdate(String enteredString) {
		
		// Potentially parse through the entered string if neccessary
		
		// Get the id of the car that was sent over, and search through the database for that specific car
		
		// Get the whole repo, put it in an array list, and search for the car we are looking for
		ArrayList<Car> allCars = new ArrayList<>();
		allCars = (ArrayList<Car>) carRepo.findAll();
		for(int i = 0; i < allCars.size(); i++) {
			
		}
		
		return "Updated";
	}

	public String adminAdd(String enteredString) {
		
		// Create a new Car
		Car newCar = new Car();
		
		// Take that Car, and populate it with the info that was passed to us from the front end
		
		// Take the new Car, and save it to the database
		// carRepo.save(newCar);
		
		return "Added";
	}

	public String adminRemove(String enteredString) {
		
		// Take the ID that was passed in, and search for it in the database to delete it.
		//carRepo.deleteById(Integer.parseInt(enteredString));
		
		return "Removed";
	}

}
