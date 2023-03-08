package com.springboot.RegAndLogin_springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springboot.RegAndLogin_springboot.dto.User;
import com.springboot.RegAndLogin_springboot.repository.UserRepository;

@Repository
public class UserDAO {
	
	@Autowired
	UserRepository repository;

	public String saveUser(User user)
	{
		repository.save(user);
		return "registration successful";
	}
	public User validate(String email,String password)
	{
		return repository.valideUserUser(email, password);
	}
}
