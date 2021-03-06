package com.collabera.motors.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.motors.model.User;
import com.collabera.motors.repository.UserRepository;
import com.collabera.motors.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public boolean loginClicked(@RequestBody String enteredString) throws Exception {
		System.out.println(enteredString);
		return userService.loginUser(enteredString);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/signup")
	public String signup(@RequestBody String enteredString) throws Exception {
		return userService.makeUser(enteredString);
	}
}




