package com.mshykoriak.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 100, message = "Name length must be in range from 5 characters to 100.")
    private String name;
    @NotBlank(message = "Author is required")
    @Size(min = 3, max = 50, message = "Author field length must be in range from 3 characters to 50.")
    private String author;
    @NotBlank(message = "Language is required")
    @Size(min = 3, max = 20, message = "Language field length must be in range from 3 to 20.")
    private String language;
    private int numberOfPages;

    public Book() {
    }

    public Book(String name, String author, String language, int numberOfPages) {
        this.name = name;
        this.author = author;
        this.language = language;
        this.numberOfPages = numberOfPages;
    }

    public Book(Integer id, String name, String author, String language, int numberOfPages) {
        this(name, author, language, numberOfPages);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(id, book.id) && Objects.equals(name, book.name) && Objects.equals(author, book.author) && Objects.equals(language, book.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, language, numberOfPages);
    }
}
