package com.mediscreen.rapport.domain;


import com.mediscreen.rapport.constant.Sex;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class materializing a patient.
 */
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private Sex sex;
    private String homeAddress;
    private String phoneNumber;

    public Patient() {
    }

    public Patient(String lastName, String firstName, LocalDate dateOfBirth, Sex sex, String homeAddress, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
