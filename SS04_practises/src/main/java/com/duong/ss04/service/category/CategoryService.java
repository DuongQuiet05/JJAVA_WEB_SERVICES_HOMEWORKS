package com.duong.ss04.service.category;

import com.duong.ss04.model.dto.category.CreateCategoryDTO;
import com.duong.ss04.model.dto.category.UpdateCategoryDTO;
import com.duong.ss04.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll ();
    boolean createCategory (CreateCategoryDTO dto);
    boolean updateCategory  (UpdateCategoryDTO dto);
    boolean deleteCategory (int id);
    Optional<Category> findCategoryById (int id);
}
