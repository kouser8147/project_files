package com.springboot.RegAndLogin_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.RegAndLogin_springboot.dto.User;


public interface UserRepository extends JpaRepository<User,Integer>{

	@Query("select u from User u where u.email=?1 and u.password=?2")
	public User valideUserUser(String email,String password);
}