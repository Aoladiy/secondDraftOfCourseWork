package com.example.demo;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
public class Book {
    private Long id; // ID
    @Column(name = "name_book")
    private String nameBook; // Имя
    @Column(name = "publishing_house")
    private String publishingHouse; // Издательство
    @Column(name = "date_issue")
    private Date dateIssue; // дата выдачи
    @Column(name = "name_student")
    private String nameStudent; // имя студента
    @Column(name = "date_delivery")
    private Date dateDelivery; // средний балл

    protected Book() {
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

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Date getDateDelivery() {return dateDelivery;}

    public void setDateDelivery(Date dateDelivery) {this.dateDelivery = dateDelivery;}


    @Override
    public String toString() {
        return "student [id=" + id + ", nameBook=" + nameBook +", last=" + publishingHouse + ", dateIssue=" + dateIssue + ", nameStudent=" + nameStudent + ", dateDelivery=" + dateDelivery + "]";
    }
}
