package com.duong.ss04.controller;

import com.duong.ss04.model.dto.category.CreateCategoryDTO;
import com.duong.ss04.model.dto.category.UpdateCategoryDTO;
import com.duong.ss04.model.entity.Category;
import com.duong.ss04.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final String redirectToList = "redirect:/categories";
    private final CategoryService categoryService;

    @GetMapping
    public String showList (Model model){
        model.addAttribute("categories",categoryService.getAll());
        return "category/list";
    }

    @GetMapping("/add")
    public String showAdd (Model model){
        model.addAttribute("createDTO",new CreateCategoryDTO());
        return "category/add";
    }

    @PostMapping("/add")
    public String handleAdd (@ModelAttribute("createDTO") CreateCategoryDTO dto){
        if(!categoryService.createCategory(dto)){
            return "category/add";
        }
        return redirectToList;
    }


    @GetMapping("/edit/{id}")
    public String showEdit (@PathVariable("id") int id, Model model){
        Optional<Category> categoryOptional = categoryService.findCategoryById(id);
        if(categoryOptional.isEmpty()){
            return "category/list";
        }

        Category c = categoryOptional.get();

        UpdateCategoryDTO dto = new UpdateCategoryDTO(
                c.getId(),
                c.getName()
        );

        model.addAttribute("editDTO",dto);
        return "category/edit";
    }

    @PostMapping("/edit")
    public String handleEdit (@ModelAttribute("editDTO") UpdateCategoryDTO dto){
        if(!categoryService.updateCategory(dto)){
            return "category/edit";
        }
        return redirectToList;
    }
    @GetMapping("/delete/{id}")
    public String handleDelete (@PathVariable("id") int id){
        if(!categoryService.deleteCategory(id)){
            return "category/list";
        }
        return redirectToList;
    }
}
