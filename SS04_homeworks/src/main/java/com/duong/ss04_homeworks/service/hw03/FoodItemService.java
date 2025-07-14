package com.duong.ss04_homeworks.service.hw03;

import com.duong.ss04_homeworks.dto.hw03.FoodItemDTO;
import com.duong.ss04_homeworks.entity.FoodItem;
import org.springframework.data.domain.Page;

public interface FoodItemService {
    Page<FoodItem> search(String keyword, Integer categoryId, int page, int size);
    FoodItem getById(int id);
    void save(FoodItemDTO dto);
    void update(FoodItemDTO dto);
    void delete(int id);
}
