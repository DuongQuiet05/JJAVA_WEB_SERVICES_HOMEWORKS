package com.duong.ss04.service.book;

import com.duong.ss04.model.dto.book.CreateBookDTO;
import com.duong.ss04.model.dto.book.UpdateBookDTO;
import com.duong.ss04.model.entity.Book;
import com.duong.ss04.model.entity.Category;
import com.duong.ss04.repository.BookRepo;
import com.duong.ss04.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepo bookRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public List<Book> getAll(int categoryId) {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
        if(categoryOptional.isEmpty()) {
            System.err.println("cannot find category_id to show list!");
            return new ArrayList<>();
        };

        return bookRepo.findBooksByCategory_Id(categoryId);
    }

    @Override
    public boolean createBook(CreateBookDTO dto) {
        // kiẻm tra id cate
        Optional<Category> categoryOptional = categoryRepo.findById(dto.getCategoryId());
        if(categoryOptional.isEmpty()) return false;

        Book newBook = new Book();
        newBook.setName(dto.getName());
        newBook.setAuthor(dto.getAuthor());
        newBook.setPrice(dto.getPrice());
        newBook.setPublicYear(dto.getPublicYear());
        newBook.setCategory(categoryOptional.get());


        try {
            bookRepo.save(newBook);
            return  true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateBook(UpdateBookDTO dto) {
        Optional<Category> categoryOptional = categoryRepo.findById(dto.getCategoryId());
        if(categoryOptional.isEmpty()) return false;

        Optional<Book> bookOptional = bookRepo.findById(dto.getId());
        if(bookOptional.isEmpty()) return false;

        Book old = bookOptional.get();

        if (!Objects.equals(old.getName(), dto.getName())) {
            old.setName(dto.getName());
        }

        if (!Objects.equals(old.getAuthor(), dto.getAuthor())) {
            old.setAuthor(dto.getAuthor());
        }

        if (!Objects.equals(old.getPublisher(), dto.getPublisher())) {
            old.setPublisher(dto.getPublisher());
        }

        if (!Objects.equals(old.getPublicYear(), dto.getPublicYear())) {
            old.setPublicYear(dto.getPublicYear());
        }

        if (!Objects.equals(old.getPrice(), dto.getPrice())) {
            old.setPrice(dto.getPrice());
        }

        if (old.getCategory() == null || !Objects.equals(old.getCategory().getId(), dto.getCategoryId())) {
            old.setCategory(categoryOptional.get());
        }


        try {
            bookRepo.save(old);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteBook(int id) {
        try {
            bookRepo.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Book> findBookById(int id) {
        return bookRepo.findById(id);
    }
}
