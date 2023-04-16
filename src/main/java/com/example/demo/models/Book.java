package com.example.demo.models;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_book")
    private String nameBook;
    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "author_book")
    private Integer authorBook;
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

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Integer getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(Integer authorBook) {
        this.authorBook = authorBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", authorBook=" + authorBook +
                '}';
    }
}
