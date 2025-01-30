package com.example.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSaveDTO {
    private String name;
    private Integer price;
    private Integer attachmentId;
    private Integer categoryId;
}
