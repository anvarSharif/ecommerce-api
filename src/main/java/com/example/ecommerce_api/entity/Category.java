package com.example.ecommerce_api.entity;

import com.example.ecommerce_api.entity.abc.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
public class Category extends BaseEntity {
    private String name;
    public Category(Integer id, String name) {
        super.setId(id);
        this.name = name;
    }
}
