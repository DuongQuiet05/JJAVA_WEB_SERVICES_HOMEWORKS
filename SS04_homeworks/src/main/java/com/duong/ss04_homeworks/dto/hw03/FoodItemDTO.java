package com.duong.ss04_homeworks.dto.hw03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {
    private Integer id;
    private String name;
    private Integer categoryId;
    private double price;
    private LocalDate expirationDate;
}
