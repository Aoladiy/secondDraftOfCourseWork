package com.example.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @ManyToMany
    private List<Book> books = new ArrayList<Book>();

    @OneToOne(mappedBy = "example")
    private Reader reader;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", bookId=" + bookId +
                '}';
    }
}
