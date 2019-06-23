package com.backend.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.project.entity.User;
import com.backend.project.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<User> list(
			@RequestParam("page") int page,
			@RequestParam("size") int size) {
		
		return repo.findAll(PageRequest.of(page, size));
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		return repo.save(user);
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public User edit(@RequestBody User user) {
		return repo.save(user);
	}	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Optional<User> detail(@PathVariable Long id) {
		return repo.findById(id);
	}	
}
