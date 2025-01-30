package com.example.ecommerce_api.entity;

import com.example.ecommerce_api.entity.abc.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@AllArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {
    private Integer price;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Attachment photo;

    public Product() {
        super();
    }
}
