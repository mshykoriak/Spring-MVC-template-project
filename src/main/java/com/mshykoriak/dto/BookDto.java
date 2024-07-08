package com.mshykoriak.dto;

import java.util.Objects;

public class BookDto {

    private int id;
    private String name;
    private String author;
    private String language;
    private int numberOfPages;


    public BookDto() {
    }

    public BookDto(int id, String name, String author, String language, int numberOfPages) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.language = language;
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
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
        BookDto bookDto = (BookDto) o;
        return id == bookDto.id && numberOfPages == bookDto.numberOfPages && Objects.equals(name, bookDto.name) && Objects.equals(author, bookDto.author) && Objects.equals(language, bookDto.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, language, numberOfPages);
    }
}
