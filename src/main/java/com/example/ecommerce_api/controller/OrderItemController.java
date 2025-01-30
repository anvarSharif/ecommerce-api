package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.BasketDTO;
import com.example.ecommerce_api.dto.OrderItemDTO;
import com.example.ecommerce_api.entity.Order;
import com.example.ecommerce_api.entity.OrderItem;
import com.example.ecommerce_api.entity.Product;
import com.example.ecommerce_api.repo.OrderItemRepository;
import com.example.ecommerce_api.repo.OrderRepository;
import com.example.ecommerce_api.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    public OrderItemController(OrderItemRepository orderItemRepository,
                               OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
    }


    @GetMapping
     public List<OrderItem> getProducts(@RequestParam Integer orderId){
       return orderItemRepository.findAllByOrderId(orderId);
     }
}
