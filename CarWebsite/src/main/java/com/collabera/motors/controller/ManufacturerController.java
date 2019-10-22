package com.collabera.motors.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.motors.model.Car;
import com.collabera.motors.model.Manufacturer;
import com.collabera.motors.service.ManufacturerService;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manuService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/getmanufacturers")
	public @ResponseBody ArrayList<Manufacturer> getManufacturers() {
		//System.out.println("Request received");
		return manuService.getAllManufacturers();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/manufacturer{name}")
    public @ResponseBody ArrayList<Car> getCar(@PathVariable("name") String name) {
		if(name != "") {
	        return manuService.getCars(name);                              
		}
		else {
			return null;
		}
    }

}
