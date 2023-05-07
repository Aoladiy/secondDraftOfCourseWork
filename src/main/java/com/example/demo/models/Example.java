package com.example.demo.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий сущность Пример.
 */
@Entity
public class Example {

    /**
     * Уникальный идентификатор примера.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Идентификатор книги, связанной с примером.
     */
    @Column(name = "book_id")
    private Integer bookId;

    /**
     * Идентификатор читателя, связанного с примером.
     */
    @Column(name = "reader_id")
    private Integer readerId;

    /**
     * Особенности примера.
     */
    @Column(name = "distinctive_features", columnDefinition = "TEXT")
    private String distinctiveFeatures;

    /**
     * Дата выдачи примера.
     */
    @Column(name = "date_issue")
    private Date dateIssue;

    /**
     * Дата возврата примера.
     */
    @Column(name = "date_return")
    private Date dateReturn;

    public Example() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public String getDistinctiveFeatures() {
        return distinctiveFeatures;
    }

    public void setDistinctiveFeatures(String distinctiveFeatures) {
        this.distinctiveFeatures = distinctiveFeatures;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(Date dateReturn) {
        this.dateReturn = dateReturn;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", distinctiveFeatures='" + distinctiveFeatures + '\'' +
                ", dateIssue=" + dateIssue +
                ", dateReturn=" + dateReturn +
                '}';
    }
}