package com.backend.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.project.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
