package com.collabera.motors.service;

import java.util.ArrayList;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Service;

import com.collabera.motors.model.Car;
import com.collabera.motors.repository.CarRepository;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class CarService {
	
	@Autowired 
	private CarRepository carRepo;

/************************************* Get All Cars method *************************************/

	public ArrayList<Car> getAllCars() {
		// Make an array list, and populate it with all the info from our database
		return (ArrayList<Car>) carRepo.findAll();
	}

/************************************* Update Car method *************************************/

	public String adminUpdate(String enteredString) {
		
		// Make a new Array List, and run it through the extract method made below to get all the Values
		ArrayList<String> onlyValues = extracted(enteredString);
		
		// Create a new car, and set it to be the car that the person was referencing by
		// getting the car from the database that has the same ID.
		Car enteredCar = carRepo.getOne(Integer.parseInt(onlyValues.get(0)));
		
		// Set all the attributes of the car to the values they should be based on what
		// we got from the front end.
		enteredCar.setId(Integer.parseInt(onlyValues.get(0)));
		enteredCar.setMake(onlyValues.get(1));
		enteredCar.setModel(onlyValues.get(2));
		enteredCar.setCar_year(onlyValues.get(3));
		enteredCar.setColor(onlyValues.get(4));
		enteredCar.setDescription(onlyValues.get(5));
		enteredCar.setPicture(onlyValues.get(6));
		enteredCar.setPrice(onlyValues.get(7));
		

		// Save the car to the database to finalize the update.
		carRepo.save(enteredCar);
		
				
		return "Updated!";
	}

/************************************* Add Car method *************************************/

	
	public String adminAdd(String enteredString) {
		
		// Create a new Array List, and run it through the extract method to 
		// get all of the values from what was entered to add.
		ArrayList<String> onlyValues = extracted(enteredString);
		
		// Create a new Car
		Car newCar = new Car();
		
		// Take that Car, and populate it with the info that was passed to us from the front end
		newCar.setId(0);
		newCar.setMake(onlyValues.get(1));
		newCar.setModel(onlyValues.get(2));
		newCar.setCar_year(onlyValues.get(3));
		newCar.setColor(onlyValues.get(4));
		newCar.setDescription(onlyValues.get(5));
		newCar.setPicture(onlyValues.get(6));
		newCar.setPrice(onlyValues.get(7));
		
		// Take the new Car, and save it to the database
		carRepo.save(newCar);
		
		return "Added";
	}

/************************************* Remove Car method *************************************/

	public String adminRemove(Integer enteredId) {
		
		// Take the ID that was passed in, and search for it in the database to delete it.
		try {
			carRepo.deleteById(enteredId);
			return "Removed";
		}catch(EmptyResultDataAccessException e) {
			return "No car with that ID found!";
		}
	}
	
/************************************* Get a Car method *************************************/

	
	public Car getCar(int id) throws JsonMappingException {
		try {
			// Try to get the car with the ID passed in, and then return it.
			carRepo.getOne(id);
			Car requestedCar = carRepo.getOne(id);
			return requestedCar;
			// If the car is not there, return null.
		}catch(EntityNotFoundException e) {
			return null;
		}
		catch(HttpMessageNotWritableException e) {
			return null;
		}
	}
	
	
/************************************* Extract method to get values out of entered array *************************************/
	
	public ArrayList<String> extracted(String enteredString) {
		// Create a new string, and set it equal to the passed in string but take off the first and
		// last chars becaues they are [ and ] respectively and we dont need that.
		String mySubstr;
		mySubstr = enteredString.substring(1, enteredString.length()-1);
		
		// Parse through the entered string on the , followed by a space.
		String delim = ",\\s";
		
		// Create a string array that is equal to the array of values, and split it
		// on the , to get each value by itself. Then create a new array list.
		String[] parsedData = mySubstr.split(delim);
		ArrayList<String> onlyValues = new ArrayList<>();
		
		// Loop through the String array of the values in the format -> make=Dodge, model=Ram 
		// split on the equal sign, and take everything after the equal sign all the way to the end
		// of that specific entry so make=Dodge just becomes Dodge. Then push that value into our array list.
		for(int i = 0; i < parsedData.length; i++) {
			onlyValues.add(parsedData[i].substring(parsedData[i].indexOf("=")+1, parsedData[i].length()));
		}
		
		//return our value array list.
		return onlyValues;
	}

}
