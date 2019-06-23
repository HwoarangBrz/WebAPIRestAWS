package com.backend.project.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.project.entity.User;
import com.backend.project.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

	private final UserRepository repo;
	
	@Autowired
	public UserDetailService(UserRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário ou senha incorretos");
		}
		return new UserRepositoryUserDetail(user);
	}
	
	private final static class UserRepositoryUserDetail extends User implements UserDetails {

		private UserRepositoryUserDetail(User user) {
			super(user);
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return getRoles();
		}
 
		@Override
		public String getPassword() {
			return super.getPassword();
		}

		@Override
		public String getUsername() {
			return this.getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}

}
