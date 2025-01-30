package com.example.ecommerce_api.repo;

import com.example.ecommerce_api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}