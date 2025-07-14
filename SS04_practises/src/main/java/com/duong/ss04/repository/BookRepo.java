package com.duong.ss04.repository;

import com.duong.ss04.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> findBooksByCategory_Id(Integer categoryId);
}
