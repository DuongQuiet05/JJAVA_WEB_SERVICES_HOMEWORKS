package com.duong.ss04.service.category;

import com.duong.ss04.model.dto.category.CreateCategoryDTO;
import com.duong.ss04.model.dto.category.UpdateCategoryDTO;
import com.duong.ss04.model.entity.Category;
import com.duong.ss04.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> getAll() {
            return categoryRepo.findAll(Sort.by("id").descending());
    }

    @Override
    public boolean createCategory(CreateCategoryDTO dto) {
        // convert
        Category c = new Category();
        c.setName(dto.getName());

        try {
            categoryRepo.save(c);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateCategory(UpdateCategoryDTO dto) {
        Optional<Category> categoryOptional = categoryRepo.findById(dto.getId());
        if(categoryOptional.isEmpty()){
            System.err.println("không thấy category!");
            return false;
        }
        Category old = categoryOptional.get();

        if(!dto.getName().equals(old.getName())) old.setName(dto.getName());

        try {
            categoryRepo.save(old);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCategory(int id) {
        try {
            categoryRepo.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Category> findCategoryById(int id) {
        return categoryRepo.findById(id);
    }
}
