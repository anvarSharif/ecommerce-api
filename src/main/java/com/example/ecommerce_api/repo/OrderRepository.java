package com.example.ecommerce_api.repo;

import com.example.ecommerce_api.entity.Order;
import com.example.ecommerce_api.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}