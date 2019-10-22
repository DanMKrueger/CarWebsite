package com.collabera.motors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.motors.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String loginClicked(@RequestBody String enteredString) throws Exception {
		return userService.loginUser(enteredString);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/signup")
	public String signup(@RequestBody String enteredString) throws Exception {
		return userService.makeUser(enteredString);
	}

}
