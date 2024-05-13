package com.admin.dao;

import com.admin.JDBC_try.dao.DAO;
import com.admin.JDBC_try.dao.DAOimpl;
import com.admin.JDBC_try.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 14:05
 */
class DAOTest {
    private DriverManagerDataSource dataSource;
    private DAO dao;
    @BeforeEach
    void setupBeforeEach() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:8889/JDBC_app");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        dao = new DAOimpl(dataSource);
    }
    @org.junit.jupiter.api.Test
    void save() {
        Person person = new Person("Omar","Mendoza", LocalDate.of(2000,10,28));

        int result = dao.save(person);
        assertTrue(result>0);
    }

    @org.junit.jupiter.api.Test
    void update() {
        Person person = new Person(13,"Omar Enrique","Mendoza", LocalDate.of(2000,10,28));

        int result = dao.update(person);
        assertTrue(result>0);
    }

    @org.junit.jupiter.api.Test
    void get() {
        int id = 11;
        Person person = dao.get(id);

        if (person != null) System.out.println(person);

        assertNotNull(person);
    }

    @org.junit.jupiter.api.Test
    void delete() {
        int id = 13;
        assertTrue(dao.delete(id)>0);
    }

    @org.junit.jupiter.api.Test
    void list() {
        List<Person> personList = dao.list();
        personList.forEach(System.out::println);

        assertFalse(personList.isEmpty());
    }
}