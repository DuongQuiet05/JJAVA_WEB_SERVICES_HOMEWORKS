package com.duong.ss04.controller;

import com.duong.ss04.model.dto.book.CreateBookDTO;
import com.duong.ss04.model.dto.book.UpdateBookDTO;
import com.duong.ss04.model.entity.Book;
import com.duong.ss04.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categories/detail/{cateId}")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public String showBooksByCategory(@PathVariable("cateId") int cateId, Model model) {
        model.addAttribute("cateId", cateId);
        model.addAttribute("books", bookService.getAll(cateId));
        return "book/list";
    }

    @GetMapping("/add")
    public String showAddForm(@PathVariable("cateId") int cateId, Model model) {
        CreateBookDTO dto = new CreateBookDTO();
        dto.setCategoryId(cateId);

        model.addAttribute("cateId", cateId);
        model.addAttribute("book", dto);
        return "book/add";
    }

    @PostMapping("/add")
    public String handleAddBook(@PathVariable("cateId") int cateId,
                                @ModelAttribute("book") CreateBookDTO dto) {
        dto.setCategoryId(cateId);
        bookService.createBook(dto);
        return "redirect:/categories/detail/" + cateId;
    }

    @GetMapping("/edit/{bookId}")
    public String showEditForm(@PathVariable("cateId") int cateId,
                               @PathVariable("bookId") int bookId,
                               Model model) {

        Optional<Book> optionalBook = bookService.findBookById(bookId);
        if (optionalBook.isEmpty()) {
            return "redirect:/categories/detail/" + cateId; // fallback
        }

        Book book = optionalBook.get();
        UpdateBookDTO dto = new UpdateBookDTO(
                book.getId(),
                book.getCategory().getId(),
                book.getName(),
                book.getAuthor(),
                book.getPublisher(),
                book.getPublicYear(),
                book.getPrice()
        );

        model.addAttribute("cateId", cateId);
        model.addAttribute("book", dto);
        return "book/edit";
    }

    @PostMapping("/edit/{bookId}")
    public String handleEdit(@PathVariable("cateId") int cateId,
                             @PathVariable("bookId") int bookId,
                             @ModelAttribute("book") UpdateBookDTO dto) {
        dto.setId(bookId);
        dto.setCategoryId(cateId);
        bookService.updateBook(dto);
        return "redirect:/categories/detail/" + cateId;
    }

    @GetMapping("/delete/{bookId}")
    public String handleDelete(@PathVariable("cateId") int cateId,
                               @PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/categories/detail/" + cateId;
    }
}
