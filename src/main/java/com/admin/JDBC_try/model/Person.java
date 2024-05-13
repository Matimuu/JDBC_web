package com.admin.JDBC_try.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/07 19:07
 */
public class Person {
    /*
    Class entity to represent DB data.
     */

    //Variables.
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Integer id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    //Constructors.
    public Person() {

    }

    public Person(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(Integer id, String name, String surname, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    //Methods.
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person: " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate='" +  dateTimeFormatter.format(dateOfBirth) + '\'' +
                ", dateOfCreation='" + dateTimeFormatter.format(dateOfBirth) + "'\n";
    }
}
