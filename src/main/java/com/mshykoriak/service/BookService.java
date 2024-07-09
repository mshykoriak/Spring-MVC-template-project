package com.mshykoriak.service;

import com.mshykoriak.entity.Book;
import com.mshykoriak.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void addOrUpdate(Book entity) {
        bookRepository.save(entity);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
