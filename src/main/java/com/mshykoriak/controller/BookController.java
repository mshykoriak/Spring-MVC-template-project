package com.mshykoriak.controller;

import com.mshykoriak.dto.BookDto;
import com.mshykoriak.entity.Book;
import com.mshykoriak.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private static final String MAIN_PAGE = "index";

    private BookRepository bookRepository;

    @GetMapping("/")
    public String showBookList(Model model) {
        model.addAttribute("bookList", bookRepository.findAll());
        model.addAttribute("book", new Book());
        return MAIN_PAGE;
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book, BindingResult result, Model model) {
        model.addAttribute("bookList", bookRepository.findAll());
        bookRepository.save(book);
        return MAIN_PAGE;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
