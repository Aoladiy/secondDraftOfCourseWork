package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "reader_example",
            joinColumns =
                    { @JoinColumn(name = "reader_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "example_id", referencedColumnName = "id") })
    private Example example;

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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
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
