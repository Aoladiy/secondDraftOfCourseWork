package com.example.demo.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Book {
    private Long id;
    @Column(name = "name_book")
    private String nameBook;
    @Column(name = "publishing_house")
    private String publishingHouse;

    @ManyToMany
    private List<Author> authors = new ArrayList<Author>();

    @ManyToMany
    private List<Genre> genres = new ArrayList<Genre>();

    @OneToMany(mappedBy = "Example")
    private List<Example> examples;

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


//    @Override
//    public String toString() {
//        return "book [id=" + id + ", nameBook=" + nameBook +", publishingHouse=" + publishingHouse + "]";
//    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", authors=" + authors +
                ", genres=" + genres +
                ", examples=" + examples +
                '}';
    }
}
