package com.duong.ss04_homeworks.service.hw01;

import com.duong.ss04_homeworks.dto.hw01.BookDTO;
import com.duong.ss04_homeworks.entity.Book;
import com.duong.ss04_homeworks.repository.hw01.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    private BookDTO convertToDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getYear());
    }

    private Book convertToEntity(BookDTO dto) {
        return new Book(dto.getId(), dto.getTitle(), dto.getAuthor(), dto.getPublisher(), dto.getYear());
    }

    @Override
    public Page<BookDTO> getAllBooks(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Book> bookPage;

        if (keyword != null && !keyword.isBlank()) {
            bookPage = bookRepo.findByTitleContainingIgnoreCase(keyword, pageable);
        } else {
            bookPage = bookRepo.findAll(pageable);
        }

        return bookPage.map(this::convertToDTO);
    }

    @Override
    public BookDTO getById(int id) {
        return bookRepo.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public void save(BookDTO dto) {
        bookRepo.save(convertToEntity(dto));
    }

    @Override
    public void update(BookDTO dto) {
        bookRepo.save(convertToEntity(dto));
    }

    @Override
    public void delete(int id) {
        bookRepo.deleteById(id);
    }
}
