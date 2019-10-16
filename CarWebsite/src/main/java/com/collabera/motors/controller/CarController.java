package com.collabera.motors.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.motors.model.Car;
import com.collabera.motors.repository.CarRepository;
import com.collabera.motors.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/cars")
	public @ResponseBody ArrayList<Car> getRecipes() {
		return carService.getAllCars();
	}
	
}
