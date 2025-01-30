package com.example.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDTO {
    private List<OrderItemDTO> dtoList;
}
