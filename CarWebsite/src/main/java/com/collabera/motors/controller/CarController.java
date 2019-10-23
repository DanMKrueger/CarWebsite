package com.collabera.motors.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.motors.model.Car;
import com.collabera.motors.repository.CarRepository;
import com.collabera.motors.service.CarService;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class CarController {

	@Autowired
	private CarRepository carRepo;
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/car")
	public @ResponseBody ArrayList<Car> getRecipes() {
		return carService.getAllCars();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatecar")
	public @ResponseBody String updatePage(@RequestBody String enteredString) throws Exception {
		System.out.println("HERE");
		return carService.adminUpdate(enteredString);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addcar")
	public @ResponseBody String addPage(@RequestBody String enteredString) throws Exception {
		return carService.adminAdd(enteredString);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/car{id}")
    public @ResponseBody Car getCar(@PathVariable("id") Integer id) throws JsonMappingException {
		if(id != null) {
	        return carService.getCar(id);                              
		}
		else {
			//return "Id is null.";
			return null;
		}
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/removecar{id}")
    public @ResponseBody String removeCar(@PathVariable("id") Integer id) throws JsonMappingException {
		if(id != null) {
	        return carService.adminRemove(id);                              
		}
		else {
			return "";
		}
    }
	
}
