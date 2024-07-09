package com.mshykoriak.controller;

import com.mshykoriak.entity.Book;
import com.mshykoriak.repository.BookRepository;
import com.mshykoriak.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    private static final String MAIN_PAGE = "index";

    private BookService bookService;

    @GetMapping("/")
    public String showBookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("book", new Book());
        return MAIN_PAGE;
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book, BindingResult result, Model model) {
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("book", new Book());
        //Book entity = bookRepository.findById(book.getId().longValue()).orElse(null);
//        if (entity == null) {
//
//        }
        bookService.addOrUpdate(book);
        return "redirect:/";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") Long id, Model model) {
        bookService.deleteById(Long.valueOf(id));
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("book", new Book());
        return "redirect:/";
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
