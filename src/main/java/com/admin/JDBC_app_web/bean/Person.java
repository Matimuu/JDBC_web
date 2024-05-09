package com.admin.JDBC_app_web.bean;

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
    private int id;
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

    public Person(int id, String name, String surname, LocalDate dateOfBirth) {
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

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person [");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", surname=").append(surname);
        if (dateOfBirth != null) {
            sb.append(", dateOfBirth=").append(dateOfBirth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else {
            sb.append(", dateOfBirth=null");
        }
        sb.append("]");
        return sb.toString();
    }
//    @Override
//    public String toString() {
//        return "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", birthDate='" +  dateTimeFormatter.format(dateOfBirth) + '\'' +
//                ", dateOfCreation='" + dateTimeFormatter.format(dateOfCreation) + "'\n";
//    }
}
