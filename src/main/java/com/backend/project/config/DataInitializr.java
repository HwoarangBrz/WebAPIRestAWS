package com.backend.project.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.backend.project.entity.User;
import com.backend.project.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository repo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<User> users = repo.findAll();
		if (users.isEmpty()) {
			this.createUser("Hwoarang", "hwoarang@gmail.com", "123456");
			this.createUser("Ricardo", "ricardo@gmail.com", "123456");
			this.createUser("Rafael", "reafel@gmail.com", "123456");
			this.createUser("Henrique", "henrique@gmail.com", "123456");
			this.createUser("Hercules", "hercules@gmail.com", "123456");
			this.createUser("Jade", "jade@gmail.com", "123456");
			this.createUser("Sasha", "sasha@gmail.com", "123456");
			this.createUser("Sadam", "sadam@gmail.com", "123456");
		}
	}
	
	private void createUser(String name, String email, String password) {
		User entity = new User(name, email, password);
		repo.save(entity);
	}

}
