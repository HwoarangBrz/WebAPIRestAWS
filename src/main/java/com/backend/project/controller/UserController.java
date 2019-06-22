package com.backend.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.entity.User;
import com.backend.project.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> list() {
		 return repo.findAll();
	}

}
