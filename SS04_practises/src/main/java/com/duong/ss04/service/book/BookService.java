package com.duong.ss04.service.book;


import com.duong.ss04.model.dto.book.CreateBookDTO;
import com.duong.ss04.model.dto.book.UpdateBookDTO;
import com.duong.ss04.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll (int categoryId);
    boolean createBook (CreateBookDTO dto);
    boolean updateBook (UpdateBookDTO dto);
    boolean deleteBook (int id);
    Optional<Book> findBookById (int id);
}
