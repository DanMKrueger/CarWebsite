package com.collabera.motors.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.motors.model.User;
import com.collabera.motors.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public String loginUser(String enteredString) {
		
		String removeBrackets = enteredString.substring(1, enteredString.length()-1);
		
		String delim = "[,]";
		String valueString = "";
		String[] values = removeBrackets.split(delim);
		ArrayList<String> onlyValues = new ArrayList<String>();
		
		for(int i = 0; i < values.length; i++) {
			valueString = values[i].substring(values[i].indexOf("\"") +1, values[i].length()-1);
			onlyValues.add(valueString);
		}
		
		ArrayList<User> allUsers = (ArrayList<User>) userRepo.findAll();
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getUser_name().contentEquals(onlyValues.get(0))) {
				if(allUsers.get(i).getUser_password().contentEquals(onlyValues.get(1))) {
					return allUsers.get(i).getFirst_name();
				}
			}
		}

		
		return "";
	}

}
