package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;

public class Reader_example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_issue")
    private Date dateIssue;

    @Column(name = "date_return")
    private Date dateReturn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Reader_example{" +
                "id=" + id +
                ", dateIssue=" + dateIssue +
                ", dateReturn=" + dateReturn +
                '}';
    }
}
