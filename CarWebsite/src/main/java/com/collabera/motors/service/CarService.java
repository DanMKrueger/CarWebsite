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
		System.out.println(enteredCar);
		
		enteredCar.setId(Integer.parseInt(onlyValues.get(0)));
		enteredCar.setMake(onlyValues.get(1));
		enteredCar.setModel(onlyValues.get(2));
		enteredCar.setCar_year(onlyValues.get(3));
		enteredCar.setColor(onlyValues.get(4));
		enteredCar.setDescription(onlyValues.get(5));
		enteredCar.setPicture(onlyValues.get(6));
		
		System.out.println(enteredCar);

		
		carRepo.save(enteredCar);
		
				
		return "Updated!";
	}

/************************************* Add Car method *************************************/

	
	public String adminAdd(String enteredString) {
		
		ArrayList<String> onlyValues = extracted(enteredString);
		
		// Create a new Car
		Car newCar = new Car();
		
		// Take that Car, and populate it with the info that was passed to us from the front end
		
		newCar.setMake(onlyValues.get(0));
		newCar.setModel(onlyValues.get(1));
		newCar.setCar_year(onlyValues.get(2));
		newCar.setColor(onlyValues.get(3));
		newCar.setDescription(onlyValues.get(4));
		newCar.setPicture(onlyValues.get(5));
		
		// Take the new Car, and save it to the database
		carRepo.save(newCar);
		
		return "Added";
	}

/************************************* Remove Car method *************************************/

	public String adminRemove(String enteredString) {
		
		// Take the ID that was passed in, and search for it in the database to delete it.
		//carRepo.deleteById(Integer.parseInt(enteredString));
		
		return "Removed";
	}
	
	
/************************************* Extract method to get values out of entered array *************************************/
	
	public ArrayList<String> extracted(String enteredString) {
		String mySubstr;
		mySubstr = enteredString.substring(1, enteredString.length()-1);
		//System.out.println(mySubstr);
		
		// Potentially parse through the entered string if neccessary
		String delim = "[,]";
		String[] parsedData = mySubstr.split(delim);
		//System.out.println(enteredString.toString());
		ArrayList<String> onlyValues = new ArrayList<>();
		for(int i = 0; i < parsedData.length; i++) {
			onlyValues.add(parsedData[i].substring(parsedData[i].indexOf("=")+1, parsedData[i].length()));
		}
		return onlyValues;
	}

}
