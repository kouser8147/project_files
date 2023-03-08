package com.springboot.RegAndLogin_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.RegAndLogin_springboot.dao.UserDAO;
import com.springboot.RegAndLogin_springboot.dto.User;

@RestController
public class UserController {

	@Autowired
	UserDAO dao;
	
	@PostMapping("/userpos")
	public String saveUser(@RequestBody User user)
	{
		dao.saveUser(user);
		return "Registration Successful.......";
	}
	@GetMapping("/getreques")
	 public String validate(@RequestParam String email,@RequestParam String password)
	 {
		 User u=dao.validate(email, password);
		 if(u!=null)
		 {
			 return "Login Successful";
		 }
		 return "Invalid username or password";
	 }
}
