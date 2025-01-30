package com.example.ecommerce_api.entity;

import com.example.ecommerce_api.entity.abc.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItem extends BaseEntity {
    private Integer amount;
    @ManyToOne
    private Product product;
    @JsonIgnore
    @ManyToOne()
    private Order order;
}
