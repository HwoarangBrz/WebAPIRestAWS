package com.backend.project.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.backend.project.entity.Role;
import com.backend.project.entity.User;
import com.backend.project.repository.RoleRepository;
import com.backend.project.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	PasswordEncoder pwd;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		List<User> users = userRepo.findAll();
		if (users.isEmpty()) {
			this.createUser("Hwoarang", "hwoarang@gmail.com", pwd.encode("123456"), "ROLE_ADMIN");
			this.createUser("Ricardo", "ricardo@gmail.com", pwd.encode("123456"), "ROLE_USER");
			this.createUser("Rafael", "reafel@gmail.com", pwd.encode("123456"), "ROLE_USER");
			this.createUser("Henrique", "henrique@gmail.com", pwd.encode("123456"), "ROLE_USER");
			this.createUser("Hercules", "hercules@gmail.com", pwd.encode("123456"), "ROLE_USER");
			this.createUser("Jade", "jade@gmail.com", pwd.encode("123456"), "ROLE_USER");
			this.createUser("Sasha", "sasha@gmail.com", pwd.encode("123456"), "ROLE_USER");
			this.createUser("Sadam", "sadam@gmail.com", pwd.encode("123456"), "ROLE_USER");
		}
	}
	
	private void createUser(String name, String email, String password, String role) {
		Role obj = new Role(role);
		roleRepo.save(obj);
		User entity = new User(name, email, password, Arrays.asList(obj));
		userRepo.save(entity);
	}

}
