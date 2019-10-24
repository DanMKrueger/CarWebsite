package com.collabera.motors.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.motors.model.User;
import com.collabera.motors.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	HttpServletResponse http;

	
/******************************* User Login *******************************/

	public User loginUser(String enteredString) {
		
		String removeBrackets = enteredString.substring(1, enteredString.length()-1);
		
		String delim = "[,]";
		String valueString = "";
		String[] values = removeBrackets.split(delim);
		User returnedUser = null;
		ArrayList<String> onlyValues = new ArrayList<String>();
		
		for(int i = 0; i < values.length; i++) {
			valueString = values[i].substring(values[i].indexOf("\"") +1, values[i].length()-1);
			onlyValues.add(valueString);
		}
		
		ArrayList<User> allUsers = (ArrayList<User>) userRepo.findAll();
		for(int i = 0; i < allUsers.size(); i++) {
			if(allUsers.get(i).getUser_name().contentEquals(onlyValues.get(0))) {
				if(allUsers.get(i).getUser_password().contentEquals(onlyValues.get(1))) {
					returnedUser = allUsers.get(i);
					Cookie cookie = new Cookie("username", (String) allUsers.get(i).getUser_name());
					http.addCookie(cookie);

				}
			}
		}
		
		return returnedUser;
	}

/******************************* Create User *******************************/
	public String makeUser(String enteredString) {
		List<User> allUsers = new ArrayList<>();
		allUsers = userRepo.findAll();
		enteredString = enteredString.substring(1, enteredString.length()-1);
		String delim = "[,]";
		String[] onlyValues = enteredString.split(delim);
		for(int i = 1; i < allUsers.size()+1; i++) {
			//System.out.println(userRepo.getOne(i).getUser_name());
			if(userRepo.getOne(i).getUser_name().contentEquals(onlyValues[0])) {
				return "Username already used!";
			}
		}		
		User newUser = new User();
		newUser.setUser_name(onlyValues[0]);
		newUser.setUser_password(onlyValues[1]);
		newUser.setFirst_name(onlyValues[2]);
		newUser.setLast_name(onlyValues[3]);
		newUser.setAdmin(0);
		userRepo.save(newUser);

		return "Added!";
	}

}
