package com.example.ecommerce_api.repo;

import com.example.ecommerce_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}