package com.example.ecommerce_api.controller;

import com.example.ecommerce_api.dto.BasketDTO;
import com.example.ecommerce_api.dto.OrderItemDTO;
import com.example.ecommerce_api.dto.ProductSaveDTO;
import com.example.ecommerce_api.entity.Order;
import com.example.ecommerce_api.entity.OrderItem;
import com.example.ecommerce_api.entity.Product;
import com.example.ecommerce_api.repo.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     public List<Order> getOrders(){
       return orderRepository.findAll();
     }
    @PostMapping
    public String saveOrder(@RequestBody BasketDTO basketDTO){
        Order order=new Order();
        orderRepository.save(order);
        List<Product> products = productRepository.findAll();
        for (OrderItemDTO item : basketDTO.getDtoList()) {
            OrderItem orderItem=new OrderItem(item.getQuantity(),
                    products.stream().filter(product -> product.getId().equals(item.getId())).findFirst().get(),
                    order
            );
            orderItemRepository.save(orderItem);
        }
        return "muvaffaqiyatli bo'ldi";
    }
   /* @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productRepository.deleteById(id);
    }*/
}
