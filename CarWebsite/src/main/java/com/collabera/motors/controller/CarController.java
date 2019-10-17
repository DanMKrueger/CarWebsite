package com.collabera.motors.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/cars")
	public @ResponseBody ArrayList<Car> getRecipes() {
		return carService.getAllCars();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatecar")
	public @ResponseBody String updatePage(@RequestBody String enteredString) throws Exception {
		return carService.adminUpdate(enteredString);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addcar")
	public @ResponseBody String addPage(@RequestBody String enteredString) throws Exception {
		return carService.adminAdd(enteredString);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/removecar")
	public @ResponseBody String removePage(@RequestBody String enteredString) throws Exception {
		return carService.adminRemove(enteredString);
	}
	
}