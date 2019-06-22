package com.backend.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
