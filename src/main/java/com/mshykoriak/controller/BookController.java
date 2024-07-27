package com.mshykoriak.controller;

import com.mshykoriak.entity.Book;
import com.mshykoriak.service.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private static final String MAIN_PAGE = "index";

    private BookService bookService;

    @GetMapping("/")
    public String showBookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("book", new Book());
        return MAIN_PAGE;
    }

    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            logger.info("Post request /addBook failed");
            return MAIN_PAGE;
        }
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("book", new Book());
        bookService.addOrUpdate(book);
        return "redirect:/";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") Long id, Model model) {
        bookService.deleteById(id);
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("book", new Book());
        return "redirect:/";
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
