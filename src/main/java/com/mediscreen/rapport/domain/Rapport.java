package com.mediscreen.rapport.domain;

import com.mediscreen.rapport.constant.Assessment;
import com.mediscreen.rapport.constant.Sex;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Class materializing a patient diabetes risk assessment report.
 */
public class Rapport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private Sex sex;

    private Assessment assessment;

    public Rapport() {
    }

    public Rapport(String lastName, String firstName, LocalDate dateOfBirth, Sex sex, Assessment assessment) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.assessment = assessment;
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

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }
}
