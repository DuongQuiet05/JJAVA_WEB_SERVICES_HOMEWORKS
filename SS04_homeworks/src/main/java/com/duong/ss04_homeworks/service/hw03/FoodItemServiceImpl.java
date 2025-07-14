package com.duong.ss04_homeworks.service.hw03;

import com.duong.ss04_homeworks.dto.hw03.FoodItemDTO;
import com.duong.ss04_homeworks.entity.Category;
import com.duong.ss04_homeworks.entity.FoodItem;
import com.duong.ss04_homeworks.repository.hw03.CategoryRepository;
import com.duong.ss04_homeworks.repository.hw03.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemRepository foodRepo;
    private final CategoryRepository categoryRepo;

    @Override
    public Page<FoodItem> search(String keyword, Integer categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return foodRepo.search(keyword, categoryId, pageable);
    }

    @Override
    public FoodItem getById(int id) {
        return foodRepo.findById(id).orElse(null);
    }

    @Override
    public void save(FoodItemDTO dto) {
        Category cat = categoryRepo.findById(dto.getCategoryId()).orElse(null);
        if (cat == null) return;
        FoodItem f = new FoodItem(null, dto.getName(), cat, dto.getPrice(), dto.getExpirationDate());
        foodRepo.save(f);
    }

    @Override
    public void update(FoodItemDTO dto) {
        Category cat = categoryRepo.findById(dto.getCategoryId()).orElse(null);
        if (cat == null) return;
        FoodItem f = new FoodItem(dto.getId(), dto.getName(), cat, dto.getPrice(), dto.getExpirationDate());
        foodRepo.save(f);
    }

    @Override
    public void delete(int id) {
        foodRepo.deleteById(id);
    }
}
