package com.duong.ss04_homeworks.service.hw01;

import com.duong.ss04_homeworks.dto.hw01.BookDTO;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<BookDTO> getAllBooks(String keyword, int page, int size);
    BookDTO getById(int id);
    void save(BookDTO dto);
    void update(BookDTO dto);
    void delete(int id);
}
