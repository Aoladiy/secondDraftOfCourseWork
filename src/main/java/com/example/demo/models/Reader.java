package com.example.demo.models;

import jakarta.persistence.*;

import java.sql.Date;

/**
 * Класс, представляющий сущность Читатель.
 */
@Entity
public class Reader {

    /**
     * Уникальный идентификатор читателя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Полное имя читателя.
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * Дата рождения читателя.
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * Адрес читателя.
     */
    @Column(name = "address")
    private String address;

    /**
     * Номер телефона читателя.
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * Дата регистрации читателя.
     */
    @Column(name = "registration_date")
    private Date registrationDate;

    public Reader() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", registrationDate=" + registrationDate +
                '}';
    }
}