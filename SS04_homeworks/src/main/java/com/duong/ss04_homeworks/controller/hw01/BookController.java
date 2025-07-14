package com.duong.ss04_homeworks.controller.hw01;

import com.duong.ss04_homeworks.dto.hw01.BookDTO;
import com.duong.ss04_homeworks.service.hw01.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
    @RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String listBooks(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            Model    model
    ) {
        Page<BookDTO> bookPage = bookService.getAllBooks(keyword, page, 5);
        model.addAttribute("bookPage", bookPage);
        model.addAttribute("keyword", keyword);
        return "book/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new BookDTO());
        return "book/add";
    }

    @PostMapping("/add")
    public String handleAdd(@ModelAttribute("book") BookDTO dto) {
        bookService.save(dto);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.getById(id));
        return "book/edit";
    }

    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute("book") BookDTO dto) {
        bookService.update(dto);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String handleDelete(@PathVariable int id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
