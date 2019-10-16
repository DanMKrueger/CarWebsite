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

}
