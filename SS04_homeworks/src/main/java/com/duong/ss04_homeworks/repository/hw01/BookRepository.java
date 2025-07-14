package com.duong.ss04_homeworks.repository.hw01;

import com.duong.ss04_homeworks.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
