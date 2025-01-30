package com.example.ecommerce_api.repo;

import com.example.ecommerce_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}