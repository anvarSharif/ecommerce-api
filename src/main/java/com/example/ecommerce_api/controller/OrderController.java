package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.BasketDTO;
import com.example.ecommerce_api.dto.OrderItemDTO;
import com.example.ecommerce_api.entity.Order;
import com.example.ecommerce_api.entity.OrderItem;
import com.example.ecommerce_api.entity.Product;
import com.example.ecommerce_api.entity.User;
import com.example.ecommerce_api.repo.*;
import com.example.ecommerce_api.service.TokenService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;


    public OrderController(OrderRepository orderRepository,
                           ProductRepository productRepository,
                           OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }


    @GetMapping
    public List<Order> getOrders(@AuthenticationPrincipal User currentUser) {
        return orderRepository.findAllByUserId(currentUser.getId());
    }

    @PostMapping
    public HttpEntity<?> saveOrder(@RequestBody BasketDTO basketDTO, @AuthenticationPrincipal User currentUser) {
        System.out.println("userjonjon-" + currentUser);
        if (currentUser == null) {
            return ResponseEntity.status(403).body("user yo'q!");
        }
        Order order = Order.builder().user(currentUser).build();
        orderRepository.save(order);
        List<Product> products = productRepository.findAll();
        for (OrderItemDTO item : basketDTO.getDtoList()) {
            OrderItem orderItem = new OrderItem(item.getQuantity(),
                    products.stream().filter(product -> product.getId().equals(item.getId())).findFirst().get(),
                    order
            );
            orderItemRepository.save(orderItem);
        }
        return ResponseEntity.ok("successfully");
    }

}
