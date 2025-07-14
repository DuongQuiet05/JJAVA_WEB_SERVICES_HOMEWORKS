package com.duong.ss04_homeworks.controller.hw03;

import com.duong.ss04_homeworks.dto.hw03.FoodItemDTO;
import com.duong.ss04_homeworks.entity.FoodItem;
import com.duong.ss04_homeworks.repository.hw03.CategoryRepository;
import com.duong.ss04_homeworks.service.hw03.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodItemController {

    private final FoodItemService foodService;
    private final CategoryRepository categoryRepo;

    @GetMapping
    public String list(@RequestParam(defaultValue = "") String keyword,
                       @RequestParam(required = false) Integer categoryId,
                       @RequestParam(defaultValue = "0") int page,
                       Model model) {
        Page<FoodItem> foodPage = foodService.search(keyword, categoryId, page, 5);
        model.addAttribute("foodPage", foodPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("categories", categoryRepo.findAll());
        return "food/list";
    }

    @GetMapping("/add")
    public String showAdd(Model model) {
        model.addAttribute("food", new FoodItemDTO());
        model.addAttribute("categories", categoryRepo.findAll());
        return "food/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("food") FoodItemDTO dto) {
        foodService.save(dto);
        return "redirect:/foods";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        FoodItem f = foodService.getById(id);
        FoodItemDTO dto = new FoodItemDTO(f.getId(), f.getName(), f.getCategory().getId(), f.getPrice(), f.getExpirationDate());
        model.addAttribute("food", dto);
        model.addAttribute("categories", categoryRepo.findAll());
        return "food/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("food") FoodItemDTO dto) {
        foodService.update(dto);
        return "redirect:/foods";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        foodService.delete(id);
        return "redirect:/foods";
    }
}
