package com.example.ecommerce_api.entity;

import com.example.ecommerce_api.entity.abc.BaseEntity;
import com.example.ecommerce_api.entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@SuperBuilder
public class Order extends BaseEntity {
    @CreationTimestamp
    private LocalDateTime dateTime;
    @ManyToOne
    private User user;
    @CreationTimestamp
    private LocalDateTime localDateTime;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(OrderStatus status,User user, List<OrderItem> orderItems) {
        this.status=status;
        this.user = user;
        this.orderItems = orderItems;
    }
}
