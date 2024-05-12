package com.admin.JDBC_try.dao;


import com.admin.JDBC_try.model.Person;

import java.util.List;


/**
 * @author Mendoza Perez Omar Enrique
 * @date 2024/05/12 13:46
 */
public interface DAO {
    public int save(Person p);
    public int update(Person p);
    public Person get(int id);
    public int delete(int id);
    public List<Person> list();
}
