package com.example.demo.models;

import jakarta.persistence.*;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_book")
    private String nameBook;
    @Column(name = "genre")
    private String genre;
    @Column(name = "author")
    private String author;
    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", genre='" + genre + '\'' +
                ", author='" + author + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
